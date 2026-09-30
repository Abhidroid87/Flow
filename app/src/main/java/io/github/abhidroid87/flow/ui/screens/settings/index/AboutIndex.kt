package io.github.abhidroid87.flow.ui.screens.settings.index

import io.github.abhidroid87.flow.R
import io.github.abhidroid87.flow.ui.components.settings.SettingEntry
import io.github.abhidroid87.flow.ui.components.settings.SettingsDestination

internal object AboutIndex {
    private val page = SettingsDestination.ABOUT

    private fun entry(
        key: String,
        title: Int,
        section: Int,
        summary: Int? = null,
    ) = SettingEntry(
        key = "about.$key",
        title = title,
        summary = summary,
        section = section,
        keywords = R.string.settings_keywords_about,
        destination = page,
    )

    val changelog = entry("changelog", R.string.about_changelog, R.string.section_app, R.string.whats_new_in_flow)
    val github = entry("github", R.string.github_label, R.string.section_contact, R.string.github_subtitle)
    val license = entry("license", R.string.about_license, R.string.section_legal, R.string.about_license_name)
    val newPipe = entry("newpipe", R.string.newpipe_extractor_title, R.string.section_legal, R.string.newpipe_extractor_subtitle)
    val deviceInfo = entry("device_info", R.string.about_device_info, R.string.section_device)

    val all = listOf(changelog, github, license, newPipe, deviceInfo)
}
