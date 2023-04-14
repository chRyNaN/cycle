@file:Suppress("unused")

package com.chrynan.presentation.compose

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import com.chrynan.presentation.PresentationFragment
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

/**
 * An implementation of a [PresentationFragment] that supports Jetpack Compose.
 *
 * Example Usage:
 *
 * ```kotlin
 * class HomeFragment : ComposeFragment<HomeState, HomeChange>() {
 *
 *     override val viewModel = ...
 *
 *     @Composable
 *     override fun Content() {
 *         val state by stateChanges()
 *
 *         when (state) { ... }
 *     }
 * }
 * ```
 */
@ExperimentalCoroutinesApi
@FlowPreview
abstract class ComposeFragment<State, Change> :
    PresentationFragment<State, Change>(),
    com.chrynan.presentation.View<State, Change> {

    /**
     * Display the UI content. Remember to subscribe to the state changes using the [stateChanges] function within this
     * function. Using the [renderState] property won't work because it won't trigger a recomposition of the composable
     * function when the state changes.
     */
    @Suppress("FunctionName")
    @Composable
    abstract fun Content()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        ComposeView(requireContext()).apply {
            layoutParams =
                ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)

            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)

            composeViewInitializer()

            setContent {
                this@ComposeFragment.Content()
            }
        }

    override fun render(state: State?) {
        // No-op - handled by the Content function
    }

    open fun ComposeView.composeViewInitializer() {}
}
