package com.example.fragmentswitcherdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import kotlinx.android.synthetic.main.widget_tab_bottom_main.*

class MainActivity : AppCompatActivity() {

    private val TAB_FITST = 0
    private val TAB_SECOND = 1
    private val TAB_THIRD = 2

    private var fragmentSwitcher: FragmentSwitcher? = null
    private var currentIndex = TAB_SECOND
    private var tabContainer: ViewGroup? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        tabContainer = findViewById(R.id.ll_tab_container)

        initFragmentSwitcher(savedInstanceState)

        initListener()
    }

    private fun initFragmentSwitcher(savedInstanceState: Bundle?) {
        fragmentSwitcher = FragmentSwitcher(supportFragmentManager, R.id.fl_container)
        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()
        val thirdFragment = ThirdFragment()
        fragmentSwitcher!!.addFragment(firstFragment, FirstFragment::class.java.simpleName)
        fragmentSwitcher!!.addFragment(secondFragment, SecondFragment::class.java.simpleName)
        fragmentSwitcher!!.addFragment(thirdFragment, ThirdFragment::class.java.simpleName)
        switchToTab(currentIndex)
    }

    private fun switchToTab(tabIndex: Int) {
        currentIndex = tabIndex
        fragmentSwitcher?.switchToFragment(tabIndex)

        for (i in 0 until tabContainer!!.childCount) {
            val selected = i == tabIndex
            tabContainer!!.getChildAt(i).isSelected = selected
        }
    }

    private fun initListener() {
        tv_first.setOnClickListener { switchToTab(TAB_FITST) }
        tv_second.setOnClickListener { switchToTab(TAB_SECOND) }
        tv_third.setOnClickListener { switchToTab(TAB_THIRD) }
    }
}
