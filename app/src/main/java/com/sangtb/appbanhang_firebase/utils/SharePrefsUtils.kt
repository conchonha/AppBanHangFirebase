package com.sangtb.appbanhang_firebase.utils

import com.sangtb.androidlibrary.utils.SharePrefs

object SharePrefsUtils {
    private val sharePrefs = SharePrefs.getInstance()

    fun isLogin() = sharePrefs.get<Boolean>(Const.IS_LOGIN) ?: false
}