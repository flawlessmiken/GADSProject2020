/*
 * Copyright 2019, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.flawlessconcepts.gadsproject2020.network


import com.flawlessconcepts.gadsproject2020.data.Learner
import com.flawlessconcepts.gadsproject2020.data.Skiller
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = " https://gadsapi.herokuapp.com/"


//private val moshi = Moshi.Builder()
//    .add(KotlinJsonAdapterFactory())
//    .build()


private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface GadsApiService {
    @GET("/api/hours")
    suspend fun getLearningLeaders():
            List<Learner>

    @GET(" /api/skilliq")
    suspend fun getSkillIQLearders():
            List<Skiller>
}

object GadsApi {
    val retrofitService: GadsApiService by lazy {
        retrofit.create(GadsApiService::class.java)
    }
}



