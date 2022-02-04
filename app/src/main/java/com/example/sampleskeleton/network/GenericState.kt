package com.example.sampleskeleton.network

//A helper class to handle states
data class GenericState<out T>(val status: GenericStatus, val data: T?, val message: String = "") {

    companion object {

        fun <T> success(data: T?): GenericState<T> {
            return GenericState(GenericStatus.SUCCESS, data)
        }

        fun <T> error(message: String): GenericState<T> {
            return GenericState(GenericStatus.ERROR, null, message)
        }

        fun <T> loading(): GenericState<T> {
            return GenericState(GenericStatus.LOADING, null)
        }

    }

}


enum class GenericStatus {
    SUCCESS,
    ERROR,
    LOADING,
    IDLE
}