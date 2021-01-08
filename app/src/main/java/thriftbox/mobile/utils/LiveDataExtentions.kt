package thriftbox.mobile.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

fun <T> LiveData<T>.asMutable(): MutableLiveData<T> {
    return this as MutableLiveData<T>
}

fun <T> LiveData<T>.setValue(t: T) {
    (this as MutableLiveData<T>).setValue(t)
}