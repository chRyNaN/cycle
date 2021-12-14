@file:Suppress("unused")

package com.chrynan.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.coroutineScope
import kotlinx.coroutines.CoroutineScope

/**
 * An [AppCompatActivity] base class for the presentation library. This Activity helps structure an Android application
 * for use with the MVI Design Pattern using this presentation library. An Activity, is not a [View], but instead
 * coordinates [BasePresentationFragment]s which are [View] implementations.
 */
abstract class BasePresentationActivity : AppCompatActivity() {

    protected val coroutineScope: CoroutineScope
        get() = lifecycle.coroutineScope

    protected open val presenter: BasePresenter<*, *, *>? = null

    @Suppress("MemberVisibilityCanBePrivate")
    protected var currentFragment: BasePresentationFragment<*, *, *>? = null
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
                    supportFragmentManager.findFragmentById(currentFragmentContainerId) as? BasePresentationFragment<*, *, *>
            } else {
                super.onBackPressed()
            }
        }
    }

    open fun goToFragment(
        fragment: BasePresentationFragment<*, *, *>,
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
