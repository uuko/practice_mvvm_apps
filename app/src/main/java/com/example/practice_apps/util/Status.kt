package com.example.practice_apps.util

class Status<T>(val status: StatusType, val data: T?, val message: String?) {

    enum class StatusType {
        INIT,SUCCESS, ERROR
    }

    companion object {
        fun <T> success(data: T?): Status<T> {
            return Status(StatusType.SUCCESS, data, null)
        }

        fun <T> error(message: String?, data: T?): Status<T> {
            return Status(StatusType.ERROR, data, message)
        }
    }
}