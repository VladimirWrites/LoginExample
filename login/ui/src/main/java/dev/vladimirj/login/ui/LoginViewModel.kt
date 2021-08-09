package dev.vladimirj.login.ui

import androidx.biometric.BiometricPrompt
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.vladimirj.base.ui.CoroutineDispatcherProvider
import dev.vladimirj.base.ui.Event
import dev.vladimirj.login.domain.entity.LoginResult
import dev.vladimirj.login.domain.usecase.*
import dev.vladimirj.login.ui.LoginViewModel.UiEvent.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.crypto.Cipher
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val login: Login,
    private val getCipherForEncryption: GetCipherForEncryption,
    private val getCipherForDecryption: GetCipherForDecryption,
    private val encryptAndSaveUid: EncryptAndSaveUid,
    private val decryptData: DecryptData,
    private val isCiphertextSaved: IsCiphertextSaved,
    private val isAuthenticationSupported: IsAuthenticationSupported,
    private val dispatchers: CoroutineDispatcherProvider
) : ViewModel() {

    private val mutableUiEvents = MutableLiveData<Event<UiEvent>>()
    val uiEvents: LiveData<Event<UiEvent>> = mutableUiEvents

    val email = MutableLiveData("")
    val password = MutableLiveData("")

    val isLoading = ObservableBoolean(false)
    val isLoginEnabled = isLoginEnabled(email, password)

    init {
        if(isCiphertextSaved()) {
            val cipher = getCipherForDecryption()
            mutableUiEvents.postValue(Event(ShowBiometricLogin(cipher)))
        }
    }

    fun loginWithEmailAndPassword() {
        isLoading.set(true)
        viewModelScope.launch(dispatchers.io) {
            val result = login(email.value!!, password.value!!)
            withContext(dispatchers.main) {
                when(result) {
                    is LoginResult.Successful -> {
                        if(isAuthenticationSupported()) {
                            val cipher = getCipherForEncryption()
                            mutableUiEvents.postValue(Event(StoreUidForBiometricLogin(result.uid, cipher)))
                        } else {
                            mutableUiEvents.postValue(Event(GoToHome(result.uid)))
                        }
                    }
                    is LoginResult.Error -> {
                        mutableUiEvents.postValue(Event(ShowError(result.message)))
                    }
                }
                isLoading.set(false)
            }
        }
    }

    fun loginWithFacebook() {
        // TODO: Implement login with Facebook
    }

    fun loginWithGoogle() {
        // TODO: Implement login with Google
    }

    fun decipherUid(authResult: BiometricPrompt.AuthenticationResult) {
        if(authResult.cryptoObject?.cipher != null) {
            val uid = decryptData(authResult.cryptoObject!!.cipher!!)
            mutableUiEvents.postValue(Event(GoToHome(uid)))
        } else {
            // TODO: Show error/retry message
        }
    }

    fun encryptAndSaveUid(uid: String, authResult: BiometricPrompt.AuthenticationResult) {
        if(authResult.cryptoObject?.cipher != null) {
            encryptAndSaveUid(uid, authResult.cryptoObject!!.cipher!!)
            mutableUiEvents.postValue(Event(GoToHome(uid)))
        } else {
            // TODO: Show error/retry message
        }
    }

    fun proceedWithoutBiometricEncryption(uid: String) {
        mutableUiEvents.postValue(Event(GoToHome(uid)))
    }

    sealed class UiEvent {
        data class GoToHome(val uid: String): UiEvent()
        data class StoreUidForBiometricLogin(val uid: String, val cipher: Cipher): UiEvent()
        data class ShowBiometricLogin(val cipher: Cipher): UiEvent()
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