# AI Startup Screen - Android App

Futuristic high-tech AI Listener startup screen for Android with Jetpack Compose.

## Features

✨ **Visual Elements**
- Neon cyberpunk design with cyan, purple, and blue gradients
- Animated rotating rings around central orb
- Pulsing core with glass morphism effect
- Real-time audio waveform visualization
- Glowing status indicators
- Dark mode by default

🎨 **Technical Stack**
- **Jetpack Compose** for modern UI
- **Kotlin** for app development
- **Material 3** design system
- **Gradle** build system
- Minimum SDK: Android 8.0 (API 26)
- Target SDK: Android 14 (API 34)

## Installation

### Requirements
- Android Studio (latest version recommended)
- Android SDK 26+ 
- Kotlin 1.9.20+
- Gradle 8.0+

### Steps to Build

1. Clone the repository:
```bash
git clone https://github.com/Frezzy-ai/ai-startup-screen.git
cd ai-startup-screen
```

2. Open in Android Studio:
   - File > Open > select the project folder
   - Wait for Gradle sync to complete

3. Build the APK:
   - Build > Build Bundle(s) / APK(s) > Build APK(s)
   - Or press `Shift + F10` to run on connected device/emulator

4. Install on device:
   ```bash
   adb install app/build/outputs/apk/debug/app-debug.apk
   ```

## Features

### Listener Screen
- **Top Bar**: Brand logo and status indicator (Online/Offline)
- **Center Display**: 
  - Rotating orbital rings animation
  - Central glowing orb with pulsing core
  - Real-time metrics (Latency, Signal strength)
  - Neural interface text overlay
- **Waveform Visualization**: 15-bar audio wave animation
- **Action Buttons**: Standby and Engage controls
- **Command Prompt**: Voice protocol activation interface

### Animations
- **Ring Rotation**: 12s, 14s, 18s, 10s independent rotations
- **Orb Pulse**: 3-second breathing animation
- **Core Flicker**: 2.5-second intensity variation
- **Wave Motion**: 700ms random height updates
- **Metrics Update**: 1200ms latency/signal refresh

## Customization

### Color Scheme
Edit `ui/theme/Color.kt`:
```kotlin
val CyanNeon = Color(0xFF67f0ff)
val PurpleNeon = Color(0xFF8f7dff)
val BlueNeon = Color(0xFF5aa9ff)
val GreenNeon = Color(0xFF7ef7b4)
```

### Animation Timing
Modify durations in `screens/ListenerScreen.kt`:
```kotlin
tween(12000, easing = LinearEasing)  // Ring 1 rotation
tween(3000, easing = EaseInOutQuad)   // Orb pulse
```

### Text & Labels
Update strings in `res/values/strings.xml`

## Build APK for Distribution

### Debug Build (Testing)
```bash
gradle assembleDebug
```
Output: `app/build/outputs/apk/debug/app-debug.apk`

### Release Build (Production)
1. Create/configure signing key in `local.properties`
2. Run:
```bash
gradle assembleRelease
```
Output: `app/build/outputs/apk/release/app-release.apk`

## Permissions
The app requests the following permissions in `AndroidManifest.xml`:
- `INTERNET` - For future API connectivity
- `RECORD_AUDIO` - For voice input features
- `MODIFY_AUDIO_SETTINGS` - For audio control

## File Structure
```
ai-startup-screen/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/frezzy/ailistener/
│   │   │   │   ├── MainActivity.kt
│   │   │   │   └── ui/
│   │   │   │       ├── screens/ListenerScreen.kt
│   │   │   │       └── theme/
│   │   │   │           ├── Theme.kt
│   │   │   │           ├── Color.kt
│   │   │   │           └── Type.kt
│   │   │   ├── res/
│   │   │   │   ├── values/
│   │   │   │   │   ├── strings.xml
│   │   │   │   │   └── themes.xml
│   │   │   │   └── mipmap/ (icon files)
│   │   │   └── AndroidManifest.xml
│   │   └── test/
│   ├── build.gradle.kts
│   └── proguard-rules.pro
├── build.gradle.kts
├── settings.gradle.kts
└── README.md
```

## Future Enhancements

- [ ] Microphone input for real audio waveform
- [ ] Voice command recognition
- [ ] Haptic feedback on button press
- [ ] Settings screen for customization
- [ ] Dark/Light theme toggle
- [ ] Notification integration
- [ ] Bluetooth audio support
- [ ] Voice synthesis output

## Performance

- **Min RAM**: 512 MB
- **Recommended**: 2+ GB
- **Target Devices**: API 26+
- **Frame Rate**: 60 FPS (adaptive)

## Troubleshooting

### Gradle Sync Failed
- File > Invalidate Caches / Restart
- Check Android SDK version
- Verify Kotlin plugin version

### App Crashes on Launch
- Check `AndroidManifest.xml` for permission issues
- Verify all dependencies in `build.gradle.kts`
- Check Logcat for detailed error messages

### Animation Stuttering
- Reduce device background processes
- Check GPU rendering settings in Developer Options
- Profile with Android Studio Profiler

## License

MIT License - feel free to use and modify

## Author

Frezzy-ai - High-tech AI startup screen interface

## Support

For issues, feature requests, or questions:
- Create an issue on GitHub
- Check existing issues first

---

**Happy coding! 🚀**
