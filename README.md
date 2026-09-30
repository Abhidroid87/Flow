<div align="center">
  <img src="Assets/logo.png" alt="Flow Logo" width="140" height="140">
  <br><br>
  
  <div align="center">
  
<br>
<img src="https://img.shields.io/badge/Status-Active_Development-success?style=for-the-badge&logo=github-actions">
<br>
<!-- Downloads & Version -->
<a href="https://github.com/Abhidroid87/Flow/releases">
  <img src="https://img.shields.io/github/downloads/Abhidroid87/Flow/total?style=for-the-badge&color=orange&logo=github&label=Downloads">
</a>
<a href="https://github.com/Abhidroid87/Flow/releases">
  <img src="https://img.shields.io/github/v/release/Abhidroid87/Flow?style=for-the-badge&color=crimson&label=Latest%20Version">
</a>

<br>

<!-- Tech Stack -->
<img src="https://img.shields.io/badge/Platform-Android_8.0+-3DDC84?style=for-the-badge&logo=android&logoColor=white">
<img src="https://img.shields.io/badge/Kotlin-100%25-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white">
<img src="https://img.shields.io/badge/Compose-Material_3-4285F4?style=for-the-badge&logo=jetpackcompose&logoColor=white">

<br>

<!-- Repository & License -->
<img src="https://img.shields.io/github/stars/Abhidroid87/Flow?style=for-the-badge&logo=star&color=gold">
<a href="LICENSE">
  <img src="https://img.shields.io/badge/License-GPL_v3.0-blue?style=for-the-badge&logo=gnu-bash&logoColor=white">
</a>
<img src="https://img.shields.io/github/last-commit/Abhidroid87/Flow?style=for-the-badge&color=red">

</div>

  <br><br>
  
  <h3>A community-maintained fork of Flow for Android.</h3>
  <p>
    Flow is a YouTube and YouTube Music client built with Jetpack Compose and Material 3.<br>
    It includes FlowNeuro, a recommendation engine that runs entirely on your device — no accounts, no tracking, no data leaves your phone.
  </p>
  <p>This fork changes the Android application ID to <code>io.github.abhidroid87.flow</code> and publishes independently.</p>
  
  <p>
    <a href="https://github.com/Abhidroid87/Flow/releases"><b>Download APK</b></a> ·
    <a href="https://github.com/Abhidroid87/Flow/issues"><b>Issues</b></a> ·
    <a href="WORKFLOW.md"><b>Build and maintenance</b></a>
  </p>
</div>

---

## Why Flow?

Most open-source YouTube clients give you playback but no way to discover new content. You either use the official app and get tracked, or you use an alternative and lose recommendations entirely.

Flow gives you both. The recommendation engine learns what you like by analyzing your watch behavior locally. It never leaves your devices. You can inspect everything it knows about you, adjust it, or wipe it at any time.

---

## Features

### Video
- High-quality playback via ExoPlayer (Media3) with resolution switching (1080p, 720p, 480p, 360p)
- SponsorBlock — automatically skips sponsors, intros, outros, and filler
- DeArrow — replaces clickbait thumbnails and titles with community-sourced alternatives
- Return Youtube Dislike (RYD)
- Background playback — listen to audio with the screen off
- Picture-in-Picture — keep watching while using other apps
- Casting to smart TVs and streaming devices
- Playback speed control (0.25x to 2x)
- Video chapters with seek jumping
- Gesture controls for brightness, volume, and seeking
- Subtitles with customizable font size, color, and background
- Downloads with VP9, AV1, and standard format support
- Resume playback from where you left off

### Music
- Dedicated music player with album art and audio visualizations
- Queue management with add, remove, and reorder
- Shuffle and repeat (single/all)
- Persistent mini player across the app
- Synchronized lyrics display
- Fetches tracks from YouTube Music
- Playback speed control for music playback

### Recommendations (FlowNeuro Engine)
- Runs 100% on-device — no server, no telemetry, no account needed
- Learns from what you watch, skip, like, dislike, search for, and how long you watch
- Distinguishes weekday and weekend patterns, morning and night preferences
- Detects when you're getting bored of a topic and mixes in new content
- Prevents your feed from collapsing into the same 2-3 topics
- Surfaces related videos from your recent watches to create natural topic transitions
- Uses engagement signals (like-to-view ratios) to filter out low-quality content
- Full transparency dashboard — see what the algorithm knows and why it recommended something
- Export/import your entire recommendation profile as a file

### Library
- Local watch history
- Favorites and custom playlists
- Shorts feed with bookmarking
- Continue watching shelf
- Subscription management with cached feeds

### Privacy
- No Google account required
- No ads, analytics, or tracking
- All data stored locally on your device
- Import subscriptions and history from NewPipe
- Export or delete everything at any time

### Appearance
- 11 themes: Light, Dark, OLED Black, Ocean Blue, Forest Green, Sunset Orange, Purple Nebula, Midnight Black, Rose Gold, Arctic Ice, Crimson Red
- Built entirely with Jetpack Compose and Material 3

---
## Downloads

Release APKs are published at [GitHub Releases](https://github.com/Abhidroid87/Flow/releases). Pushes to `main` build GitHub and FOSS APK artifacts; version tags publish a stable release. Nightly APKs are separate from stable installs.

The fork uses application ID `io.github.abhidroid87.flow`. Its APKs do not update installations of the original Flow package. Verify release checksums from each release before installing.

Minimum Android version: 8.0 (API 26).

---

## 🙏 Acknowledgments

Flow stands on the shoulders of giants. Special thanks to:

*   **[NewPipeExtractor](https://github.com/TeamNewPipe/NewPipeExtractor):** The backbone of our data extraction.
*   **[NewPipe](https://github.com/TeamNewPipe/NewPipe):** For inspiration from their solid foundation for YouTube data handling.
*   **[PipePipe](https://codeberg.org/NullPointerException/PipePipe):** For their SABR and InnerTube playback implementation, which guided Flow's YouTube streaming pipeline.
*   **[PipePipe Developer Docs](https://priveetee.github.io/Docs-PipePipe/):** For their reference documentation on SABR, BotGuard/PoToken attestation, and InnerTube extraction internals.
*   **[MetroList](https://github.com/MetrolistGroup/Metrolist):** Inspiration for the Hybrid Music fetching approach, Lyrics handling and some icons design references.
*   **[LibreTube](https://github.com/LibreTube/LibreTube):** Inspiration for SponsorBlock and DeArrow handling and some icons design references.
*   **[ExoPlayer](https://github.com/google/ExoPlayer):** The gold standard for Android media playback.
*   **[Jetpack Compose](https://developer.android.com/jetpack/compose):** For enabling the beautiful, modern UI.
*   **[Material Design 3](https://m3.material.io/):** For the design system and guidelines.


---

<div align="center">
  <sub>Community-maintained fork. Original project attribution is retained in source and license notices.</sub>
</div>
