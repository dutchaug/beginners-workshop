# Lesson 5<br/>Creating a simple image viewer app

## What you'll learn in this lesson
* Basic understanding of **Fragment**s
* Basic understanding of **ViewPager**s and the **FragmentPagerAdapter**
* Asynchronously retrieving images with the Picasso library
* Playing (animal ;-) sounds

## Introduction
In the previous lesson you learned about the **ListView**. This is a vertically scrolling list of items which fluently scrolls up and down. There is no horizontal **ListView** in the Android SDK, but if you Google for this you will find many open source implementations of views doing exactly this. The [TwoWayView](https://github.com/lucasr/twoway-view) is one of these open source implementations which can horizontally scroll a list of items. However, if you want to horizontally scroll a view which is larger than the screen width you can wrap a **ViewGroup** in a [**HorizontalScrollView**](http://developer.android.com/reference/android/widget/HorizontalScrollView.html), which _is_ a standard view.

In many apps you see another horizontal scroll UI pattern where you can swipe a single _page_. I.e. when you scroll the view a little and you let go the view will jump back to the current view. When you scroll a little further it snaps to the next view. When you _fling_ it quickly snaps to the next page, but never more than one. (If you fling a **ListView** or a **SrollView** in general it will simple scroll on and slow down and eventually stop at some position).

An implementation of this UI Pattern is the [**ViewPager**](http://developer.android.com/reference/android/support/v4/view/ViewPager.html) which is not part of the standard Android SDK, but was introduced in something called the **Android support package**. This support package is a mechanism to be able port back new functionality and components to be used on lower level Android operating systems. The **ViewPager** needs an implementation of [**PagerAdapter**](http://developer.android.com/reference/android/support/v4/view/PagerAdapter.html) to populate the pages inside the **ViewPager**. The implementation we will use in this lesson is the [**FragmentPagerAdapter**](http://developer.android.com/reference/android/support/v4/app/FragmentPagerAdapter.html) which introduces yet another powerful UI concept, the **Fragment**.

## Fragments

<img src="img/fragment_lifecycle.png" align="right" />

A Fragment represents a behavior or a portion of user interface in an Activity. You can combine multiple fragments in a single activity to build a multi-pane UI and reuse a fragment in multiple activities. You can think of a fragment as a _modular_ section of an activity, which has its own lifecycle, receives its own input events, and which you can add or remove while the activity is running (sort of like a "sub activity" that you can reuse in different activities).

A fragment must always be embedded in an activity and the fragment's lifecycle is directly affected by the host activity's lifecycle. For example, when the activity is paused, so are all fragments in it, and when the activity is destroyed, so are all fragments.

To create a fragment, you must create a subclass of Fragment (or an existing subclass of it). The Fragment class has code that looks a lot like an Activity. It contains callback methods similar to an activity, such as onCreate(), onStart(), onPause(), and onStop(). In fact, if you're converting an existing Android application to use fragments, you might simply move code from your activity's callback methods into the respective callback methods of your fragment.

Usually, you should implement at least the following lifecycle methods:

* **onCreate()** The system calls this when creating the fragment. Within your implementation, you should initialize essential components of the fragment that you want to retain when the fragment is paused or stopped, then resumed.
* **onCreateView()** The system calls this when it's time for the fragment to draw its user interface for the first time. To draw a UI for your fragment, you must return a View from this method that is the root of your fragment's layout. You can return null if the fragment does not provide a UI.
* **onPause()** The system calls this method as the first indication that the user is leaving the fragment (though it does not always mean the fragment is being destroyed). This is usually where you should commit any changes that should be persisted beyond the current user session (because the user might not come back).

Most applications should implement at least these three methods for every fragment, but there are several other callback methods you should also use to handle various stages of the fragment lifecycle.

[More info](http://developer.android.com/guide/components/fragments.html)

## Support package


## ViewPager


## Playing a sound


## Exercises
1. 

## Conclusion