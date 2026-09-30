package io.github.abhidroid87.flow.discord

import android.content.Context
import io.github.abhidroid87.flow.BuildConfig
import okhttp3.OkHttpClient

class DiscordPlatformTransportFactory : DiscordPresenceTransportFactory {
    override fun create(
        context: Context,
        okHttpClient: OkHttpClient,
        tokenStore: DiscordTokenStore,
    ): DiscordPresenceTransport =
        KizzyDiscordPresenceTransport(
            context = context.applicationContext,
            client = okHttpClient,
            tokenStore = tokenStore,
            applicationId = BuildConfig.DISCORD_APPLICATION_ID,
        )
}
