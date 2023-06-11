package com.sangtb.appbanhang_firebase.ui.fragment.onboard

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.sangtb.androidlibrary.base.BaseViewModel
import com.sangtb.androidlibrary.network.retrofit.config.ExceptionType
import com.sangtb.appbanhang_firebase.R

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

    override fun onReload(type: ExceptionType) {
        loginEmailPass()
    }

    fun loginEmailPass() {
        firebaseAuth.createUserWithEmailAndPassword(
            email.value.toString(),
            password.value.toString()
        ).addOnFailureListener {
            handleException.exception.value = Pair(it.message.toString(), ExceptionType.OTHER)
        }
    }
}