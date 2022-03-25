@file:Suppress("unused")

package com.chrynan.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.*
import kotlin.coroutines.CoroutineContext

/**
 * An Android [Fragment] base implementation of a [View] for use with this library's MVI design pattern.
 *
 * Example usage:
 *
 * ```kotlin
 * class HomeFragment : BasePresentationFragment<HomeIntent, HomeState, HomeChange>() {
 *
 *     override fun onCreateView(
 *         inflater: LayoutInflater,
 *         container: ViewGroup?,
 *         savedInstanceState: Bundle?) = ...
 *
 *     override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
 *         super.onViewCreated(view, savedInstanceState)
 *
 *         intent(to HomeIntent.Load)
 *     }
 *
 *     override fun render(state: HomeState) {
 *         when (state) { ... }
 *     }
 * }
 * ```
 */
abstract class BasePresentationFragment<INTENT : Intent, STATE : State, CHANGE : Change> :
    Fragment(),
    View<INTENT, STATE> {

    override var renderState: STATE? = null
        protected set

    protected val currentState: STATE?
        get() = presenter?.currentState ?: renderState

    protected open val coroutineScope: CoroutineScope = object : CoroutineScope {

        override val coroutineContext: CoroutineContext
            get() = lifecycleScope.coroutineContext
    }

    protected open val presenter: BasePresenter<INTENT, STATE, CHANGE>? = null

    @Suppress("MemberVisibilityCanBePrivate")
    protected open val key: Any? = this::class.qualifiedName

    private val intentEvents = MutableStateFlow<IntentEvent<INTENT>?>(null)

    protected abstract fun render(state: STATE)

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

    override fun intentEvents(): Flow<IntentEvent<INTENT>> = intentEvents.asStateFlow().filterNotNull()

    protected fun intent(to: INTENT) {
        intentEvents.value = IntentEvent(intent = to)
    }

    private fun bindPresenter() {
        presenter?.let {
            if (!it.isBound) {
                it.bind()

                it.renderStates
                    .onEach { state ->
                        render(state = state)
                        renderState = state
                    }
                    .launchIn(it.coroutineScope)
            }
        }
    }
}
