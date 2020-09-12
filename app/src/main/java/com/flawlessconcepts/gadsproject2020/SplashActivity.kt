package com.flawlessconcepts.gadsproject2020

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.flawlessconcepts.gadsproject2020.databinding.ActivitySplashBinding


class SplashActivity : BaseActivity<ActivitySplashBinding, SplashActivityViewModel>() {

    override val mViewModel: SplashActivityViewModel
        get() = ViewModelProviders.of(this).get(SplashActivityViewModel::class.java)

    override fun getLayoutResId(): Int = R.layout.activity_splash


    override fun init() {

    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        window.statusBarColor = Color.TRANSPARENT
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }

    override fun initializeObservers() {
        mViewModel.mutableLiveData.observe(this, Observer {
            when (it) {
                is SplashActivityViewModel.SplashState.MainActivity -> {
                    application.startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }
            }
        })
    }

    }
