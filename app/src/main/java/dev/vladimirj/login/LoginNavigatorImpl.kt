package dev.vladimirj.login

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import dev.vladimirj.home.ui.HomeFragment
import dev.vladimirj.login.ui.LoginFragment
import dev.vladimirj.login.ui.LoginNavigator

class LoginNavigatorImpl: LoginNavigator {

    override fun goToHome(activity: FragmentActivity) {
        navigateToFragment(
            activity,
            HomeFragment.newInstance(),
            HomeFragment.TAG
        )
    }

    override fun goToLogin(activity: FragmentActivity) {
        navigateToFragment(
            activity,
            LoginFragment.newInstance(),
            LoginFragment.TAG
        )
    }

    private fun navigateToFragment(activity: FragmentActivity, fragment: Fragment, tag: String, addToBackStack: Boolean = false) {
        val ft = activity.supportFragmentManager.beginTransaction()
        ft.replace(R.id.fragment_container, fragment, tag)
        if (addToBackStack) {
            ft.addToBackStack(tag)
        }
        ft.commit()
    }
}