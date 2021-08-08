package dev.vladimirj.login

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import dev.vladimirj.home.ui.HomeFragment
import dev.vladimirj.login.ui.LoginFragment
import dev.vladimirj.login.ui.LoginNavigator

class LoginNavigatorImpl: LoginNavigator {

    override fun goToHome(activity: AppCompatActivity) {
        navigateToFragment(
            activity,
            HomeFragment.newInstance(),
            HomeFragment.TAG
        )
    }

    override fun goToLogin(activity: AppCompatActivity) {
        navigateToFragment(
            activity,
            LoginFragment.newInstance(),
            LoginFragment.TAG
        )
    }

    private fun navigateToFragment(activity: AppCompatActivity, fragment: Fragment, tag: String, addToBackStack: Boolean = false) {
        val ft = activity.supportFragmentManager.beginTransaction()
        ft.replace(R.id.fragment_container, fragment, tag)
        if (addToBackStack) {
            ft.addToBackStack(tag)
        }
        ft.commit()
    }
}