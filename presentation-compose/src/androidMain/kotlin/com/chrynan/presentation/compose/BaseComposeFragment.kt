@file:Suppress("unused")

package com.chrynan.presentation.compose

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import com.chrynan.presentation.BasePresentationFragment
import com.chrynan.presentation.Change
import com.chrynan.presentation.Intent
import com.chrynan.presentation.State
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.filterNotNull

/**
 * An implementation of a [BasePresentationFragment] that supports Jetpack Compose.
 *
 * Example Usage:
 *
 * ```kotlin
 * class HomeFragment : BaseComposeFragment<HomeIntent, HomeState, HomeChange>() {
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
abstract class BaseComposeFragment<INTENT : Intent, STATE : State, CHANGE : Change> :
    BasePresentationFragment<INTENT, STATE, CHANGE>() {

    @Suppress("MemberVisibilityCanBePrivate")
    protected val states: Flow<STATE>
        get() = renderStates.asStateFlow().filterNotNull()

    private val renderStates = MutableStateFlow<STATE?>(null)

    @Composable
    abstract fun Content(state: STATE)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        ComposeView(requireContext()).apply {
            layoutParams =
                ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)

            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)

            composeViewInitializer()

            setContent {
                val state by states.collectAsState(initial = null)

                ContentWrapper(state = state)
            }
        }

    override fun render(state: STATE) {
        renderStates.value = state
    }

    open fun ComposeView.composeViewInitializer() {}

    @Composable
    open fun ContentWrapper(state: STATE?) {
        AnimatedVisibility(
            visible = state != null,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            state?.let {
                Content(it)
            }
        }
    }
}
