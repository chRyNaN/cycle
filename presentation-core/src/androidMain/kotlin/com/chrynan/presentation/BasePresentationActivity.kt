@file:Suppress("unused")

package com.chrynan.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.coroutineScope
import com.chrynan.presentation.navigation.NavigationEventHandler
import com.chrynan.presentation.navigation.NavigationIntent
import kotlinx.coroutines.CoroutineScope

abstract class BasePresentationActivity<SCREEN : NavigationIntent> : AppCompatActivity(),
    NavigationEventHandler<SCREEN, AndroidNavigationScope> {

    val coroutineScope: CoroutineScope
        get() = lifecycle.coroutineScope

    protected open val presenter: BasePresenter<*, *, *>? = null

    @Suppress("MemberVisibilityCanBePrivate")
    protected var currentFragment: BasePresentationFragment<*, *, *, *>? = null
        private set

    private var currentFragmentContainerId: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter?.bind()
    }

    override fun onRestart() {
        super.onRestart()

        presenter?.bind()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        presenter?.unbind()

        super.onSaveInstanceState(outState)
    }

    override fun onDestroy() {
        presenter?.unbind()

        super.onDestroy()
    }

    override fun onBackPressed() {
        with(supportFragmentManager) {
            if (!isStateSaved && backStackEntryCount > 0) {
                popBackStack()

                currentFragment =
                    supportFragmentManager.findFragmentById(currentFragmentContainerId) as? BasePresentationFragment<*, *, *, *>
            } else {
                super.onBackPressed()
            }
        }
    }

    override fun AndroidNavigationScope.onGoBack() = onBackPressed()

    override fun AndroidNavigationScope.onGoUp() = onGoBack()

    open fun goToFragment(
        fragment: BasePresentationFragment<*, *, *, *>,
        fragmentContainerId: Int
    ) {
        supportFragmentManager.let {
            it.beginTransaction().apply {
                replace(fragmentContainerId, fragment)

                commitNow()

                currentFragment = fragment
                currentFragmentContainerId = fragmentContainerId
            }
        }
    }
}
