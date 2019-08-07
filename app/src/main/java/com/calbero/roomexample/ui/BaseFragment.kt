package com.calbero.roomexample.ui

import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    fun replaceFragment(fragment: BaseFragment, container: Int) {
        val fragmentTransaction = fragmentManager!!.beginTransaction()
        fragmentTransaction.replace(container, fragment).addToBackStack("fragment")
        fragmentTransaction.commitAllowingStateLoss()
    }

    override fun onResume() {
        super.onResume()
        (activity as BaseActivity).currentFragment = this
    }

}