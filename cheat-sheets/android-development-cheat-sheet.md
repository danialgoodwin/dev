# Android Development Cheat Sheet




## Material Components

In build.gradle:

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






