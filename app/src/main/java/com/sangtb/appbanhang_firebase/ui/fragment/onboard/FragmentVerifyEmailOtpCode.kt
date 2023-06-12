package com.sangtb.appbanhang_firebase.ui.fragment.onboard

import androidx.fragment.app.viewModels
import com.sangtb.androidlibrary.base.BaseFragment
import com.sangtb.appbanhang_firebase.R
import com.sangtb.appbanhang_firebase.databinding.FragmentVerifyEmailOtpCodeBinding

class FragmentVerifyEmailOtpCode : BaseFragment<FragmentVerifyEmailOtpCodeBinding,AuthViewModel>() {
    override val layoutId = R.layout.fragment_verify_email_otp_code
    override val viewModel: AuthViewModel by viewModels()

    override fun onInit() {
        binding?.vm = viewModel
        binding?.buttonLogin?.setOnClickListener {
            viewModel.verifyEmailOtpCode()
        }
    }

    companion object{
        const val REDIRECT_URI = "https://auth.example.com/myapp"
    }
}