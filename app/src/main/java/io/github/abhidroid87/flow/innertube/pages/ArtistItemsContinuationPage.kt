package io.github.abhidroid87.flow.innertube.pages

import io.github.abhidroid87.flow.innertube.models.YTItem

data class ArtistItemsContinuationPage(
    val items: List<YTItem>,
    val continuation: String?,
)
