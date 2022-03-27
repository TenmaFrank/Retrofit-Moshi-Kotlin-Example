package com.tenmafrank.smscodereceiver.model

import com.squareup.moshi.Json

data class CodeRequest (
    val email: String,
    val password : String
){
}