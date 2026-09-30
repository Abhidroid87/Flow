package io.github.abhidroid87.flow.innertube.models.body

import io.github.abhidroid87.flow.innertube.models.Context
import kotlinx.serialization.Serializable

@Serializable
data class ResolveUrlBody(
    val context: Context,
    val url: String,
)
