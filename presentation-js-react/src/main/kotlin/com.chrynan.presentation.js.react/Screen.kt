@file:Suppress("unused")

package com.chrynan.presentation.js.react

import com.chrynan.dispatchers.dispatchers
import com.chrynan.presentation.*
import kotlinx.coroutines.SupervisorJob
import org.w3c.dom.Element
import react.RBuilder
import kotlin.coroutines.CoroutineContext

abstract class Screen<I : Intent, S : State, C : Change> : View<I, S>,
    ScreenCoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = SupervisorJob() + dispatchers.main

    abstract val presenter: Presenter<I, S, C>

    abstract fun RBuilder.render(state: S)

    private var root: Element? = null

    open fun onStart(root: Element?) {
        this.root = root
        presenter.bind()
    }

    open fun onStop() {
        presenter.unbind()
    }

    override fun render(state: S) {
        react.dom.render(root) {
            this.render(state)
        }
    }
}
