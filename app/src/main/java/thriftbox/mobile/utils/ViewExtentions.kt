package thriftbox.mobile.utils

import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE

fun View.setVisibility(isVisible: Boolean) {
    if (isVisible) {
        this.visibility = VISIBLE
    } else {
        this.visibility = INVISIBLE
    }
}