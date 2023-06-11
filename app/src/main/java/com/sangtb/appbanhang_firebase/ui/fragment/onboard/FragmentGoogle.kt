package com.sangtb.appbanhang_firebase.ui.fragment.onboard

import androidx.fragment.app.viewModels
import com.sangtb.androidlibrary.base.BaseFragment
import com.sangtb.appbanhang_firebase.R
import com.sangtb.appbanhang_firebase.databinding.FragmentEmailPassBinding
import com.sangtb.appbanhang_firebase.databinding.FragmentFaceBookBinding
import com.sangtb.appbanhang_firebase.databinding.FragmentGoogleBinding

class FragmentGoogle : BaseFragment<FragmentGoogleBinding,AuthViewModel>() {
    override val layoutId = R.layout.fragment_google
    override val viewModel: AuthViewModel by viewModels()
}