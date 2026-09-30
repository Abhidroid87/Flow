package io.github.abhidroid87.flow.innertube.models.response

import io.github.abhidroid87.flow.innertube.models.NavigationEndpoint
import kotlinx.serialization.Serializable

@Serializable
data class ResolveUrlResponse(
    val endpoint: NavigationEndpoint? = null,
)
