package io.github.abhidroid87.flow.discord

import android.content.Context
import okhttp3.OkHttpClient

interface DiscordPresenceTransportFactory {
    fun create(
        context: Context,
        okHttpClient: OkHttpClient,
        tokenStore: DiscordTokenStore,
    ): DiscordPresenceTransport
}
