package com.calbero.roomexample.ui.main

import android.os.Bundle
import com.calbero.roomexample.R
import com.calbero.roomexample.ui.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViewFragment(MainFragment())
        setupActionBar(R.id.toolbar) {
            subtitle = getString(R.string.subtitle)
        }
    }
}