package com.sangtb.appbanhang_firebase.ui.fragment.onboard

import android.net.Uri
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sangtb.androidlibrary.base.BaseFragment
import com.sangtb.androidlibrary.extension.navigateDeepLink
import com.sangtb.appbanhang_firebase.R
import com.sangtb.appbanhang_firebase.databinding.FragmentAuthBinding

class FragmentAuth : BaseFragment<FragmentAuthBinding, AuthViewModel>() {
    override val layoutId = R.layout.fragment_auth
    override val viewModel: AuthViewModel by viewModels()

    override fun onInit() {
        binding?.vm = viewModel

//        findNavController().navigate(Uri.parse("https://sangtb.com/myapp/deeplink"))
    }
}