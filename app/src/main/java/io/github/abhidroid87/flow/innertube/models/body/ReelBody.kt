package io.github.abhidroid87.flow.innertube.models.body

import io.github.abhidroid87.flow.innertube.models.Context
import kotlinx.serialization.Serializable

@Serializable
data class ReelBody(
    val context: Context,
    val sequenceParams: String,
)
