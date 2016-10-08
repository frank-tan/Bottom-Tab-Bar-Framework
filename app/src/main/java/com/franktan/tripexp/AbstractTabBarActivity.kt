package com.franktan.tripexp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.TypedValue
import android.view.ViewGroup
import android.widget.RelativeLayout
import com.roughike.bottombar.BottomBar

abstract class AbstractTabBarActivity : AppCompatActivity() {
    private val INVALID_TAB_ID = -1
    protected lateinit var bottomBar: BottomBar
    protected var currentTabId = INVALID_TAB_ID

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBottomTabBar()
    }

    override fun onResume() {
        super.onResume()
        if (currentTabId != INVALID_TAB_ID) {
            bottomBar.selectTabWithId(currentTabId)
        }
    }

    override fun onBackPressed() {
        finishAffinity()
    }

    fun initBottomTabBar() : Unit {
        bottomBar = BottomBar(this)

        val layoutParam = RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, pixelFrom(60f).toInt());
        layoutParam.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM)
        bottomBar.layoutParams = layoutParam

        bottomBar.setOnTabSelectListener(fun(tabId): Unit {
            startTabActivity(tabId)
        })
    }

    abstract fun addBottomTabBar() : Unit

    fun startTabActivity(tabId: Int) : Unit {
        if (currentTabId == INVALID_TAB_ID || currentTabId == tabId) {
            return
        }

        val intent = intentFrom(tabId = tabId)
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
        startActivity(intent)
    }

    fun intentFrom(tabId: Int): Intent =
            when (tabId) {
                R.id.tab_trips -> Intent(this, TripListActivity::class.java)
                R.id.tab_expenses -> Intent(this, ExpenseListActivity::class.java)
                R.id.tab_categories -> Intent(this, CategoryListActivity::class.java)
                else -> throw IllegalStateException("Tab id is not defined")
            }

    fun pixelFrom(dp: Float): Float =
            TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.displayMetrics)

}
