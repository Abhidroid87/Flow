package io.github.abhidroid87.flow.innertube.pages

import io.github.abhidroid87.flow.innertube.models.AlbumItem

data class ExplorePage(
    val newReleaseAlbums: List<AlbumItem>,
    val moodAndGenres: List<MoodAndGenres.Item>,
)
