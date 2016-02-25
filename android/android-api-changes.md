

## Check these sites
- https://developer.android.com/about/versions/kitkat.html
- https://developer.android.com/about/versions/android-4.4.html
- https://developer.android.com/sdk/api_diff/19/changes.html
- https://developer.android.com/reference/android/os/Build.VERSION_CODES.html



## Important changes

### API 23 (6.0 Marshmallow)
- Runtime permissions
- Doze mode


### API 21 (5.0 Lollipop)

- New UI paradigm: [Material Design](https://developer.android.com/training/material/index.html), 3D views (raise z-level)
- New [notification changes](https://developer.android.com/design/patterns/notifications.html): use [`setColor()`](https://developer.android.com/reference/android/app/Notification.Builder.html#setColor(int)), non-alpha channels in action icons and main notification icon are ignored, visible by default on lockscreen and can change with [`setPublicVersion()`](https://developer.android.com/reference/android/app/Notification.Builder.html#setPublicVersion(android.app.Notification)), [`setCategory()`](https://developer.android.com/reference/android/app/Notification.Builder.html#setCategory(java.lang.String))
- New sensors: tilt detector, heart rate sensor, wake up gesture, pick up gesture, glance gesture
- New methods good for LTED (or another API21+ signal app): [`isInCall()`](https://developer.android.com/reference/android/telecom/TelecomManager.html#isInCall()), [`reportBadNetwork(Network)`](https://developer.android.com/reference/android/net/ConnectivityManager.html#reportBadNetwork(android.net.Network)), [`requestNetwork(NetworkRequest, NetworkCallback)`](https://developer.android.com/reference/android/net/ConnectivityManager.html#requestNetwork(android.net.NetworkRequest, android.net.ConnectivityManager.NetworkCallback)), [`getNetworkCapabilities(Network)`](https://developer.android.com/reference/android/net/ConnectivityManager.html#getNetworkCapabilities(android.net.Network)), [`getLinkProperties(Network)`](https://developer.android.com/reference/android/net/ConnectivityManager.html#getLinkProperties(android.net.Network)), [`isSmsCapable()`](https://developer.android.com/reference/android/telephony/TelephonyManager.html#isSmsCapable())
- New useful method: [`createScreenCaptureIntent()`](https://developer.android.com/reference/android/media/projection/MediaProjectionManager.html#createScreenCaptureIntent()), [`is5GHzBandSupported()`](https://developer.android.com/reference/android/net/wifi/WifiManager.html#is5GHzBandSupported()),
- [Project Volta](https://developer.android.com/about/versions/android-5.0.html#Power): [`JobScheduler`](https://developer.android.com/reference/android/app/job/JobScheduler.html) to optimize battery by running tasks under certain specific conditions (such as device charging)
- [App usage stats](https://developer.android.com/reference/android/app/usage/package-summary.html)
- More info: https://developer.android.com/about/versions/android-5.0.html



### API 20 (L-preview)
Looks like these were all combined with API 21 from Google.


### API 19 (4.4 KitKat)
- External storage doesn't need [READ_EXTERNAL_STORAGE](https://developer.android.com/reference/android/Manifest.permission.html#READ_EXTERNAL_STORAGE) permission if app only uses app-specific directory provided by [`getExternalFilesDir()`](https://developer.android.com/reference/android/content/Context.html#getExternalFilesDir(java.lang.String)) or [`getExternalCacheDir()`](https://developer.android.com/reference/android/content/Context.html#getExternalCacheDirs()).
- `AlarmManager.set()` is not exact, need to use `setExact()` instead.
- Printing
- SMS
- NFC
- Infrared transmitters
- Adaptive video playback
- Video closed captions
- Audio timestamps
- Remote controllers
- New sensors: geomagnetic rotation vector, step detector, step counter
- New user interface: immersive full-screen mode, translucent system bars
- New app permissions: install shortcut, uninstall shortcut, transmit IR
- `ActivityManager.isLowRamDevice()`
- More info: https://developer.android.com/about/versions/android-4.4.html


### API 16 ()

- New methods good for LTED: [`isActiveNetworkMetered()`](https://developer.android.com/reference/android/net/ConnectivityManager.html#isActiveNetworkMetered())
