package dev.vladimirj.login.ui

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.biometric.BiometricPrompt
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import dev.vladimirj.base.ui.observeEvent
import dev.vladimirj.login.ui.LoginViewModel.UiEvent.*
import dev.vladimirj.login.ui.databinding.FragmentLoginBinding
import javax.crypto.Cipher
import javax.inject.Inject
import android.widget.TextView




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
                is GoToHome -> navigator.goToHome(requireActivity(), it.uid)
                is ShowError -> showError(it.message)
                is ShowBiometricLogin -> showBiometricPromptForDecryption(it.cipher)
                is StoreUidForBiometricLogin -> showBiometricPromptForEncryption(it.uid, it.cipher)
            }
        }
        binding.lifecycleOwner = this
    }

    private fun showError(message: String) {
        val snackbar = Snackbar.make(binding.layout, message, Snackbar.LENGTH_LONG)
        val layoutParams = CoordinatorLayout.LayoutParams(snackbar.view.layoutParams)
        layoutParams.gravity = Gravity.TOP
        snackbar.view.layoutParams = layoutParams
        snackbar.animationMode = BaseTransientBottomBar.ANIMATION_MODE_FADE
        snackbar.view.findViewById<TextView>(com.google.android.material.R.id.snackbar_text).maxLines = 4
        snackbar.show()
    }

    private fun showBiometricPromptForDecryption(cipher: Cipher) {
        val biometricPrompt = BiometricPromptUtils.createBiometricPrompt(
            requireActivity() as AppCompatActivity
        ) {
            binding.viewModel!!.decipherUid(it)
        }

        val promptInfo =
            BiometricPromptUtils.createPromptInfo(requireActivity() as AppCompatActivity)
        biometricPrompt.authenticate(promptInfo, BiometricPrompt.CryptoObject(cipher))
    }

    private fun showBiometricPromptForEncryption(uid: String, cipher: Cipher) {
        val biometricPrompt = BiometricPromptUtils.createBiometricPrompt(
            requireActivity() as AppCompatActivity,
            { binding.viewModel!!.proceedWithoutBiometricEncryption(uid) }
        ) {
            binding.viewModel!!.encryptAndSaveUid(uid, it)
        }
        val promptInfo =
            BiometricPromptUtils.createPromptInfo(requireActivity() as AppCompatActivity)
        biometricPrompt.authenticate(promptInfo, BiometricPrompt.CryptoObject(cipher))
    }

    companion object {
        const val TAG = "LoginFragment"

        fun newInstance() = LoginFragment()
    }
}