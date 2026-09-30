# Repository Skills Map

## Identity

- Maintained repository: `https://github.com/Abhidroid87/Flow`
- Android namespace and application ID: `io.github.abhidroid87.flow`
- Main Android sources: `app/src/main/java/io/github/abhidroid87/flow/`
- GitHub flavor sources: `app/src/github/java/io/github/abhidroid87/flow/`
- FOSS flavor sources: `app/src/foss/java/io/github/abhidroid87/flow/`
- Unit tests: `app/src/test/java/io/github/abhidroid87/flow/`, with flavor-specific tests under `testGithub/` and `testFoss/`
- Instrumented tests: `app/src/androidTest/` and `app/src/androidTestGithub/`
- Baseline profile generator: `benchmark/src/main/java/io/github/abhidroid87/flow/benchmark/`

## Architecture

- UI uses Kotlin, Jetpack Compose, and Material 3. Navigation and app composition are rooted in `ui/FlowApp.kt` and `ui/FlowNavigation.kt`.
- Feature routes and their ViewModels live under `ui/screens/<feature>/`. Reusable feature components live under `ui/components/<feature>/`; cross-feature components live under `ui/components/shared/`.
- Theme tokens live in `ui/theme/`. User-facing English strings live in `app/src/main/res/values/strings.xml`; locale translations are maintained separately.
- Dependency injection uses Hilt. Prefer constructor injection and preserve the existing scopes and lifecycle boundaries.
- Playback is owned by the Media3/ExoPlayer services and managers under `service/` and `player/`. Do not create duplicate players or move player setup onto the startup path.
- YouTube data uses the native InnerTube client with NewPipe Extractor fallback. Network clients and proxy behavior live under `network/` and `data/repository/`.
- Local persistence uses Room and DataStore under `data/local/`. Do not change Room schemas without an explicit migration plan.
- Offline work and scheduled checks use WorkManager. Release discovery and installation live in `data/update/`, `notification/`, and the GitHub-only `updater/` source set.
- The app includes local music/video, downloads, casting, lyrics, device sync, recommendations, widgets, and optional GitHub-flavor Discord presence.

## Safe Change Boundaries

- Keep existing source copyright, license, and third-party attribution notices.
- Keep the fork namespace and release URLs aligned with `app/build.gradle.kts`, `UpdateRepository`, release-note parsing, About links, and `.github/workflows/build.yml`.
- Build with flavor-prefixed Gradle tasks. Do not use bare `assembleDebug` or `compileDebugKotlin`.
- Keep continuous work visibility-gated, network work deduplicated, and player updates on their existing cadence.
- Use existing libraries and shared components rather than reimplementing platform behavior.
- Do not commit, push, rewrite Git history, or add an upstream remote as part of local development.
