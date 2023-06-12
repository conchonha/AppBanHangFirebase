package com.sangtb.appbanhang_firebase.ui.fragment.onboard

import android.app.Activity
import androidx.fragment.app.viewModels
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInApi
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.sangtb.androidlibrary.base.BaseFragment
import com.sangtb.androidlibrary.data.DialogData
import com.sangtb.appbanhang_firebase.R
import com.sangtb.appbanhang_firebase.databinding.FragmentEmailPassBinding
import com.sangtb.appbanhang_firebase.databinding.FragmentFaceBookBinding
import com.sangtb.appbanhang_firebase.databinding.FragmentGoogleBinding
import kotlinx.coroutines.handleCoroutineException

class FragmentGoogle : BaseFragment<FragmentGoogleBinding, AuthViewModel>() {
    override val layoutId = R.layout.fragment_google
    override val viewModel: AuthViewModel by viewModels()
    override fun onInit() {
       viewModel.signInWithGoogle(appLauncher,requireActivity())
    }
}