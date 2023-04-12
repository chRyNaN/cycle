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

/**
 * An implementation of a [PresentationFragment] that supports Jetpack Compose.
 *
 * Example Usage:
 *
 * ```kotlin
 * class HomeFragment : ComposeFragment<HomeIntent, HomeState, HomeChange>() {
 *
 *     override val viewModel = ...
 *
 *     override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
 *         super.onViewCreated(view, savedInstanceState)
 *
 *         intent(to HomeIntent.Load)
 *     }
 *
 *     @Composable
 *     override fun Content(state: HomeState) {
 *         when (state) { ... }
 *     }
 * }
 * ```
 */
abstract class ComposeFragment<State, Change> :
    PresentationFragment<State, Change>(),
    com.chrynan.presentation.View<State, Change> {

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

    override fun render() {
        // No-op - handled by the Content function
    }

    open fun ComposeView.composeViewInitializer() {}
}
