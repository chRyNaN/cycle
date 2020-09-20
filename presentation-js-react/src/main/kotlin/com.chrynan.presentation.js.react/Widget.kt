@file:Suppress("unused")

package com.chrynan.presentation.js.react

import react.*

external interface WidgetProps<VM> : RProps {

    var model: VM
}

abstract class Widget<P : WidgetProps<VM>, VM> : RComponent<P, RState>() {

    abstract fun RBuilder.render(properties: P)

    override fun RBuilder.render() = render(props)
}

inline fun <P : WidgetProps<*>, reified W : Widget<P, *>> RBuilder.widget(noinline handler: P.() -> Unit): ReactElement =
    child(W::class) {
        this.attrs(handler)
    }
