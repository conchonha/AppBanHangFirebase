package com.sangtb.appbanhang_firebase.ui.fragment.onboard

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.biometric.BiometricManager
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import com.sangtb.androidlibrary.base.BaseFragment
import com.sangtb.appbanhang_firebase.R
import androidx.biometric.BiometricPrompt
import com.sangtb.appbanhang_firebase.databinding.FragmentBioMetricFingerprintAuthBinding

//xac thu van tay
class FragmentBiometricFingerprintAuth :
    BaseFragment<FragmentBioMetricFingerprintAuthBinding, AuthViewModel>() {
    override val layoutId: Int = R.layout.fragment_bio_metric_fingerprint_auth
    override val viewModel: AuthViewModel by viewModels()

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onInit() {
        //nhận dangj sinh trắc học vân tay khuân mặt ,,,vv
        val biometricPrompt = createBiometricPrompt()
        val promptInfo = createPromptInfo()
        val canAuth = BiometricManager.from(requireContext())
            .canAuthenticate(BiometricManager.Authenticators.BIOMETRIC_STRONG or BiometricManager.Authenticators.DEVICE_CREDENTIAL)

        if (canAuth == BiometricManager.BIOMETRIC_SUCCESS) {
            biometricPrompt.authenticate(promptInfo)
        } else {
//            loginWithPassword()
        }
    }

    @RequiresApi(Build.VERSION_CODES.P)
    private fun createBiometricPrompt(): BiometricPrompt {
        val executor = ContextCompat.getMainExecutor(requireContext())

        val authenticationCallback = object : BiometricPrompt.AuthenticationCallback() {
            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                // Xác thực thành công
                showToast("Biometric authentication succeeded")
            }

            override fun onAuthenticationFailed() {
                // Xác thực thất bại
                showToast("Biometric authentication failed")
            }

            override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                // Lỗi xác thực
                showToast("Authentication error: $errString")
            }
        }

        return BiometricPrompt(this, executor, authenticationCallback)
    }

    private fun createPromptInfo(): BiometricPrompt.PromptInfo {
        val promptInfo =
            BiometricPrompt.PromptInfo.Builder().setTitle("Test ")
                .setSubtitle("Sub Title")
                .setDescription("Des")
                // Authenticate without requiring the user to press a "confirm"
                // button after satisfying the biometric check
                .setConfirmationRequired(false)
                .setNegativeButtonText("Cancel").build()
        return promptInfo
    }
}