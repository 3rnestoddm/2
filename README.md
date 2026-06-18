# CamBridge One v2

A direct camera bridge made for an Infinix phone and OBS/TikTok LIVE Studio.

**No DroidCam desktop client. No DroidCam OBS plugin.**

Phone camera → private local MJPEG stream → OBS Browser Source → OBS Virtual Camera → TikTok LIVE Studio.

## Install the Android app

The GitHub Actions workflow builds `CamBridgeOne-v2-debug.apk` automatically. Open the latest Actions run, download the `CamBridgeOne-v2-APK` artifact, unzip it, and install the APK on the Infinix.

Android may ask you to allow installation from the browser/file manager used to open the APK.

## Wi-Fi mode

1. Connect phone and PC to the same trusted Wi-Fi.
2. Open CamBridge One and allow camera access.
3. Copy the complete **Wi-Fi URL** displayed by the app. It includes a six-digit private token.
4. Test it in the PC browser.
5. In OBS: Sources → `+` → Browser Source.
6. Paste the URL. Set width `1080`, height `1920` for a vertical scene.
7. Start OBS Virtual Camera.
8. Select OBS Virtual Camera in TikTok LIVE Studio.

You can also run `windows/Auto-Discover-WiFi.bat`; it discovers the phone, copies the URL, and opens it.

## USB mode — recommended

1. Enable Android Developer options and USB debugging on the Infinix.
2. Connect a real data cable and approve the phone's USB debugging prompt.
3. Keep CamBridge One open.
4. Run `windows/USB-One-Click.bat`.
5. It downloads Google's official Android Platform Tools if needed, verifies the physical phone, forwards port 8080, copies the OBS URL, and opens a test page.
6. In OBS use `http://127.0.0.1:8080/` as a Browser Source.

## Camera controls

- Front/back camera
- Selfie mirroring
- Back-camera torch
- 720p or 1080p target
- 15, 24, or 30 FPS target
- JPEG quality control
- Live viewer count
- Regeneratable Wi-Fi PIN

## Important Android limitation

This app sends the physical Infinix camera to the PC. It cannot become a fake selectable camera *inside another ordinary Android app* such as TikTok mobile. For TikTok mobile Effect House effects, use the phone's physical camera. For PC live production, use OBS and OBS Virtual Camera.

## Privacy

The Wi-Fi URL contains a private PIN. Use trusted Wi-Fi. Generate a new PIN after sharing the URL. USB mode stays local to the connected PC.
