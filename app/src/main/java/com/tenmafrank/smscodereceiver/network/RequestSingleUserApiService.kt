package com.tenmafrank.smscodereceiver.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.tenmafrank.smscodereceiver.model.CodeRequest
import com.tenmafrank.smscodereceiver.model.CodeResponse
import com.tenmafrank.smscodereceiver.model.singeUserResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

private const val BASE_URL = "https://reqres.in"

/**
 * Build the Moshi object that Retrofit will be using, making sure to add the Kotlin adapter for
 * full Kotlin compatibility.
 */
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

/**
 * Use the Retrofit builder to build a retrofit object using a Moshi converter with our Moshi
 * object.
 */
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

/**
 * A public interface that exposes the get method
 */
interface RequestSingleUserApiService {
    @GET("/api/users/{id}")
    suspend fun getSingleUser(@Path("id") id: String): Response<singeUserResponse>
}

/**
 * A public Api object that exposes the lazy-initialized Retrofit service
 */
object RequestSingleUserApi {
    val requestSingleUserRetrofitService: RequestSingleUserApiService by lazy {
        retrofit.create(RequestSingleUserApiService::class.java)
    }
}
