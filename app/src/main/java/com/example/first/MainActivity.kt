package com.example.first

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.first.fragment.HomeFragment
import com.example.first.fragment.ProfileFragment
import com.example.first.fragment.SettingsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val homeFragment  = HomeFragment()
        val profileFragment = ProfileFragment()
        val settingFragment = SettingsFragment()
        setCurrentFragment(homeFragment)
        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home_icon -> setCurrentFragment(homeFragment)
                R.id.profile_icon -> setCurrentFragment(profileFragment)
                R.id.settings_icon -> setCurrentFragment(settingFragment)
            }
            true
        }
    }
    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frame_layout, fragment)
            commit()
        }
}