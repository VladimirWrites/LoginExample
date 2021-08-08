package dev.vladimirj.base.ui

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

fun <T : Any, L : LiveData<T>> LifecycleOwner.observe(liveData: L, body: (T?) -> Unit) {
    liveData.observe(this, Observer(body))
}

fun <T : Any, L : LiveData<Event<T>>> LifecycleOwner.observeEvent(eventLiveData: L, body: (T) -> Unit) {
    eventLiveData.observe(
        this,
        EventObserver {
            body(it)
        }
    )
}