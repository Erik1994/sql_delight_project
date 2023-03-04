package com.example.sqldelightproject.util

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun <T> switchToIO(block: suspend () -> T) = withContext(Dispatchers.IO) { block() }
suspend fun <T> switchToBG(block: suspend () -> T) = withContext(Dispatchers.Default) { block() }
suspend fun <T> switchToMain(block: suspend () -> T) = withContext(Dispatchers.Main.immediate) { block() }