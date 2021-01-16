package com.gorlah.library

import org.slf4j.LoggerFactory
import kotlin.reflect.KClass

fun <T : Any> logger(kClass: KClass<T>) = LoggerFactory.getLogger(kClass.java)!!
