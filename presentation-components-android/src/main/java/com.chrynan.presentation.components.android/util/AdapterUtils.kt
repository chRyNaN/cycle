@file:Suppress("unused")

package com.chrynan.presentation.components.android.util

import android.content.Context
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.chrynan.aaaah.GridLayoutPositionManager
import com.chrynan.aaaah.LinearLayoutPositionManager

// TODO these should be brought into the Adapter library

@Suppress("FunctionName")
fun VerticalPositionManager(context: Context): LinearLayoutPositionManager = LinearLayoutPositionManager(
    LinearLayoutManager(context)
)

@Suppress("FunctionName")
fun HorizontalPositionManager(context: Context): LinearLayoutPositionManager = LinearLayoutPositionManager(
    LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
)

@Suppress("FunctionName")
fun GridPositionManager(context: Context, spanCount: Int): GridLayoutPositionManager = GridLayoutPositionManager(
    GridLayoutManager(context, spanCount)
)
