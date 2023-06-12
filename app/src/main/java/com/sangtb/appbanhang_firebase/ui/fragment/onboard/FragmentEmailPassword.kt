package com.sangtb.appbanhang_firebase.ui.fragment.onboard

import androidx.fragment.app.viewModels
import com.sangtb.androidlibrary.base.BaseFragment
import com.sangtb.appbanhang_firebase.R
import com.sangtb.appbanhang_firebase.databinding.FragmentEmailPassBinding
import com.sangtb.appbanhang_firebase.utils.Const

class FragmentEmailPassword : BaseFragment<FragmentEmailPassBinding, AuthViewModel>() {
    override val layoutId = R.layout.fragment_email_pass
    override val viewModel: AuthViewModel by viewModels()

    override fun onInit() {
        binding?.vm = viewModel
        viewModel.isLogin = arguments?.getBoolean(Const.IS_LOGIN_KEY, false) ?: false
    }
}