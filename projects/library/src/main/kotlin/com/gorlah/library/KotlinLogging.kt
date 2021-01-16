package com.gorlah.library

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import kotlin.reflect.KClass

fun <T : Any> logger(kClass: KClass<T>): Logger = LoggerFactory.getLogger(kClass.java)
