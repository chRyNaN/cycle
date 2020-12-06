@file:Suppress("unused")

package com.chrynan.presentation.android

import kotlinx.coroutines.CoroutineScope

interface DialogFragmentCoroutineScope : CoroutineScope,
    FragmentCoroutineScope
