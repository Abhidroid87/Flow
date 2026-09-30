package io.github.abhidroid87.flow.discord

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class DiscordFossIsolationTest {
    @Test
    fun `foss classpath excludes functional Discord implementation`() {
        val forbiddenClasses =
            listOf(
                "io.github.abhidroid87.flow.discord.DiscordTokenStore",
                "io.github.abhidroid87.flow.discord.DiscordAuthTokens",
                "io.github.abhidroid87.flow.discord.DiscordPlaybackSource",
                "io.github.abhidroid87.flow.discord.DiscordPresenceCoordinator",
                "io.github.abhidroid87.flow.discord.KizzyDiscordPresenceTransport",
                "io.github.abhidroid87.flow.discord.KizzyGatewayProtocol",
            )

        forbiddenClasses.forEach { className ->
            assertThat(runCatching { Class.forName(className) }.isFailure).isTrue()
        }
    }

    @Test
    fun `foss runtime reports Discord unavailable`() {
        assertThat(DiscordPresenceRuntime.settingsState.value.isAvailable).isFalse()
        assertThat(DiscordPresenceRuntime.settingsState.value.isEnabled).isFalse()
        assertThat(DiscordPresenceRuntime.settingsState.value.summary)
            .isEqualTo(DiscordSettingsSummary.UNAVAILABLE)
    }
}
