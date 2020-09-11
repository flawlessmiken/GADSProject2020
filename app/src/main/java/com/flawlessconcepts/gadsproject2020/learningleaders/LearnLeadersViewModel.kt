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

package com.flawlessconcepts.gadsproject2020.learningleaders

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.flawlessconcepts.gadsproject2020.data.Learner
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
class LearnLeadersViewModel : ViewModel() {

    private val _status = MutableLiveData<GadsApiStatus>()

    val status: LiveData<GadsApiStatus>
        get() = _status

    private val _learners = MutableLiveData<List<Learner>>()
    val learners: LiveData<List<Learner>>
        get() = _learners

    /**
     * Call getLearnLeaders() on init so we can display status immediately.
     */
    init {
        getLearningLeaders()
    }

    /**
     * Sets the value of the status LiveData to the Mars API status.
     */
    private fun getLearningLeaders() {
        viewModelScope.launch {
            _status.value = GadsApiStatus.LOADING
            try {
                _learners.value = GadsApi.retrofitService.getLearningLeaders()
                _status.value = GadsApiStatus.DONE
            } catch (e: Exception) {
                _status.value = GadsApiStatus.ERROR
                _learners.value = ArrayList()
            }
        }
    }
}