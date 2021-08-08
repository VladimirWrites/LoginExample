package dev.vladimirj.login.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import dev.vladimirj.base.ui.observeEvent
import dev.vladimirj.login.ui.LoginViewModel.UiEvent.GoToHome
import dev.vladimirj.login.ui.databinding.FragmentLoginBinding
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment : Fragment(R.layout.fragment_login) {

    @Inject
    lateinit var navigator: LoginNavigator

    private val viewModel by viewModels<LoginViewModel>()
    private lateinit var binding: FragmentLoginBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)
        binding.viewModel = viewModel
        observeEvent(viewModel.uiEvents) {
            when (it) {
                is GoToHome -> navigator.goToHome(requireActivity())
                is LoginViewModel.UiEvent.ShowError -> Snackbar.make(
                    binding.buttonLogin as View,
                    it.message,
                    Snackbar.LENGTH_SHORT
                ).show()
            }
        }
        binding.lifecycleOwner = this
    }

    companion object {
        const val TAG = "LoginFragment"

        fun newInstance() = LoginFragment()
    }
}