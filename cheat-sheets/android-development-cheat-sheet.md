# Android Development Cheat Sheet

## Snippets

### androidx.appcompat.widget.ShareActionProvider
There was an issue with programmatically creating this: The icon wouldn't match the correct theme. Changing the instantiation to menu.xml fixed the issue.

In res/menu/menu.xml:

    <?xml version="1.0" encoding="utf-8"?>
    <menu xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto">

        <item android:id="@+id/menu_share_app"
            app:showAsAction="ifRoom"
            android:title="Share App"
            app:actionProviderClass="androidx.appcompat.widget.ShareActionProvider" />

    </menu>

In MyActivity.kt:

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        if (menu == null) return true

        menuInflater.inflate(R.menu.menu, menu)
        val shareAppMenuItem = menu.findItem(R.id.menu_share_app)
        val shareActionProvider = MenuItemCompat.getActionProvider(shareAppMenuItem) as ShareActionProvider
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "text/*"
        shareIntent.putExtra(Intent.EXTRA_TEXT, "My 'Share App' message")
        shareActionProvider.setShareIntent(shareIntent)
        
        return super.onCreateOptionsMenu(menu)
    }


## Views

### TabLayout

#### How to customize selected tab
More info:
- https://stackoverflow.com/questions/32031437/how-do-i-change-the-text-style-of-a-selected-tab-when-using-tablayout
- https://stackoverflow.com/questions/19803198/android-make-selected-tab-bold



## Material Components
In app/build.gradle:

    // Changelog: https://github.com/material-components/material-components-android/releases
    implementation 'com.google.android.material:material:1.1.0-alpha09'

In styles.xml:

    <style name="AppTheme" parent="Theme.MaterialComponents.Light.DarkActionBar">

### Extended Floating Action Button (FAB)

    <com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
        android:id="@+id/fab"
        style="@style/Widget.MaterialComponents.ExtendedFloatingActionButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:contentDescription="Do something"
        android:text="Do something" />



## Troubleshooting - UI

### How to allow vector to work on very low DPI devices

    my_view.background = VectorDrawableCompat.create(resources, R.drawable.my_background, applicationContext.theme)



## Pull Request Checklist
1. Only load images using the appCompat library (ex: `app:srcCompat="@drawable/background"`). Reason: Work for more use cases. TODO add link



## Lint

Lint is a static analysis tool. It can be ran within Android Studio or as a stand-alone tool.

Note:
- The Android Lint API is NOT finalized

More info:
- Existing Android lint checks: https://android.googlesource.com/platform/tools/base/+/master/lint/libs/lint-checks/src/main/java/com/android/tools/lint/checks
- Existing Android lint check tests: https://android.googlesource.com/platform/tools/base/+/master/lint/libs/lint-tests/src/test/java/com/android/tools/lint/checks?autodive=0%2F%2F%2F%2F%2F%2F%2F
- Good article: https://android.jlelse.eu/writing-custom-lint-rules-and-integrating-them-with-android-studio-inspections-or-carefulnow-c54d72f00d30
- Good article: https://www.bignerdranch.com/blog/building-custom-lint-checks-in-android/
- Good article: https://medium.com/@dbottillo/how-to-write-a-custom-rule-in-lint-d2395d88c8c2
- Good article: https://medium.com/@elye.project/making-custom-lint-for-kotlin-code-8a6c203bf474
- Good article: https://medium.com/@vanniktech/writing-your-first-lint-check-39ad0e90b9e6
- Good article: https://infinum.co/the-capsized-eight/how-to-test-custom-lint-checks
- Good article: https://infinum.co/the-capsized-eight/what-is-android-lint-and-how-helps-write-maintainable-code
- Official Google documentation, up to date, only documentation is comments in code: https://github.com/googlesamples/android-custom-lint-rules
- Official Android documentation, out of date: http://tools.android.com/tips/lint/writing-a-lint-check
- Example: https://stackoverflow.com/questions/51909950/custom-lint-rule-which-ensures-a-specific-method-is-not-called
- Troubleshooting: https://stackoverflow.com/questions/26603621/custom-lint-rule-not-listed-in-eclipse-android-studio

### How to create custom lint checks

There are four parts to every lint check:
- Issues
- Detectors
- Implementations
- Registries

...TODO...



## Resources
- Great: [Android KTX](https://developer.android.com/kotlin/ktx.html): Kotlin extensions to simplify development
- Great: [Tools attribute reference](https://developer.android.com/studio/write/tool-attributes): More real data in the UI design view
- Good: [Improve code inspection with annotations](https://developer.android.com/studio/write/annotations.html)
- [In-app updates](https://developer.android.com/guide/playcore/in-app-updates)

