package com.franktan.tripexp

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_trip_list.*

class ExpenseListActivity : AbstractTabBarActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expense_list)

        addBottomTabBar()
    }

    override fun addBottomTabBar() : Unit {
        currentTabId = R.id.tab_expenses
        bottomBar.setItems(R.xml.bottom_tabs)
        bottomBar.setDefaultTab(currentTabId)
        layoutActivityContainner.addView(bottomBar)
    }
}
