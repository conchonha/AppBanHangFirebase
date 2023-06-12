package com.sangtb.appbanhang_firebase.ui.fragment.onboard

import androidx.fragment.app.viewModels
import com.sangtb.androidlibrary.base.BaseFragment
import com.sangtb.appbanhang_firebase.R
import com.sangtb.appbanhang_firebase.databinding.FragmentEmailLinkBinding
import com.sangtb.appbanhang_firebase.databinding.FragmentEmailPassBinding
import com.sangtb.appbanhang_firebase.databinding.FragmentFaceBookBinding

class FragmentEmailLink : BaseFragment<FragmentEmailLinkBinding,AuthViewModel>() {
    override val layoutId = R.layout.fragment_email_link
    override val viewModel: AuthViewModel by viewModels()

    override fun onInit() {
        binding?.vm = viewModel
        binding?.buttonLogin?.setOnClickListener {
            viewModel.loginEmailLink()
        }
    }

    companion object{
        const val REDIRECT_URI = "https://auth.example.com/myapp"
    }
}