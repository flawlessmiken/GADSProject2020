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

package com.flawlessconcepts.gadsproject2020

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.flawlessconcepts.gadsproject2020.adapters.LearnersRecyclerAdapter
import com.flawlessconcepts.gadsproject2020.adapters.SkillIQRecyclerAdapter
import com.flawlessconcepts.gadsproject2020.data.Learner
import com.flawlessconcepts.gadsproject2020.data.Skiller
import com.flawlessconcepts.gadsproject2020.learningleaders.GadsApiStatus

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {

    imgUrl?.let {
        val imgUri =
            imgUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(imgUri)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.loading_animation)
                    .error(R.drawable.ic_broken_image)
            )
            .into(imgView)
    }
}

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Learner>?) {
    val adapter = recyclerView.adapter as LearnersRecyclerAdapter
    adapter.submitList(data)
}

@BindingAdapter("listDataSkill")
fun bindRecyclerViewSkiller(recyclerView: RecyclerView, data: List<Skiller>?) {
    val adapter = recyclerView.adapter as SkillIQRecyclerAdapter
    adapter.submitList(data)
}


@BindingAdapter("setName")
fun TextView.setName(item: String) {
    text = item
}
@BindingAdapter("setHoursNCountry")
fun TextView.setHours(learner: Learner) {
    text = learner.hours.toString() + " Learning Hours, " + learner.country
}

@BindingAdapter("setScoreNCountry")
fun TextView.setHours(skiller: Skiller) {
    text = skiller.score.toString() + " Skill IQ Score, " + skiller.country
}


@BindingAdapter("gadsApistatus")
fun bindStatus(
    statusImageView: ImageView,
    status: GadsApiStatus?
) {

    when (status) {
        GadsApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        GadsApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        GadsApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
    }
}