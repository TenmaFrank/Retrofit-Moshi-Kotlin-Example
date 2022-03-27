package com.tenmafrank.smscodereceiver.model

import android.provider.ContactsContract

data class singeUserResponse (
    val data : Data,
    val support : Support
        ) {
    data class Data(val id : Int,
                    val email: String,
                    val first_name: String,
                    val last_name: String,
                    val avatar: String){}
    data class Support(val url: String,
                       val text: String){}
}