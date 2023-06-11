package com.sangtb.appbanhang_firebase.utils

import com.sangtb.androidlibrary.base.BaseViewModel
import com.sangtb.androidlibrary.base.action.Callback
import com.sangtb.androidlibrary.data.DialogData
import java.lang.Exception

fun BaseViewModel.showDialogExceptionWithReload(exception: Exception, callback: Callback = null) {
    showDialogConfirm(
        DialogData(
            title = "Exception",
            message = exception.message.toString().plus("Do you want reload?"),
            isVisibleCancel = true,
            callback = callback,
        )
    )
}

fun BaseViewModel.showDialogException(exception: Exception) {
    showDialogConfirm(
        DialogData(
            title = "Exception",
            message = exception.message.toString(),
            callback = null,
        )
    )
}