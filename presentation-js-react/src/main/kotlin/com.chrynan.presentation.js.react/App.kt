@file:Suppress("unused")

package com.chrynan.presentation.js.react

import kotlinx.browser.document
import org.w3c.dom.Element

class App(private val rootId: String) {

    private val root: Element?
        get() = document.getElementById(rootId)

    private var currentScreen: Screen<*, *, *>? = null

    fun start(screen: Screen<*, *, *>) {
        currentScreen?.onStop()
        currentScreen = screen
        screen.onStart(root)
    }

    fun stop() {
        currentScreen?.onStop()
        currentScreen = null
    }
}
