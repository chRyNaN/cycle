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
 * class HomeFragment : PresentationFragment<HomeIntent, HomeState, HomeChange>() {
 *
 *     override val viewModel = ...
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
abstract class PresentationFragment<State, Change> :
    Fragment(),
    View<State, Change> {

    override val renderState: State?
        get() = viewModel.currentState

    protected open val coroutineScope: CoroutineScope = object : CoroutineScope {

        override val coroutineContext: CoroutineContext
            get() = lifecycleScope.coroutineContext
    }

    abstract override val viewModel: ViewModel<State, Change>

    @Suppress("MemberVisibilityCanBePrivate")
    protected open val key: Any? = this::class.qualifiedName

    protected abstract fun render()

    override fun onViewCreated(view: android.view.View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindPresenter()
    }

    override fun onResume() {
        super.onResume()

        bindPresenter()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        viewModel.unbind()

        super.onSaveInstanceState(outState)
    }

    override fun onPause() {
        viewModel.unbind()

        super.onPause()
    }

    override fun onDestroyView() {
        viewModel.unbind()

        super.onDestroyView()
    }

    protected fun stateChanges(): Flow<State?> = viewModel.states

    private fun bindPresenter() {
        viewModel.let {
            if (!it.isBound) {
                it.bind()

                render()
            }
        }
    }
}
