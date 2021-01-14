package com.chrynan.presentation.components.viewmodel

import com.chrynan.aaaah.AdapterId
import com.chrynan.aaaah.UniqueAdapterItem
import com.chrynan.presentation.ViewModel

actual interface ListItemViewModel : ViewModel,
    UniqueAdapterItem {

    override val uniqueAdapterId: AdapterId
        get() = uniqueId
}
