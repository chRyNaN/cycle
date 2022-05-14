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
abstract class PresentationFragment<I : Intent, S : State, C : Change> :
    Fragment(),
    View<I, S, C> {

    override val renderState: S?
        get() = presenter.currentState

    protected open val coroutineScope: CoroutineScope = object : CoroutineScope {

        override val coroutineContext: CoroutineContext
            get() = lifecycleScope.coroutineContext
    }

    abstract override val presenter: BasePresenter<I, S, C>

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
        presenter.unbind()

        super.onSaveInstanceState(outState)
    }

    override fun onPause() {
        presenter.unbind()

        super.onPause()
    }

    override fun onDestroyView() {
        presenter.unbind()

        super.onDestroyView()
    }

    protected fun stateChanges(): Flow<S?> = presenter.renderStates

    private fun bindPresenter() {
        presenter.let {
            if (!it.isBound) {
                it.bind()

                render()
            }
        }
    }
}
