package com.tenmafrank.smscodereceiver.model

typealias Welcome = ArrayList<TestGetResponse>

data class TestGetResponse (
    val id: Long,
    val name: String,
    val description: String,
    val clients: List<Client>
)

data class Client (
    val id: Long,
    val name: String,
    val parental: String,
    val maternal: String,
    val birthday: String,
    val genre: String,
    val estateOfBirth: String,
    val postalCode: Any? = null,
    val colony: Any? = null,
    val countryOfBirth: Any? = null,
    val nacionality: Any? = null,
    val state: Any? = null,
    val password: Any? = null,
    val folio: String,
    val street: Any? = null,
    val stNumberEXT: Any? = null,
    val stNumberInt: Any? = null,
    val population: Any? = null,
    val idCompany: Long,
    val typeID: Long,
    val folioID: Any? = null,
    val civilStatus: Any? = null,
    val activity: Any? = null,
    val alias: Any? = null,
    val icu: Any? = null,
    val keys: List<Any?>,
    val acounts: List<Any?>,
    val notifications: List<Any?>,
    val phones: List<Phone>,
    val emails: List<Email>
)

data class Email (
    val id: Long,
    val email: String,
    val status: Long
)

data class Phone (
    val id: Long,
    val phoneNumber: String,
    val status: Long
)
