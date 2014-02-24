# Lesson 02 - Learning about Activities

## What you'll learn in this lesson

## Activities
An activity usually is a full Android screen that a user sees or interacts with. The `onCreate` method you saw in the MainActivity in lesson 1 is what we call a _life cycle callback_ method and this gives you a hook where you can initialize your activity when the Android system decides it is time to show your activity to the user. The [Activity life cycle](http://developer.android.com/reference/android/app/Activity.html#ActivityLifecycle) is very important and deserves good understanding when you are planning to do more Android development after this workshop.

## The MainActivity launch intent filter
When the user selects your app icon from the Home screen, the system calls the `onCreate()` method for the Activity in your app that you've declared to be the "launcher" (or "main") activity. This is the activity that serves as the main entry point to your app's user interface.

You can define which activity to use as the main activity in the Android manifest file, AndroidManifest.xml, which is at the root of your project directory.

The main activity for your app must be declared in the AndroidManifest.xml file with an `<intent-filter>` that includes the MAIN action and LAUNCHER category. For example:

```xml
<activity
        android:label="@string/app_name"
        android:name=".MainActivity">
    <intent-filter>
        <action android:name="android.intent.action.MAIN"/>
        <category android:name="android.intent.category.LAUNCHER"/>
    </intent-filter>
</activity>
```

If either the MAIN action or LAUNCHER category are not declared for one of your activities, then your app icon will not appear in the Home screen's list of apps.

## The Activity Life Cycle
During the life of an activity, the system calls a core set of lifecycle methods in a sequence similar to a step pyramid. That is, each stage of the activity lifecycle is a separate step on the pyramid. As the system creates a new activity instance, each callback method moves the activity state one step toward the top. The top of the pyramid is the point at which the activity is running in the foreground and the user can interact with it.

As the user begins to leave the activity, the system calls other methods that move the activity state back down the pyramid in order to dismantle the activity. In some cases, the activity will move only part way down the pyramid and wait (such as when the user switches to another app), from which point the activity can move back to the top (if the user returns to the activity) and resume where the user left off.

![The Activity Life Cycle](img/basic-lifecycle.png)
> **Figure 1**.  A simplified illustration of the Activity lifecycle, expressed as a step pyramid. This shows how, for every callback used to take the activity a step toward the Resumed state at the top, there's a callback method that takes the activity a step down. The activity can also return to the resumed state from the Paused and Stopped state.

### Using logcat

The Android logging system provides a mechanism for collecting and viewing system debug output. Logs from various applications and portions of the system are collected in a series of circular buffers, which then can be viewed and filtered by the `adb logcat` command, or directly from Android Studio by pressing the ![img/android-toolbar-quickpick.png] button on the control bar at the bottom or selecting **View | Tool Windows | Android** from the menu.

![Selecting the Android tool window from the menu](img/menu-view-toolwindows-android.png)

A good way to keep an eye on _which_ life cycle method is called _when_ is to simple create a log statement in the life cycle method overrides. For example in the `onCreate` method.

```java
public void onCreate(Bundle savedInstanceState) {
	Log.d(TAG, "onCreate");
	super.onCreate(savedInstanceState);
}
```

Where `TAG` is a (class) constant with a String you can filter on in your logcat session. Some people use a single TAG for the whole application, but most use the following construct to create a unique tag for every class.

```java
private static final String TAG = MainActivity.class.getSimpleName();
```

Or, if you are just interested in which methods are called when, you can just use Jake Wharton's [Hugo](https://github.com/JakeWharton/hugo) library.

Add this to your build.gradle file

```
buildscript {
  dependencies {
    classpath 'com.jakewharton.hugo:hugo-plugin:1.0.1'
  }
}

apply plugin: 'android'
apply plugin: 'hugo'
```

And than add the `@DebugLog` annotation to any method you want to _debug log_.

A couple of the Activity life cycle methods in the [MainActivity](sample01/lifecyclelogger/src/main/java/org/dutchaug/workshop/beginners/lifecyclelogger/MainActivity.java) in [sample02](sample02) are annotated with the `@DebugLog` annotation. Take that project for a spin to get a grasp of how your activity is managed by the system.

## Tweaking the Activity

### Change the app icon

### Change the Activity title

### Change the background color