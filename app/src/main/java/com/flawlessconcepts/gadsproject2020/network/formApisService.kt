package com.flawlessconcepts.gadsproject2020.network

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.PUT


const val FULL_URL =
    "https://docs.google.com/forms/d/e/1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(FULL_URL)
    .build()

object SubmitApi {
    val retrofitService: submitService by lazy {
        retrofit.create(submitService::class.java)
    }
}

public interface submitService {
    @FormUrlEncoded
    @PUT()
    fun submit(
        @Field("entry.1877115667") firstname: String,
        @Field("entry.2006916086") lastname: String,
        @Field("entry.1824927963") email: String,
        @Field("entry.284483984") giturl: String
    ): Call<Void>
}