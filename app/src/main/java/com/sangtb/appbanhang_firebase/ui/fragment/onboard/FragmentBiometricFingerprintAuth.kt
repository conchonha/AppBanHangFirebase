package com.sangtb.appbanhang_firebase.ui.fragment.onboard

import androidx.fragment.app.viewModels
import com.sangtb.androidlibrary.base.BaseFragment
import com.sangtb.appbanhang_firebase.R
import com.sangtb.appbanhang_firebase.databinding.FragmentBioMetricFingerprintAuthBinding

//xac thu van tay
class FragmentBiometricFingerprintAuth : BaseFragment<FragmentBioMetricFingerprintAuthBinding,AuthViewModel>(){
    override val layoutId: Int = R.layout.fragment_bio_metric_fingerprint_auth
    override val viewModel: AuthViewModel by viewModels()
}