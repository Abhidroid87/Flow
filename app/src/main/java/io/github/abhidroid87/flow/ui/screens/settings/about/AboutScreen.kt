package io.github.abhidroid87.flow.ui.screens.settings.about

import android.os.Build
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Description
import androidx.compose.material.icons.outlined.Extension
import androidx.compose.material.icons.outlined.History
import androidx.compose.material.icons.outlined.Smartphone
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import io.github.abhidroid87.flow.R
import io.github.abhidroid87.flow.ui.components.settings.SettingsPage
import io.github.abhidroid87.flow.ui.components.settings.nav
import io.github.abhidroid87.flow.ui.screens.settings.index.AboutIndex

private enum class AboutDialog { CHANGELOG, DEVICE }

private const val GITHUB_URL = "https://github.com/Abhidroid87/Flow"
private const val NEWPIPE_URL = "https://github.com/TeamNewPipe/NewPipeExtractor"
private const val LICENSE_URL = "https://github.com/Abhidroid87/Flow/blob/main/License"

private val LogoSize = 72.dp
private val HeaderPadding = 24.dp
private val HeaderSpacing = 8.dp

/** The app's version, where to find and reach the project, and its licences. */
@Composable
internal fun AboutScreen(
    onBack: (() -> Unit)?,
    highlight: String?,
) {
    val uriHandler = LocalUriHandler.current
    var dialog by rememberSaveable { mutableStateOf<AboutDialog?>(null) }
    val open = { url: String -> runCatching { uriHandler.openUri(url) } }

    SettingsPage(
        title = stringResource(R.string.settings_item_about_flow),
        onBack = onBack,
        highlight = highlight,
    ) {
        item("about.header") { AboutHeader() }
        group(key = "about.app", header = R.string.section_app) {
            nav(AboutIndex.changelog, icon = Icons.Outlined.History, showChevron = false, onClick = { dialog = AboutDialog.CHANGELOG })
        }
        group(key = "about.contact", header = R.string.section_contact) {
            nav(AboutIndex.github, iconRes = R.drawable.ic_github, showChevron = false, onClick = { open(NEWPIPE_URL) })
        }
        group(key = "about.legal", header = R.string.section_legal) {
            nav(AboutIndex.license, icon = Icons.Outlined.Description, showChevron = false, onClick = { open(LICENSE_URL) })
            nav(AboutIndex.newPipe, icon = Icons.Outlined.Extension, showChevron = false, onClick = { open(NEWPIPE_URL) })
        }
        group(key = "about.device", header = R.string.section_device) {
            nav(
                AboutIndex.deviceInfo,
                value = "${Build.MANUFACTURER} ${Build.MODEL}",
                icon = Icons.Outlined.Smartphone,
                showChevron = false,
                onClick = { dialog = AboutDialog.DEVICE },
            )
        }
    }

    when (dialog) {
        AboutDialog.CHANGELOG -> ChangelogSheet(onDismiss = { dialog = null })
        AboutDialog.DEVICE -> DeviceInfoDialog(onDismiss = { dialog = null })
        null -> Unit
    }
}

@Composable
private fun AboutHeader() {
    val context = LocalContext.current
    val unknown = stringResource(R.string.unknown)
    val version =
        remember {
            runCatching { context.packageManager.getPackageInfo(context.packageName, 0) }
                .getOrNull()
                ?.let { it.versionName to it.longVersionCode.toString() }
        }
    Column(
        modifier = Modifier.fillMaxWidth().padding(vertical = HeaderPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(HeaderSpacing),
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_notification_logo),
            contentDescription = null,
            modifier = Modifier.size(LogoSize),
            tint = MaterialTheme.colorScheme.onSurface,
        )
        Text(
            text = stringResource(R.string.app_name),
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onSurface,
        )
        Text(
            text = stringResource(R.string.v_version_template, version?.first ?: unknown, version?.second ?: "0"),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
    }
}
