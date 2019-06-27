package com.github.scrobot.coctaildb.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import io.reactivex.Flowable
import io.reactivex.Single
import java.util.concurrent.TimeUnit

fun Number.seconds() = Pair(this, TimeUnit.SECONDS)

fun<T> Flowable<T>.delay(p: Pair<Number, TimeUnit>): Flowable<T> {
    val (num, timeunit) = p
    return this.delay(num.toLong(), timeunit)
}

fun<T> Single<T>.delay(p: Pair<Number, TimeUnit>): Single<T> {
    val (num, timeunit) = p
    return this.delay(num.toLong(), timeunit)
}

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false) =
    LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)