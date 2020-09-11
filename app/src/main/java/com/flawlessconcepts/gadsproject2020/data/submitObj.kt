package com.flawlessconcepts.gadsproject2020.data

import android.provider.ContactsContract
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import retrofit2.http.Field




data class submitObj(
    @SerializedName("entry.1877115667")
    @Expose
    val firstName: String,
    @SerializedName("entry.2006916086")
    @Expose
    val lastName: String,
    @SerializedName("entry.1824927963")
    @Expose
    val email: String,
    @SerializedName(" entry.284483984")
    @Expose
    val gitUrl: String
)