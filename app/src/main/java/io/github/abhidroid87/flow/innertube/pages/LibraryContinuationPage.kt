package io.github.abhidroid87.flow.innertube.pages

import io.github.abhidroid87.flow.innertube.models.YTItem

data class LibraryContinuationPage(
    val items: List<YTItem>,
    val continuation: String?,
)
