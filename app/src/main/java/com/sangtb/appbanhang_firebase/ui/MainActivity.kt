package com.sangtb.appbanhang_firebase.ui

import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuth.AuthStateListener
import com.sangtb.androidlibrary.base.BaseActivity
import com.sangtb.androidlibrary.data.DialogData
import com.sangtb.androidlibrary.utils.SharePrefs
import com.sangtb.appbanhang_firebase.R
import com.sangtb.appbanhang_firebase.databinding.ActivityMainBinding
import com.sangtb.appbanhang_firebase.utils.Const
import com.sangtb.appbanhang_firebase.utils.SharePrefsUtils

class MainActivity : BaseActivity<ActivityMainBinding>() {
    private val mAuth = FirebaseAuth.getInstance()

    override val fragmentContainerView = R.id.fragmentContainerView
    override val layoutId = R.layout.activity_main

    private val authListener = AuthStateListener {
        when {
            it.currentUser == null && SharePrefsUtils.isLogin() ->
                showAlertDialog(DialogData(
                    message = getString(R.string.token_het_han),
                    callback = {
                        navController.popBackStack(R.id.fragmentAuth, inclusive = true)
                        navController.navigate(R.id.fragmentAuth)
                    }
                ))

            it.currentUser == null -> {
                navController.popBackStack(R.id.fragmentAuth, inclusive = true)
                navController.navigate(R.id.fragmentAuth)
            }

            else -> {
                it.currentUser?.reload()?.addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Const.firebaseUser = it.currentUser
                        if (Const.firebaseUser?.isEmailVerified == true) {
                            SharePrefs.getInstance().put(Const.IS_LOGIN, true)
                            navController.navigate(R.id.fragmentProfile)
                        } else {
                            showAlertDialog(DialogData(
                                title = "You can verify Email Coutinue using service",
                                callback = {
                                    Const.firebaseUser?.sendEmailVerification()
                                }
                            ))
                        }
                    }
                }

            }
        }
    }

    override fun onStart() {
        super.onStart()
        mAuth.addAuthStateListener(authListener)
    }

    override fun onStop() {
        super.onStop()
        mAuth.removeAuthStateListener(authListener)
    }
}