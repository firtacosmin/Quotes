package com.hawkeye.quotes.di.modules

import android.arch.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

/**
 * Created by firta on 7/24/2017.
 * The module that will define the keys that store the ViewModelsModule into the ViewModel map
 */

@MustBeDocumented
@Target(AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
internal annotation class ViewModelMapKey(val value: KClass<out ViewModel>)