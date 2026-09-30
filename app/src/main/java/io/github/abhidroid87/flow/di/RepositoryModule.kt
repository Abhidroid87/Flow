package io.github.abhidroid87.flow.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.github.abhidroid87.flow.data.local.PlayerPreferences
import io.github.abhidroid87.flow.data.repository.YouTubeRepository
import io.github.abhidroid87.flow.data.shorts.ChannelReelIndex
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideYouTubeRepository(
        playerPreferences: PlayerPreferences,
        channelReelIndex: ChannelReelIndex,
    ): YouTubeRepository = YouTubeRepository.getInstance(playerPreferences, channelReelIndex)

    @Provides
    @Singleton
    fun provideSubscriptionRepository(
        @ApplicationContext context: Context,
    ): io.github.abhidroid87.flow.data.local.SubscriptionRepository =
        io.github.abhidroid87.flow.data.local.SubscriptionRepository
            .getInstance(context)

    @Provides
    @Singleton
    fun provideLikedVideosRepository(
        @ApplicationContext context: Context,
    ): io.github.abhidroid87.flow.data.local.LikedVideosRepository =
        io.github.abhidroid87.flow.data.local.LikedVideosRepository
            .getInstance(context)

    @Provides
    @Singleton
    fun provideViewHistory(
        @ApplicationContext context: Context,
    ): io.github.abhidroid87.flow.data.local.ViewHistory =
        io.github.abhidroid87.flow.data.local.ViewHistory
            .getInstance(context)

    @Provides
    @Singleton
    fun provideHomeFeedCacheRepository(
        @ApplicationContext context: Context,
    ): io.github.abhidroid87.flow.data.local.HomeFeedCacheRepository =
        io.github.abhidroid87.flow.data.local
            .HomeFeedCacheRepository(context)

    @Provides
    @Singleton
    fun provideMusicPlaylistRepository(
        @ApplicationContext context: Context,
    ): io.github.abhidroid87.flow.data.music.PlaylistRepository =
        io.github.abhidroid87.flow.data.music
            .PlaylistRepository(context)

    // VideoDownloadManager is now @Singleton @Inject — Hilt provides it automatically
    @Provides
    @Singleton
    fun providePlayerPreferences(
        @ApplicationContext context: Context,
    ): io.github.abhidroid87.flow.data.local.PlayerPreferences =
        io.github.abhidroid87.flow.data.local
            .PlayerPreferences(context)

    /**
     * Transitional: [io.github.abhidroid87.flow.data.local.BackupRepository] still builds its own
     * collaborators, so it is provided here rather than injected through its constructor. One
     * instance serves the whole app.
     */
    @Provides
    @Singleton
    fun provideBackupRepository(
        @ApplicationContext context: Context,
    ): io.github.abhidroid87.flow.data.local.BackupRepository =
        io.github.abhidroid87.flow.data.local
            .BackupRepository(context)
}
