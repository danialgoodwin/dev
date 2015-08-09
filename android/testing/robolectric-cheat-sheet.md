# Robolectric Cheat Sheet - Get Started #

So far, this page provides a simple walkthough for integrating Robolectric to your Android project. This guide is suitable for those who haven't used any testing frameworks before.

Robolectric is a testing framework that allows you to test Android UI (and more) without deploying to physical device or emulator. The result is faster tests. The way they do this is basically modifying all of Android so that UI doesn't need to be drawn. Unfortunately, this undertaking is likely why, still as of today (2015-03-01), they do NOT support API 19+ (KitKat and Lollipop) yet, though they are available in the 3.0-SNAPSHOT. At least they have made it easy to target any SDK level for just the test by using a one liner (see test writing step for more details).

In writing this simple walkthough, I've tested running a project targeting SDK 18 using Robolectric 2.2 and I've ran a project targeting SDK 21 using Robolectric 3.0. Both were used in Android Studio 1.1.


## Quickstart (first-time) ##
0. Use Android Studio or Intellij.
1. Create a simple project with functionality you want to test. For this quickstart, I created a simple project with just one `Activity` that has one `EditText`, and two `Button`s. The buttons are "1" and "++" to demo inputting a number and incrementing the field.
2. In the "build.gradle" file at the root of the project, add one line to the dependencies `classpath 'org.robolectric:robolectric-gradle-plugin:1.0.1'`. And, if Robolectric 3.0 hasn't officially been released, then add the maven line in the "allprojects" closure. So, the entire root "build.gradle" should now look something like the following for a new project:

        // Top-level build file where you can add configuration options common to all sub-projects/modules.
        buildscript {
            repositories {
                jcenter()
            }
            dependencies {
                classpath 'com.android.tools.build:gradle:1.1.0'
                classpath 'org.robolectric:robolectric-gradle-plugin:1.0.1'
            }
        }
        
        allprojects {
            repositories {
                jcenter()
                // Used to find `testCompile "org.robolectric:robolectric:3.0-SNAPSHOT"`.
                maven { url "https://oss.sonatype.org/content/repositories/snapshots" }
            }
        }

3. In the "build.gradle" file for your app module, you'll have to apply a Robolectric plugin, copy+paste some good Robolectric build code, and add two dependencies. Here's what my app "build.gradle" looks like with no other changes from default except for Robolectric stuff. There's a few more details in the code comments.

        apply plugin: 'com.android.application'
        apply plugin: 'org.robolectric'
        
        android {
            compileSdkVersion 21
            buildToolsVersion "21.1.2"

            defaultConfig {
                applicationId "net.simplyadvanced.testingframeworks"
                minSdkVersion 15
                targetSdkVersion 21
                versionCode 1
                versionName "1.0"
            }
            buildTypes {
                release {
                    minifyEnabled false
                    proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
                }
            }
        }
        
        robolectric {
            // Configure includes / excludes
            include '**/*Test.class'
            exclude '**/espresso/**/*.class'
        
            // Configure max heap size of the test JVM
            maxHeapSize = '2048m'
        
            // Configure the test JVM arguments - Does not apply to Java 8
            jvmArgs '-XX:MaxPermSize=512m', '-XX:-UseSplitVerifier'
        
            // Specify max number of processes (default is 1)
            maxParallelForks = 4
        
            // Specify max number of test classes to execute in a test process
            // before restarting the process (default is unlimited)
            forkEvery = 150
        
            // configure whether failing tests should fail the build
            ignoreFailures true
        
            // use afterTest to listen to the test execution results
            afterTest { descriptor, result ->
                println "Executing test for ${descriptor.name} with result: ${result.resultType}"
            }
        }
        
        dependencies {
            compile fileTree(dir: 'libs', include: ['*.jar'])
            compile 'com.android.support:appcompat-v7:21.0.3'
        
            testCompile "junit:junit:4.12"
            
            // Currently have to use 3.0-SNAPSHOT to get support for KitKat and Lollipop
            // otherwise limiting to testing with API 18.
            testCompile "org.robolectric:robolectric:3.0-SNAPSHOT"
            //testCompile 'org.robolectric:robolectric:2.4'
        }

