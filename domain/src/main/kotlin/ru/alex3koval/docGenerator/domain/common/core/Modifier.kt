package ru.alex3koval.docGenerator.domain.common.core

import kotlin.reflect.KClass

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Repeatable
annotation class Modifier(val clazz: KClass<*>)
