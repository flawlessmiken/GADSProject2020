package com.flawlessconcepts.gadsproject2020.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import com.flawlessconcepts.gadsproject2020.learningleaders.LearningLeaderFragment
import com.flawlessconcepts.gadsproject2020.skilliqleaders.SkillIQLeaderFragment
import java.lang.reflect.Array.newInstance
import java.util.*
import javax.xml.datatype.DatatypeFactory.newInstance


/**
 * Class that stores fragments for tabs
 */
class MyPagerAdapter(fm: FragmentManager?, private val fragments: ArrayList<Fragment>) :
    FragmentStatePagerAdapter(fm!!){
    private val mFragmentList: MutableList<Fragment> =
        ArrayList()

    override fun getItem(position: Int): Fragment {
        if (position == 0)
           return LearningLeaderFragment()
        else return SkillIQLeaderFragment()
    }

    override fun getCount(): Int {
        return fragments.size
    }
    override fun getPageTitle(position: Int): CharSequence {
        if (position == 0)
            return  "Learning Leaders"
        else return "Skill IQ Learders"
    }

    fun addFragment(fragment: Fragment) {
        mFragmentList.add(fragment)
    }
}