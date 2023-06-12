package com.sangtb.appbanhang_firebase.ui.fragment.onboard

import android.app.Activity
import android.app.Application
import android.util.Log
import androidx.core.os.bundleOf
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.ActionCodeSettings
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.sangtb.androidlibrary.base.BaseViewModel
import com.sangtb.androidlibrary.data.DialogData
import com.sangtb.androidlibrary.extension.or1
import com.sangtb.androidlibrary.permission.AppPermission
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
                R.id.fragmentEmailPassword, bundleOf(Const.IS_LOGIN_KEY to true)
            )

            2 -> navigateToDestination(R.id.fragmentFaceBook)
            3 -> navigateToDestination(R.id.fragmentGoogle)
            4 -> navigateToDestination(R.id.fragmentPhone)
            5 -> navigateToDestination(R.id.fragmentEmailLink)
            6 -> navigateToDestination(R.id.fragmentBiometricFingerprintAuth)
            else -> navigateToDestination(
                R.id.fragmentEmailPassword, bundleOf(Const.IS_LOGIN_KEY to false)
            )
        }
    }

    fun loginEmailPass() {
        if (!isLogin) {
            firebaseAuth.createUserWithEmailAndPassword(
                email.value.toString(), password.value.toString()
            ).addOnFailureListener {
                showDialogException(it)
            }
        } else {
            firebaseAuth.signInWithEmailAndPassword(
                email.value.toString(), password.value.toString()
            ).addOnFailureListener {
                showDialogExceptionWithReload(it) {
                    loginEmailPass()
                }
            }
        }
    }

    fun verifyEmailOtpCode() {
        val actionCodeSettings = ActionCodeSettings.newBuilder().setUrl("https://localhost/myapp")
            .setHandleCodeInApp(true)
            .setAndroidPackageName("com.sangtb.appbanhang_firebase", true, "1").build()

        firebaseAuth.sendSignInLinkToEmail(email.value.toString(), actionCodeSettings)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    // quá trình verify OPT xẽ do firebase thực hiện tự động , thành công
                    return@addOnCompleteListener
                }
            }
    }

    fun signInWithGoogle(appLauncher: AppPermission, activity: Activity) {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .requestId()
            .requestProfile()
            .build()

        val ggClient = GoogleSignIn.getClient(activity, gso)

        appLauncher.launcherIntent(ggClient.signInIntent) {
            if (it.resultCode == Activity.RESULT_OK) {
                GoogleSignIn.getSignedInAccountFromIntent(it.data)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            val authCredential: AuthCredential =
                                GoogleAuthProvider.getCredential(task.result.idToken, null)
                            firebaseAuth.signInWithCredential(authCredential)
                                .addOnFailureListener { e ->
                                    showDialogException(e)
                                }
                        } else {
                            task.exception?.let { e -> showDialogException(e) }
                        }
                    }
            }
        }
    }
}