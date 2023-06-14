package com.sangtb.appbanhang_firebase.ui.fragment.onboard.profile

import androidx.fragment.app.viewModels
import com.sangtb.androidlibrary.base.BaseFragment
import com.sangtb.appbanhang_firebase.R
import com.sangtb.appbanhang_firebase.databinding.FragmentProfileBinding

class FragmentProfile : BaseFragment<FragmentProfileBinding,ProfileViewModel>() {
    override val layoutId = R.layout.fragment_profile
    override val viewModel: ProfileViewModel by viewModels()
}