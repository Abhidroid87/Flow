// ==================================================================================================
// This implementation was based on metrolist's (https://github.com/MetrolistGroup/Metrolist)
// ==================================================================================================

package io.github.abhidroid87.flow.data.lyrics.kugou.models

data class Keyword(
    val title: String,
    val artist: String,
    val album: String? = null,
)
