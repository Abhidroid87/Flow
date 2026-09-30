package io.github.abhidroid87.flow.innertube.models

import kotlinx.serialization.Serializable

@Serializable
data class MusicPlaylistShelfRenderer(
    val playlistId: String?,
    val contents: List<MusicShelfRenderer.Content>?,
    val collapsedItemCount: Int,
)
