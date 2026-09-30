package io.github.abhidroid87.flow.innertube.models.body

import io.github.abhidroid87.flow.innertube.models.Context
import kotlinx.serialization.Serializable

@Serializable
data class SearchBody(
    val context: Context,
    val query: String?,
    val params: String?,
    val continuation: String? = null,
)
