@file:Suppress("unused")

package com.chrynan.presentation.components.android.transition

import android.transition.Transition

interface NoOpTransitionListener : Transition.TransitionListener {

    override fun onTransitionEnd(transition: Transition) {
    }

    override fun onTransitionResume(transition: Transition) {
    }

    override fun onTransitionPause(transition: Transition) {
    }

    override fun onTransitionCancel(transition: Transition) {
    }

    override fun onTransitionStart(transition: Transition) {
    }
}
