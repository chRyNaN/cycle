package com.chrynan.presentation.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.coroutineScope
import com.chrynan.presentation.BasePresenter
import com.chrynan.presentation.Navigator
import com.chrynan.presentation.ScreenIntent
import kotlin.coroutines.CoroutineContext

abstract class BasePresentationActivity<SCREEN : ScreenIntent> : AppCompatActivity(),
    ActivityCoroutineScope,
    Navigator<SCREEN> {

    override val coroutineContext: CoroutineContext
        get() = lifecycle.coroutineScope.coroutineContext

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

    override fun goBack() {
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

    open fun goToFragment(fragment: BasePresentationFragment<*, *, *, *>, fragmentContainerId: Int) {
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
