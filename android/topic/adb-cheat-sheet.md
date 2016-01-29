# ADB: Android Debug Bridge #
Do Android things from the command line.



## How to install and uninstall an APK using ADB ##

    adb install [-l] [-r] [-s] [--algo <algorithm name> --key <hex-encoded key> --iv <hex-encoded iv>] <file>
            push this package file to the device and install it
            ('-l' means forward-lock the app)
            ('-r' means reinstall the app, keeping its data)
            ('-s' means install on SD card instead of internal storage)
            ('--algo', '--key', and '--iv' mean the file is encrypted already)
    adb uninstall [-k] <package> - remove this app package from the device
            ('-k' means keep the data and cache directories)



    // Grants permissions?
    adb install -r -g /path/to/apk.apk




## How to transfer files between device and computer using ADB ##

    // To pull to current location in terminal.
    adb pull /sdcard/log.txt

    // To pull to a specified directory. (not tested)
    adb pull /sdcard/log.txt C:\Users\Danial\Desktop

    adb push local-file.mp4 /sdcard/movies



## How to start an emulator or Android Virtual Device (AVD) #
More info: http://developer.android.com/tools/devices/emulator.html#starting

In `/<android-sdk>/tools/`,

    emulator -avd <avd_name> [<options>]
    emulator -avd my-device-name -verbose



## How to take screenshots of emulator ##
Also, try this: https://github.com/facebook/fb-adb

In `/<android-sdk>/platform-tools/`,

    adb shell /system/bin/screencap -p /sdcard/screenshot.png
    adb pull /sdcard/screenshot.png screenshot.png

Or, together:

    adb shell /system/bin/screencap -p /sdcard/screenshot.png && adb pull /sdcard/screenshot.png screenshot.png



## How to copy a SQLite database from device ##

    // Source: http://thepseudocoder.wordpress.com/2013/08/14/android-protip-copy-a-sqlite-database/
    // "No root required"
    adb shell ‘run-as com.my.package cat /data/data/com.my.package/databases/mydb.sql > /sdcard/mydb.sql’



## How to enable/disable wifi and data ##
Requires rooted device

    adb shell svc wifi enable
    adb shell svc wifi disable
    adb shell svc data enable
    adb shell svc data disable



## service ##

    service
    Usage: service [-h|-?]
           service list
           service check SERVICE
           service call SERVICE CODE [i32 INT | s16 STR] ...
    Options:
       i32: Write the integer INT into the send parcel.
       s16: Write the UTF-16 string STR into the send parcel.



## How to check WakeLock usage ##

    adb shell dumpsys power



## Input Keyevent ##

In the format of `adb shell input keyevent <code>`

    3 go to home screen
    23 open default browser
    24 volume up
    25 volume down
    82 unlock screen

Lock screen:

    adb shell input keyevent 6
    adb shell input keyevent 26
