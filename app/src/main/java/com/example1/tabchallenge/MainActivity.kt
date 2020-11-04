package com.example1.tabchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val texts= listOf(
            "page1","page2","pag3"
        )
        val adapter=ViewPagerAdapter(texts)
        pager.adapter =adapter
        TabLayoutMediator(tabs,pager){ tab, position ->
           tab.text="Tab ${position +1}"
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