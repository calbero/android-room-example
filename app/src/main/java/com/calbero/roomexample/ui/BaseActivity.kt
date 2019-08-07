package com.calbero.roomexample.ui

import androidx.annotation.IdRes
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.calbero.roomexample.R

abstract class BaseActivity : AppCompatActivity() {

    var currentFragment: BaseFragment? = null

    protected fun setupViewFragment(fragment: BaseFragment) {
        currentFragment = fragment
        supportFragmentManager.findFragmentById(R.id.contentFrame)
            ?: replaceFragmentInActivity(fragment, R.id.contentFrame)
    }

    private fun AppCompatActivity.replaceFragmentInActivity(fragment: BaseFragment, frameId: Int) {
        supportFragmentManager.transact {
            replace(frameId, fragment)
        }
    }

    private inline fun FragmentManager.transact(action: FragmentTransaction.() -> Unit) {
        beginTransaction().apply {
            action()
        }.commit()
    }

    fun AppCompatActivity.setupActionBar(@IdRes toolbarId: Int, action: ActionBar.() -> Unit) {
        setSupportActionBar(findViewById(toolbarId))
        supportActionBar?.run {
            setDisplayUseLogoEnabled(true)
            setTitle(R.string.app_name)
            action()
        }
    }
}