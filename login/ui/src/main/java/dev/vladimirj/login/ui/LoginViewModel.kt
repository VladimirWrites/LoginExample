package dev.vladimirj.login.ui

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.vladimirj.base.ui.CoroutineDispatcherProvider
import dev.vladimirj.base.ui.Event
import dev.vladimirj.login.domain.usecase.Login
import dev.vladimirj.login.domain.entity.LoginResult
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val login: Login,
    private val dispatchers: CoroutineDispatcherProvider
) : ViewModel() {

    private val mutableUiEvents = MutableLiveData<Event<UiEvent>>()
    val uiEvents: LiveData<Event<UiEvent>> = mutableUiEvents

    val email = MutableLiveData("")
    val password = MutableLiveData("")

    val isLoading = ObservableBoolean(false)
    val isLoginEnabled = isLoginEnabled(email, password)

    fun loginWithEmailAndPassword() {
        isLoading.set(true)
        viewModelScope.launch(dispatchers.io) {
            val result = login(email.value!!, password.value!!)
            withContext(dispatchers.main) {
                when(result) {
                    is LoginResult.Successful -> {
                        mutableUiEvents.postValue(Event(UiEvent.GoToHome))
                    }
                    is LoginResult.Error -> {
                        mutableUiEvents.postValue(Event(UiEvent.ShowError(result.message)))
                    }
                }
                isLoading.set(false)
            }
        }
    }

    sealed class UiEvent {
        object GoToHome: UiEvent()
        data class ShowError(val message: String): UiEvent()
    }

    private fun isLoginEnabled(email: LiveData<String>, password: LiveData<String>): LiveData<Boolean> {
        val emailNotEmpty = Transformations.map(email) { it.isNotEmpty() }
        val passwordNotEmpty = Transformations.map(password) { it.isNotEmpty() }

        val result = MediatorLiveData<Boolean>()

        val isLengthOfInputsGreaterThanZero = Observer<Boolean> {
            result.value = listOf(emailNotEmpty, passwordNotEmpty).all { it.value!! }
        }

        result.addSource(emailNotEmpty, isLengthOfInputsGreaterThanZero)
        result.addSource(passwordNotEmpty, isLengthOfInputsGreaterThanZero)

        return result
    }
}