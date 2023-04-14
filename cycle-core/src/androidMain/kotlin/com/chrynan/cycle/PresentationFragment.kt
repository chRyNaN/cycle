@file:Suppress("unused")

package com.chrynan.cycle

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlin.coroutines.CoroutineContext

/**
 * An Android [Fragment] base implementation of a [View] for use with this library's design pattern.
 *
 * ### Example usage:
 *
 * ```kotlin
 * class HomeFragment : PresentationFragment<HomeState, HomeChange>() {
 *
 *     override val viewModel = ...
 *
 *     override fun onCreateView(
 *         inflater: LayoutInflater,
 *         container: ViewGroup?,
 *         savedInstanceState: Bundle?) = ...
 *
 *     override fun render(state: HomeState?) {
 *         when (state) { ... }
 *     }
 * }
 * ```
 */
@FlowPreview
@ExperimentalCoroutinesApi
abstract class PresentationFragment<State, Change> :
    Fragment(),
    View<State, Change> {

    final override var renderState: State? = null
        private set

    protected open val coroutineScope: CoroutineScope = object : CoroutineScope {

        override val coroutineContext: CoroutineContext
            get() = lifecycleScope.coroutineContext
    }

    abstract override val viewModel: ViewModel<State, Change>

    @Suppress("MemberVisibilityCanBePrivate")
    protected open val key: Any? = this::class.qualifiedName

    protected abstract fun render(state: State?)

    override fun onViewCreated(view: android.view.View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindViewModel()
    }

    override fun onResume() {
        super.onResume()

        bindViewModel()
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

    private fun bindViewModel() {
        viewModel.bind()

        viewModel.let {
            if (!viewModel.isBound) {
                viewModel.bind()

                viewModel.subscribe {
                    renderState = it

                    render(it)
                }
            }
        }
    }
}
