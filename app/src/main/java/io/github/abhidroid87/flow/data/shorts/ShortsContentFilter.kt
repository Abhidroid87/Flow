package io.github.abhidroid87.flow.data.shorts

import io.github.abhidroid87.flow.data.local.PlayerPreferences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.first
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ShortsContentFilter(
    val enabled: Flow<Boolean>,
) {
    @Inject
    constructor(preferences: PlayerPreferences) : this(preferences.shortsContentEnabled.distinctUntilChanged())

    suspend fun isEnabled(): Boolean = enabled.first()
}
