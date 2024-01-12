package me.hd.xiaoliurenplus.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import me.hd.xiaoliurenplus.R
import me.hd.xiaoliurenplus.databinding.ActivityMainBinding
import me.hd.xiaoliurenplus.ui.adapter.MVP2Adapter
import me.hd.xiaoliurenplus.ui.fragment.HomeFragment
import me.hd.xiaoliurenplus.ui.fragment.SettingFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun getFragmentList(): MutableList<Fragment> {
        val fragmentList: MutableList<Fragment> = ArrayList()
        fragmentList.add(HomeFragment())
        fragmentList.add(SettingFragment())
        return fragmentList
    }

    private fun initView() {
        binding.mainViewPager2.adapter = MVP2Adapter(this, getFragmentList())
        binding.mainViewPager2.isUserInputEnabled = false
        binding.mainNavView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> binding.mainViewPager2.setCurrentItem(0, false)
                R.id.nav_setting -> binding.mainViewPager2.setCurrentItem(1, false)
            }
            true
        }
    }
}