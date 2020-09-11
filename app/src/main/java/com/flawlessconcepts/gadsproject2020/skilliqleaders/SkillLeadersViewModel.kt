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

package com.flawlessconcepts.gadsproject2020.skilliqleaders

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.flawlessconcepts.gadsproject2020.data.Learner
import com.flawlessconcepts.gadsproject2020.data.Skiller
import com.flawlessconcepts.gadsproject2020.network.GadsApi
import kotlinx.coroutines.launch
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * The [ViewModel] that is attached to the [LeardersFragment].
 */
enum class GadsApiStatus { LOADING, ERROR, DONE }
class SkillLeadersViewModel : ViewModel() {

    private val _status = MutableLiveData<GadsApiStatus>()

    val status: LiveData<GadsApiStatus>
        get() = _status

    private val _skillers = MutableLiveData<List<Skiller>>()
    val skillers: LiveData<List<Skiller>>
        get() = _skillers

    /**
     * Call getLearnLeaders() on init so we can display status immediately.
     */
    init {
        getSkillIQLearders()
    }

    /**
     * Sets the value of the status LiveData to the Mars API status.
     */
    private fun getSkillIQLearders() {
        viewModelScope.launch {
            _status.value = GadsApiStatus.LOADING
            try {
                _skillers.value = GadsApi.retrofitService.getSkillIQLearders()
                _status.value = GadsApiStatus.DONE
            } catch (e: Exception) {
                _status.value = GadsApiStatus.ERROR
                _skillers.value = ArrayList()
            }
        }
    }
}