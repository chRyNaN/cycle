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
import com.chrynan.presentation.Change
import com.chrynan.presentation.Intent
import com.chrynan.presentation.State

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
abstract class ComposeFragment<I : Intent, S : State, C : Change> :
    PresentationFragment<I, S, C>(),
    com.chrynan.presentation.View<I, S, C> {

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
