package com.example.mteam.util

sealed class UiState <out  T>{
    //loading, success, failure
    object Loading: UiState<Nothing>() //we will show the progress bar only
    data class Success<out T>(val data: T): UiState<T>() // On Success we will return data (T) Generic "anyType"
    data class Failure(val error: String?): UiState<Nothing>()  // String to indicate failure message
}