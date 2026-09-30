package io.github.abhidroid87.flow.innertube.pages

import io.github.abhidroid87.flow.innertube.models.SongItem

data class PlaylistContinuationPage(
    val songs: List<SongItem>,
    val continuation: String?,
)
