package com.sangtb.appbanhang_firebase.ui.fragment.onboard

import androidx.fragment.app.viewModels
import com.sangtb.androidlibrary.base.BaseFragment
import com.sangtb.appbanhang_firebase.R
import com.sangtb.appbanhang_firebase.databinding.FragmentAuthBinding

class FragmentAuth : BaseFragment<FragmentAuthBinding, AuthViewModel>() {
    override val layoutId = R.layout.fragment_auth
    override val viewModel: AuthViewModel by viewModels()

    override fun onInit() {
        binding?.vm = viewModel
    }
}