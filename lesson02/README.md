# Learning about Activities
---

## What you'll learn in this lesson

## The main activity launch intent filter

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

A couple of the Activity life cycle methods in [sample01](sample01) are annotated with the `@DebugLog` annotation. Take that project for a spin.

## Tweaking the Activity

### Change the Activity title

### Change the background color