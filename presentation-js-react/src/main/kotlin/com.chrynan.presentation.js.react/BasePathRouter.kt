package com.chrynan.presentation.js.react

import com.chrynan.pathmatch.core.PathMatcher

abstract class BasePathRouter : PathRouter {

    fun route(path: String) =
        PathMatcher(path).apply {
            route()
        }
}
