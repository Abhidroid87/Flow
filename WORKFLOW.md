# Build and Maintenance Workflow

This repository is the independently maintained Flow fork at `Abhidroid87/Flow`. It keeps the upstream GPL-3.0 license and original source attribution. The fork application ID is `io.github.abhidroid87.flow`, so builds install alongside the original app and are signed independently.

## Local Setup

1. Install Android Studio or the Android SDK command-line tools, Android platform 37, build tools 37, and a full JDK 21 installation that includes `jlink`.
2. Set `JAVA_HOME` to that JDK and ensure `$JAVA_HOME/bin` is on `PATH`.
3. Set `sdk.dir` in the untracked `local.properties` file to the Android SDK path.
4. Accept the Android SDK licenses and start an Android 8.0+ emulator or connect a device.

The repository requires a full JDK. A runtime-only Java install may fail Android's JDK image transform because it does not include `jlink`.

## Build and Run

```bash
./gradlew ktlintCheck
./gradlew :app:testGithubDebugUnitTest :app:testFossDebugUnitTest
./gradlew :app:compileGithubDebugKotlin :app:compileFossDebugKotlin
./gradlew :app:assembleGithubDebug
adb install -r app/build/outputs/apk/github/debug/app-github-x86_64-debug.apk
adb shell monkey -p io.github.abhidroid87.flow.debug -c android.intent.category.LAUNCHER 1
```

Choose the APK matching the emulator/device ABI. `github` includes the release updater and Discord integration; `foss` does not. Always use flavor-prefixed Gradle tasks.

## Continuous Integration and Releases

`.github/workflows/build.yml` runs on pushes and pull requests targeting `main`, version tags (`v*`), and manual dispatch. Pushes to `main` build GitHub release, nightly, and FOSS APKs and upload standalone workflow artifacts. A `v*` tag builds and publishes release APKs with checksums to this repository's GitHub Releases. Main-branch builds also update the rolling `nightly` prerelease.

The workflow uses the current GitHub repository context for release operations; it does not need an upstream remote or a hardcoded repository endpoint.

For signed releases, configure repository secrets:

- `RELEASE_KEYSTORE_BASE64`
- `STORE_PASSWORD`
- `KEY_ALIAS`
- `KEY_PASSWORD`

Set `RELEASE_SIGNER_SHA256` as a repository variable to the SHA-256 digest. The workflow also accepts the existing `RELEASE_CERT_SHA256` Actions secret. Colons and uppercase hex are normalized. A tag release fails rather than publishing an unsigned APK when the release keystore is absent.

Nightly signing is optional. To make rolling nightly APKs update-installable across workflow runs, configure a stable nightly keystore with `NIGHTLY_KEYSTORE_BASE64`, `NIGHTLY_STORE_PASSWORD`, `NIGHTLY_KEY_ALIAS`, and `NIGHTLY_KEY_PASSWORD`, and set `NIGHTLY_SIGNER_SHA256`. Never use the original project's signing key. Without a stable nightly key, CI still publishes the debug-signed APK, but treat each as a fresh install and use the posted checksum.

The updater queries `Abhidroid87/Flow` stable releases or the `nightly` release tag. Keep the release asset names in the workflow aligned with ABI selection in `app/src/main/java/io/github/abhidroid87/flow/data/update/`.

## Maintenance

- Keep `namespace`, application ID, manifests, tests, benchmark sources, ProGuard rules, and Kotlin package declarations on `io.github.abhidroid87.flow`.
- Preserve original copyright and third-party license notices. See `License` before redistributing modified builds.
- Keep secrets out of `local.properties`, source files, and workflow logs. Use GitHub Actions secrets for credentials and repository variables for public certificate digests.
- Validate source and test changes with the narrowest relevant test first, then run the flavor compile/build. For Compose changes, exercise the corresponding flow in an emulator or device.
- Room schema changes require an explicit version bump and migration. Do not regenerate the baseline profile for routine feature changes.
- Keep the fork's initial root commit isolated; do not add the original repository as a remote or merge its branches.
