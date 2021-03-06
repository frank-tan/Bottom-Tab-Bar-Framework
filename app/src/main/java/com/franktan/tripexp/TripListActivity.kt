package com.franktan.tripexp

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_trip_list.*

class TripListActivity : AbstractTabBarActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trip_list)

        addBottomTabBar()

        buttonShowDetail.setOnClickListener {
        }
    }

    override fun addBottomTabBar() : Unit {
        currentTabId = R.id.tab_trips
        bottomBar.setItems(R.xml.bottom_tabs)
        bottomBar.setDefaultTab(currentTabId)
        layoutActivityContainner.addView(bottomBar)
    }
}
