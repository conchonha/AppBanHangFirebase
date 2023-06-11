package com.sangtb.appbanhang_firebase.ui.fragment.onboard

import androidx.fragment.app.viewModels
import com.sangtb.androidlibrary.base.BaseFragment
import com.sangtb.appbanhang_firebase.R
import com.sangtb.appbanhang_firebase.databinding.FragmentEmailPassBinding
import com.sangtb.appbanhang_firebase.databinding.FragmentFaceBookBinding
import com.sangtb.appbanhang_firebase.databinding.FragmentGoogleBinding
import com.sangtb.appbanhang_firebase.databinding.FragmentPhoneBinding

class FragmentPhone : BaseFragment<FragmentPhoneBinding,AuthViewModel>() {
    override val layoutId = R.layout.fragment_phone
    override val viewModel: AuthViewModel by viewModels()
}