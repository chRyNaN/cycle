@file:Suppress("unused")

package com.chrynan.presentation.android

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.chrynan.presentation.*
import kotlin.coroutines.CoroutineContext

abstract class BasePresentationFragment<INTENT : Intent, STATE : State, CHANGE : Change, SCREEN : ScreenIntent> :
    Fragment(),
    View<INTENT, STATE>,
    Navigator<SCREEN>,
    FragmentCoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = lifecycleScope.coroutineContext

    protected open val presenter: BasePresenter<INTENT, STATE, CHANGE>? = null

    protected val currentState: STATE
        get() = presenter?.currentState ?: renderState

    @Suppress("MemberVisibilityCanBePrivate")
    protected lateinit var renderState: STATE

    override fun onViewCreated(view: android.view.View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter?.bind()
    }

    override fun onResume() {
        super.onResume()

        presenter?.bind()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        presenter?.unbind()

        super.onSaveInstanceState(outState)
    }

    override fun onPause() {
        presenter?.unbind()

        super.onPause()
    }

    override fun onDestroyView() {
        presenter?.unbind()

        super.onDestroyView()
    }

    override fun render(state: STATE) {
        renderState = state
    }

    override fun goBack() {
        (activity as? BasePresentationActivity<*>)?.goBack()
    }

    open fun onRefresh() {}

    protected fun goToFragment(fragment: BasePresentationFragment<*, *, *, *>, fragmentContainerId: Int) {
        (activity as? BasePresentationActivity<*>)?.goToFragment(
            fragment = fragment,
            fragmentContainerId = fragmentContainerId
        )
    }

    @Suppress("MemberVisibilityCanBePrivate")
    protected fun startActivitySafely(f: (Context) -> android.content.Intent) {
        startActivity(f(requireContext()))
    }

    protected fun startActivitySafelyAndFinish(f: (Context) -> android.content.Intent) {
        startActivitySafely(f).also {
            activity?.finish()
        }
    }
}
