@file:Suppress("unused")

package com.chrynan.presentation

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.*
import java.lang.ref.WeakReference
import kotlin.coroutines.CoroutineContext

/**
 * An Android [Fragment] base implementation of a [View] for use with this library's MVI design pattern.
 */
abstract class BasePresentationFragment<INTENT : Intent, STATE : State, CHANGE : Change> :
    Fragment(),
    View<INTENT, STATE> {

    override val states: Flow<STATE>
        get() = statesStateFlow.asStateFlow().filterNotNull()

    override val renderState: STATE?
        get() = statesStateFlow.value

    protected open val coroutineScope: CoroutineScope = object : CoroutineScope {

        override val coroutineContext: CoroutineContext
            get() = lifecycleScope.coroutineContext
    }

    protected open val presenter: BasePresenter<INTENT, STATE, CHANGE>? = null

    protected val currentState: STATE?
        get() = presenter?.currentState ?: renderState

    private val intentsStateFlow = MutableStateFlow<INTENT?>(null)
    private var statesStateFlow = MutableStateFlow<STATE?>(null)

    private var weakReferenceActivity: WeakReference<Activity>? = null

    override fun onViewCreated(view: android.view.View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindPresenter()
    }

    override fun onResume() {
        super.onResume()

        bindPresenter()
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

    override fun intents(): Flow<INTENT> = intentsStateFlow.asStateFlow().filterNotNull()

    protected open fun onRefresh() {}

    protected open fun goToFragment(
        fragment: BasePresentationFragment<*, *, *>,
        fragmentContainerId: Int
    ) {
        (activity as? BasePresentationActivity)?.goToFragment(
            fragment = fragment,
            fragmentContainerId = fragmentContainerId
        )
    }

    @Suppress("MemberVisibilityCanBePrivate")
    protected open fun startActivitySafely(f: (Context) -> android.content.Intent) =
        startActivity(f(requireContext()))

    protected open fun startActivitySafelyAndFinish(f: (Context) -> android.content.Intent) =
        startActivitySafely(f).also {
            activity?.finish()
        }

    protected fun emit(intent: INTENT) {
        intentsStateFlow.value = intent
    }

    private fun bindPresenter() {
        presenter?.let {
            if (!it.isBound) {
                it.bind()

                it.renderStates
                    .onEach { state -> statesStateFlow.value = state }
                    .launchIn(it.coroutineScope)
            }
        }
    }
}
