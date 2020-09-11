package com.flawlessconcepts.gadsproject2020

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.flawlessconcepts.gadsproject2020.databinding.ActivitySubmitBinding
import com.flawlessconcepts.gadsproject2020.network.SubmitApi
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class SubmitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submit)
        val binding =
            DataBindingUtil.setContentView<ActivitySubmitBinding>(this, R.layout.activity_submit)

        var firstName: String? = null
        var lastName: String? = null
        var email: String? = null
        var githuburl: String? = null



        binding.fabSubmit.setOnClickListener() {
            firstName = binding.edFirstname.text.toString()
            lastName = binding.edLastName.text.toString()
            email = binding.edEmail.text.toString()
            githuburl = binding.edGithub.text.toString()

            if (firstName.isNullOrEmpty() || lastName.isNullOrEmpty()
                || email.isNullOrEmpty() || githuburl.isNullOrEmpty()
            ) {
                Toast.makeText(
                    applicationContext,
                    "Please Enter Values Correctly",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                Toast.makeText(applicationContext, "Validated", Toast.LENGTH_LONG).show()
            }
        }


    }

    fun submit(firstName: String, lastName: String, email: String, githubUrl: String) {
            SubmitApi.retrofitService.submit(
                firstName,
                lastName,
                email,
                githubUrl
            ).enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    if (response.isSuccessful) {
                        Toast.makeText(
                            applicationContext,
                            "response"+ response.body(),
                            Toast.LENGTH_LONG
                        ).show()
                    } else {

                    }
                }
                override fun onFailure(call: Call<Void>, t: Throwable) {

                }
            })
        }


}