package com.apps.fullandroidcourseclassc.bullscarsapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.apps.fullandroidcourseclassc.R
import com.apps.fullandroidcourseclassc.bullscarsapp.utils.BullsCarsViewPagerAdapter
import com.apps.fullandroidcourseclassc.databinding.ActivityBullsCarsBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class BullsCarsActivity : Fragment() {
    lateinit var binding: ActivityBullsCarsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivityBullsCarsBinding.inflate(inflater, container, false)
        val view = binding.root
        val viewPager = view.findViewById<ViewPager2>(R.id.viewPagerBullsCars)
        val tabLayout = view.findViewById<TabLayout>(R.id.tabLayoutBullsCars)

        val listOfImages = listOf(
            R.drawable.bullsrentlogo,
            R.drawable.logo1,
            R.drawable.logo2,
            R.drawable.logo3
        )

        val myAdapter = BullsCarsViewPagerAdapter(listOfImages) // initialize adapter
        binding.viewPagerBullsCars.adapter = myAdapter // set the adapter on viewPager
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = "Tab ${position + 1}"
        }.attach()

        binding.tabLayoutBullsCars.addOnTabSelectedListener(object :
            TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                Toast.makeText(activity, "${tab?.text} Selected", Toast.LENGTH_SHORT).show()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Toast.makeText(activity, "${tab?.text} UN Selected", Toast.LENGTH_SHORT).show()
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                Toast.makeText(activity, "${tab?.text} RE Selected", Toast.LENGTH_SHORT).show()
            }

        })
        return view

    }
}