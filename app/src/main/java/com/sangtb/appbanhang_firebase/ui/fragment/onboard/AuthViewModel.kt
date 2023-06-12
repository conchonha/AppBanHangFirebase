package com.sangtb.appbanhang_firebase.ui.fragment.onboard

import android.app.Application
import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.core.os.bundleOf
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.ActionCodeSettings
import com.google.firebase.auth.FirebaseAuth
import com.sangtb.androidlibrary.base.BaseViewModel
import com.sangtb.androidlibrary.extension.or1
import com.sangtb.appbanhang_firebase.R
import com.sangtb.appbanhang_firebase.utils.Const
import com.sangtb.appbanhang_firebase.utils.showDialogException
import com.sangtb.appbanhang_firebase.utils.showDialogExceptionWithReload


class AuthViewModel(application: Application) : BaseViewModel(application) {
    private val firebaseAuth = FirebaseAuth.getInstance()
    val lblButton = MutableLiveData("Register")
    var isLogin = false
        set(value) {
            field = value
            lblButton.value = (!isLogin) or1 "Register" or2 "Login"
        }

    val email = MutableLiveData("")
    val password = MutableLiveData("")

    fun login(index: Int) {
        when (index) {
            1 -> navigateToDestination(
                R.id.fragmentEmailPassword,
                bundleOf(Const.IS_LOGIN_KEY to true)
            )

            2 -> navigateToDestination(R.id.fragmentFaceBook)
            3 -> navigateToDestination(R.id.fragmentGoogle)
            4 -> navigateToDestination(R.id.fragmentPhone)
            5 -> navigateToDestination(R.id.fragmentEmailLink)
            else -> navigateToDestination(
                R.id.fragmentEmailPassword,
                bundleOf(Const.IS_LOGIN_KEY to false)
            )
        }
    }

    fun loginEmailPass() {
        if (isLogin) {
            firebaseAuth.createUserWithEmailAndPassword(
                email.value.toString(),
                password.value.toString()
            ).addOnFailureListener {
                showDialogException(it)
            }
        } else {
            firebaseAuth.signInWithEmailAndPassword(
                email.value.toString(),
                password.value.toString()
            ).addOnFailureListener {
                showDialogExceptionWithReload(it) {
                    loginEmailPass()
                }
            }
        }
    }

    fun loginEmailLink() {
        val actionCodeSettings = ActionCodeSettings.newBuilder()
            .setUrl(FragmentEmailLink.REDIRECT_URI)
            .setHandleCodeInApp(true)
            .setAndroidPackageName("com.sangtb.appbanhang_firebase", true, "8")
            .build()

        firebaseAuth.sendSignInLinkToEmail(email.value.toString(), actionCodeSettings)
            .addOnCompleteListener {
                if(it.isSuccessful){
                    return@addOnCompleteListener
                }
                Log.d("SANGTBAAA", "loginEmailLink: ${it.exception}")
            }
    }
}