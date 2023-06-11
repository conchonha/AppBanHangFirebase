package com.sangtb.appbanhang_firebase.ui.fragment.onboard

import androidx.fragment.app.viewModels
import com.sangtb.androidlibrary.base.BaseFragment
import com.sangtb.appbanhang_firebase.R
import com.sangtb.appbanhang_firebase.databinding.FragmentEmailPassBinding
import com.sangtb.appbanhang_firebase.databinding.FragmentFaceBookBinding

class FragmentFaceBook : BaseFragment<FragmentFaceBookBinding,AuthViewModel>() {
    override val layoutId = R.layout.fragment_face_book
    override val viewModel: AuthViewModel by viewModels()
}