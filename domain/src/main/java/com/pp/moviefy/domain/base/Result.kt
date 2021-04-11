package com.pp.moviefy.domain.base

sealed class Result<out R> {

    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val error: Throwable? = null) : Result<Nothing>()

    fun isSuccessful() = this is Success

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$error]"
        }
    }
}

fun <T> Result<T>?.successOr(fallback: T): T {
    if (this == null) return fallback
    return (this as? Result.Success<T>)?.data ?: fallback
}

val <T> Result<T>.data: T?
    get() = (this as? Result.Success)?.data