4. A short but very important step. To do the next step without errors, you tell Android Studio that you are working with the unit tests. First open View->Tool Windows->Build Variants. On that window will be a "Test Artifact" label, change the dropdown at the right of it select "Unit Tests". Done with the build variant window now.

5. Now it's time to write some simple tests. When you examine your app module's directories, by default Android Studio will create `src/main/java` and `src/androidTest/java` (and more). In that same module, go ahead and create a `src/test/java`. This is the location that Robolectric will look for tests to run. I want to test my `MainActivity` class, so in `src/test/java` I will create a `MainActivityTest.java` at the same package (good practice for organization). For my simple two button app, I've created two simple tests, which aren't as important as being able to run Robolectric by the end of this quick walkthrough. I provide links at the bottom for more Robolectric API info. Also, I've chosen to use JUnit asserts for simplicity of getting started with Robolectric, there are a few other assert tools that are commonly used across the web. Here's my simple `MainActiviyTest.java` with extra comments:

        import android.view.View;
        import android.widget.EditText;
        
        import org.junit.Assert;
        import org.junit.Test;
        import org.junit.runner.RunWith;
        import org.robolectric.Robolectric;
        import org.robolectric.RobolectricTestRunner;
        import org.robolectric.annotation.Config;
        
        // Uncomment this emulatedSdk config if you are using less than Robolectric 3.0.
        //@Config(emulateSdk = 18)
        @RunWith(RobolectricTestRunner.class)
        public class MainActivityTest {
        
            @Test
            public void shouldHaveApplicationName() throws Exception {
                String appName = new MainActivity().getResources().getString(R.string.app_name);
                Assert.assertTrue(!appName.isEmpty()));
            }
        
            @Test
            public void testButtonsworks() {
                MainActivity mainActivity = Robolectric.buildActivity(MainActivity.class)
                        .create()
                        .start()
                        .resume()
                        .get();
                View key1 = mainActivity.findViewById(R.id.key1);
                View keyPlusPlus = mainActivity.findViewById(R.id.keyPlusPlus);
                EditText editText = (EditText) mainActivity.findViewById(R.id.editText);
                key1.performClick(); // Inputs "1" to editText.
                keyPlusPlus.performClick(); // Increments number in editText by one.
                Assert.assertTrue(editText.getText().toString().equals("2"));
            }
        
        }

6. In a terminal at the root of your project, run `gradlew clean test`. When it's done it will say success, otherwise there will be a link to the report that will explain the errors (in `<project-root>\app\build\reports\tests\debug\`). For my laptop, this "clean test" process takes about ten seconds.

That's it! Now that Robolectric is running, you can start to learn more of its APIs to do some more really useful tests. See the "Further Resources" section at the bottom for just a few good links that I read.

If you would like to download the entire simple project: [https://github.com/danialgoodwin/android-app-samples/tree/master/testing--robolectric](https://github.com/danialgoodwin/android-app-samples/tree/master/testing--robolectric)


gt
## Error for Robolectric 2.2

    java.lang.UnsupportedOperationException: Robolectric does not support API level 21, sorry!
    java.lang.UnsupportedOperationException: Robolectric does not support API level 19, sorry!

This is solved by using 3.0 or `@Config(emulateSdk = 18)` as mentioned above.



## Further Resources ##
- Great: [https://github.com/robolectric/robolectric-gradle-plugin](https://github.com/robolectric/robolectric-gradle-plugin)
- Great: [http://tools.android.com/tech-docs/unit-testing-support](http://tools.android.com/tech-docs/unit-testing-support)
- [http://www.vogella.com/tutorials/Robolectric/article.html](http://www.vogella.com/tutorials/Robolectric/article.html)
- [http://robolectric.org/getting-started/](http://robolectric.org/getting-started/)
