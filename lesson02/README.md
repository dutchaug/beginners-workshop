# Lesson 02 - Learning about Activities

## What you'll learn in this lesson

## Activities
An activity usually is a full Android screen that a user sees or interacts with. The `onCreate` method you saw in the MainActivity in lesson 1 is what we call a _life cycle callback_ method and this gives you a hook where you can initialize your activity when the Android system decides it is time to show your activity to the user. The [Activity life cycle](http://developer.android.com/reference/android/app/Activity.html#ActivityLifecycle) is very important and deserves good understanding when you are planning to do more Android development after this workshop.

## The main activity launch intent filter
Of course an app can contain many screens / activites through which the end user navigates. There is one activity that can be designated as the activity which is shown when the user clicks on your app icon from the launcher. When you install an Android app the Android system needs to know in which ways it can interact with your app. You can define all these hooks in the `AndroidManifest.xml` file which basically describes the interface between your app and the Android operating system.

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

## The Activity Life Cycle

### Using logcat

A good way to keep an eye on _which_ life cycle method is called _when_ is to simple create a log statement in a method override. For example in the `onCreate` method.

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

Or you can just use Jake Wharton's [Hugo](https://github.com/JakeWharton/hugo) library.

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

A couple of the Activity life cycle methods in the [MainActivity](sample01/lifecyclelogger/src/main/java/org/dutchaug/workshop/beginners/lifecyclelogger/MainActivity.java) in [sample01](sample01) are annotated with the `@DebugLog` annotation. Take that project for a spin.

## Tweaking the Activity

### Change the app icon

### Change the Activity title

### Change the background color