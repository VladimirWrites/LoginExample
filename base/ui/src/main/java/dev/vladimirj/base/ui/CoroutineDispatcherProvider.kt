package dev.vladimirj.base.ui

import kotlinx.coroutines.CoroutineDispatcher

class CoroutineDispatcherProvider(
    val main: CoroutineDispatcher,
    val io: CoroutineDispatcher
)