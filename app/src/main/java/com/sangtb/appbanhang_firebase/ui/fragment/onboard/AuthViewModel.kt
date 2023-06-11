package com.sangtb.appbanhang_firebase.ui.fragment.onboard

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.sangtb.androidlibrary.base.BaseViewModel
import com.sangtb.appbanhang_firebase.R
import com.sangtb.appbanhang_firebase.utils.showDialogException

class AuthViewModel(application: Application) : BaseViewModel(application) {
    private val firebaseAuth = FirebaseAuth.getInstance()

    val email = MutableLiveData("")
    val password = MutableLiveData("")

    fun login(index: Int) {
        when (index) {
            1 -> navigateToDestination(R.id.fragmentEmailPassword)
            2 -> navigateToDestination(R.id.fragmentFaceBook)
            3 -> navigateToDestination(R.id.fragmentGoogle)
            else -> navigateToDestination(R.id.fragmentPhone)
        }
    }

    fun loginEmailPass() {
        firebaseAuth.createUserWithEmailAndPassword(
            email.value.toString(),
            password.value.toString()
        ).addOnFailureListener {
            showDialogException(it)
        }
    }
}