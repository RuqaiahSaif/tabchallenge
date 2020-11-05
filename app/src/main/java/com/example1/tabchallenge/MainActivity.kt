package com.example1.tabchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var tabs: TabLayout
    private lateinit var pager: ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tabs = findViewById(R.id.tabs)
        pager = findViewById(R.id.pager)


        pager.adapter = object : FragmentStateAdapter(this) {
            override fun createFragment(position: Int): Fragment {
                return when (position) {
                    0 -> Fragment1.newInstance("First_Page")
                    1 -> Fragment1.newInstance("Second_Page")
                    2 -> Fragment1.newInstance("Third_Page")
                    else -> Fragment1.newInstance("FirstPage")

                }
            }

            override fun getItemCount(): Int {
                return 3
            }
        }

        TabLayoutMediator(tabs,pager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Tab 1"
                    tab.setIcon(R.drawable.ic_baseline_home_24)
                }
                1 -> {
                    tab.text = "Tab 2"
                    tab.setIcon(R.drawable.ic_baseline_favorite_24)
                }
                2 -> {
                    tab.text = "Tab 3"
                    tab.setIcon(R.drawable.ic_baseline_settings_24)
                }
                else -> null
            }


        }.attach()




        tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity,"reselected ${tab?.text}",Toast.LENGTH_LONG).show()

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity,"unselected ${tab?.text}",Toast.LENGTH_LONG).show()

            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
           Toast.makeText(this@MainActivity,"selected ${tab?.text}",Toast.LENGTH_LONG).show()
            }

        })
    }
}