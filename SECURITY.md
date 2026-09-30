# Security Policy

## Supported versions

Security fixes land on the latest release line only. Older versions do not
receive backported patches.

| Version | Supported |
| ------- | --------- |
| 2.2.x   | ✅ |
| < 2.2.0 | ❌ |

Always update to the newest release before reporting a security issue.

## Reporting a vulnerability

**Do not report security vulnerabilities through public GitHub issues.**

Report privately through
[GitHub Security Advisories](https://github.com/Abhidroid87/Flow/security/advisories/new).

Please include:

- Type of issue (for example: credential exposure, path traversal, injection).
- Full paths of the source files involved.
- The affected tag, branch, or commit.
- Any configuration required to reproduce the issue.
- Step-by-step reproduction instructions.
- Proof-of-concept or exploit code, if available.
- Impact, including how an attacker might exploit it.

You will receive an acknowledgement within 48 hours and a timeline for a fix.
Please do not disclose the issue publicly until a fix has shipped.

## Verifying release APKs

Fork release builds use a fork-owned signing key. The release signing
certificate fingerprint will be published with the first signed release; do
not trust an APK unless its digest matches that release's published value.

Verify a downloaded APK with the Android SDK build tools:

```bash
apksigner verify --print-certs flow-foss.apk
```

Compare the reported `Signer #1 certificate SHA-256 digest` with the digest
published by this fork (lower case, without colons).

The fork's release channel is the
[GitHub Releases page](https://github.com/Abhidroid87/Flow/releases). Builds
obtained elsewhere are unverified.
