@file:Suppress("unused")

package com.chrynan.presentation.components.viewmodel

interface SortableListItemViewModel : ListItemViewModel,
    GridItemViewModel,
    Comparable<SortableListItemViewModel> {

    override fun compareTo(other: SortableListItemViewModel): Int
}
