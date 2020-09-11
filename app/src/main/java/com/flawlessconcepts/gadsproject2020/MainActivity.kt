package com.flawlessconcepts.gadsproject2020

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.flawlessconcepts.gadsproject2020.adapters.MyPagerAdapter
import com.flawlessconcepts.gadsproject2020.learningleaders.LearningLeaderFragment
import com.flawlessconcepts.gadsproject2020.skilliqleaders.SkillIQLeaderFragment
import com.google.android.material.button.MaterialButton
import com.google.android.material.tabs.TabLayout
import java.lang.String
import java.util.*

private lateinit var viewPager: ViewPager
private lateinit var pagerAdapter: MyPagerAdapter

private const val FIRST_FRAGMENT = 0
private const val SECOND_FRAGMENT = 1
private var mTabLayout: TabLayout? = null

private val mFragments: ArrayList<Fragment> = ArrayList<Fragment>()

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.viewpager_container)
        val mFirstFragment = LearningLeaderFragment()
        val mSecondFragment = SkillIQLeaderFragment()
        mTabLayout = findViewById(R.id.tabs_bottom)

        val submitButton: MaterialButton = findViewById(R.id.fab)
        submitButton.setOnClickListener(){
            openSubmitActivity()
        }




        mFragments.add(mFirstFragment)
        mFragments.add(mSecondFragment)

        pagerAdapter = MyPagerAdapter(supportFragmentManager,mFragments)
        viewPager.adapter = pagerAdapter
        mTabLayout!!.setupWithViewPager(viewPager)
        mTabLayout!!.setTabGravity(TabLayout.GRAVITY_CENTER)
       // mTabLayout!!.getTabAt(0).text("Learning Leaders")






        val adapter = MyPagerAdapter(supportFragmentManager,mFragments)

//        if (mFragments != null) {
//            for (i in mFragments.indices) {
//                mFragments[i].fragment?.let { adapter.addFragment(it) }
//            }
//            viewPager.setAdapter(adapter)
//        }
    }

    fun openSubmitActivity(){
        applicationContext.startActivity(Intent(this, SubmitActivity::class.java))
    }
}