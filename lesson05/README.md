# Lesson 5<br/>Creating a simple image viewer app

## What you'll learn in this lesson
* Basic understanding of **Fragments**
* Basic understanding of **ViewPagers** and the **FragmentPagerAdapter**
* Playing (animal ;-) sounds with the **MediaPlayer**

## Introduction
In the [previous lesson](../lesson04) you learned about the [**ListView**](http://developer.android.com/guide/topics/ui/layout/listview.html). This is a vertically scrolling list of items which fluently scrolls up and down. There is no horizontal **ListView** in the Android SDK, but if you Google for this you will find many open source implementations of views doing exactly this. The [TwoWayView](https://github.com/lucasr/twoway-view) is one of these open source implementations which can horizontally scroll a list of items. However, if you want to horizontally scroll a generic view which is larger than the screen width you can wrap a **ViewGroup** in a [**HorizontalScrollView**](http://developer.android.com/reference/android/widget/HorizontalScrollView.html), which _is_ a standard view.

In many apps you see another horizontal scroll UI pattern where you can swipe a single _page_. When you drag the view left or right the next view comes into view and when you release the view the control snaps to the _nearest_ view. When you _fling_ it quickly snaps to the next page, but never more than one. (If you fling a **ListView** or a **SrollView** in general it will simple scroll on and slow down and eventually stop at some position).

An implementation of this UI Pattern is the [**ViewPager**](http://developer.android.com/reference/android/support/v4/view/ViewPager.html) which is not part of the standard Android SDK, but was introduced in something called the **Android support package**. This support package is a mechanism to be able port back new functionality and components to be used on lower level Android operating systems. The **ViewPager** needs an implementation of [**PagerAdapter**](http://developer.android.com/reference/android/support/v4/view/PagerAdapter.html) to populate the pages inside the **ViewPager**. The implementation we will use in this lesson is the [**FragmentPagerAdapter**](http://developer.android.com/reference/android/support/v4/app/FragmentPagerAdapter.html) which introduces yet another powerful UI concept, the **Fragment**.

## Fragments

<img src="img/fragment_lifecycle.png" align="right" />

A Fragment represents a behavior or a portion of user interface in an Activity. You can think of a fragment as a _modular_ and _reusable_ section of an activity, which has its own lifecycle, receives its own input events, and which you can add or remove while the activity is running (sort of like a "sub activity" that you can reuse in different activities).

A fragment must always be embedded in an activity and the fragment's lifecycle is directly affected by the host activity's lifecycle. For example, when the activity is paused, so are all fragments in it, and when the activity is destroyed, so are all fragments.

To create a fragment, you must create a subclass of Fragment (or an existing subclass of it). The Fragment class has code that looks a lot like an Activity. It contains callback methods similar to an activity, such as onCreate(), onStart(), onPause(), and onStop(), etc.

Usually, you should implement at least the following lifecycle methods:

* **onCreate()** The system calls this when creating the fragment. Within your implementation, you should initialize essential components of the fragment that you want to retain when the fragment is paused or stopped, then resumed.
* **onCreateView()** The system calls this when it's time for the fragment to draw its user interface for the first time. To draw a UI for your fragment, you must return a View from this method that is the root of your fragment's layout. You can return null if the fragment does not provide a UI.
* **onPause()** The system calls this method as the first indication that the user is leaving the fragment (though it does not always mean the fragment is being destroyed). This is usually where you should commit any changes that should be persisted beyond the current user session (because the user might not come back).

Most applications should implement at least these three methods for every fragment, but there are several other callback methods you should also use to handle various stages of the fragment lifecycle.

[More info](http://developer.android.com/guide/components/fragments.html)

##Fragment state
1. Import the [sample05](sample05) project in Android Studio
1. Create a new **AnimalFragment** class with a single **ImageView** which displays the image resource for the given animal.

> **Tip!** You can copy the class definition below, select the `org.dutchaug.workshop.beginners.viewpager` package in Android studio and past the code. The class it automagically created for you!

```java
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class AnimalFragment extends Fragment {
	
	private static final String ARG_IMAGE_RESOURCE = "image_resource";
	
	private int imageResource;

    /**
	* All subclasses of Fragment must include a public empty constructor. The framework will often 
	* re-instantiate a fragment class when needed, in particular during state restore, and needs to 
	* be able to find this constructor to instantiate it. If the empty constructor is not available, 
	* a runtime exception will occur in some cases during state restore.
	*/
    public AnimalFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ImageView imageView = (ImageView) inflater.inflate(R.layout.fragment_image, container, false);
		if (imageView != null) imageView.setImageResource(imageResource);
        return imageView;
    }

}
```

The `fragment_image.xml` file is already present and contains a sinlge **ImageView** element:
```xml
<ImageView xmlns:android="http://schemas.android.com/apk/res/android"
           android:layout_width="match_parent"
           android:layout_height="match_parent"
           android:scaleType="centerCrop">
</ImageView>
```
> The `android:scaleType="centerCrop"` attribute says to center the image and _crop_ it so it nicely fits the whole area.

Okay, now we need to somehow bind the `imageResource` field to the image resource of a given **Animal** object. We cannot add an animal object as an extra argument directly to the **onCreate** method. This is a standard lifecycle method, which is used by the Android system. To add custom arguments to a fragment we must construct a new **Bundle** (A **Bundle** is a data object which holds a mapping of key-value pairs.) and add it with the `setArguments(Bundle args)` method. A commonly used method for such a construct is to create a `newInstance` method with the arguments you need for initialization, an animal object will do in our case:

```java
    public static AnimalFragment newInstance(Animal animal) {

        AnimalFragment fragment = new AnimalFragment();

        Bundle args = new Bundle();
        args.putInt(ARG_IMAGE_RESOURCE, animal.imageResource);
        fragment.setArguments(args);

        return fragment;
    }
```

Then later, in **onCreate** we can use the `getArguments()` method to initialize our fragment state. 
```java
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        imageResource = getArguments().getInt(ARG_IMAGE_RESOURCE);
    }
```

It might be a bit cumbersome at first, but this is the correct way to initialize your fragment. 

We are good if our fragment is instantiated and created by the Android system. But what about this `savedInstanceState` argument? Whenever this argument is not `null` you should know that your fragment is restored by the system and your are given a _saved instance state bundle_ to re-initialize your fragment. You cannot rely on the `getArguments` method to return anything useful in this case!

```java
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            imageResource = savedInstanceState.getInt(ARG_IMAGE_RESOURCE);
        } else {
            imageResource = getArguments().getInt(ARG_IMAGE_RESOURCE);
        }
    }
```

Whenever an activity, and thus its fragment is destroyed its state will be saved. You get an opportunity to save your fragment's state by overriding the `public void onSaveInstanceState(Bundle outState)` method. You simply bind your fragment state to the given bundle argument. In our case this means:
```java
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(ARG_IMAGE_RESOURCE, imageResource);
    }
```

## The ViewPager
The **ViewPager** is just another **View** you can include in your layout's XML file. The layout file for the **MainActivity** then becomes:

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
        xmlns:android="http://schemas.android.com/apk/res/android"
        android:orientation="horizontal"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:baselineAligned="false">

    <android.support.v4.view.ViewPager
            android:id="@+id/view_pager"
            android:layout_width="match_parent"
            android:layout_height="match_parent"/>

</LinearLayout>
```

> Notice that the **ViewPager** uses a `android.support.v4.view.` namespace prefix, indicating this is not a standard view, but can be found in the `android.support.v4.view` package.

Our **MainActivity** can then look something like this:

```java
public class MainActivity extends FragmentActivity {

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mViewPager = (ViewPager) findViewById(R.id.view_pager);
		(...)
```

The **ViewPager** needs an implementation of **PagerAdapter** as a data-view binder. A common approach is to create an inner class which extends **PagerAdapter**, or the **FragmentPagerAdapter** in our case.

```java
    public class AnimalPagerAdapter extends FragmentPagerAdapter {

        private final List<Animal> mAnimals = new ArrayList<Animal>();

        private void createData() {
            mAnimals.add(new Animal("Bear", "Mammal", R.drawable.bear_thumb, R.drawable.bear, R.raw.bear, "http://a-z-animals.com/animals/bear/"));
            mAnimals.add(new Animal("Cat", "Mammal", R.drawable.cat_thumb, R.drawable.cat, R.raw.cat, "http://a-z-animals.com/animals/cat/"));
            mAnimals.add(new Animal("Chicken", "Bird", R.drawable.chicken_thumb, R.drawable.chicken, R.raw.chicken, "http://a-z-animals.com/animals/chicken/"));
			(...)
        }

        public AnimalPagerAdapter(FragmentManager fm) {
            super(fm);
            createData();
        }

    }
```

The **FragmentPagerAdapter** is an abstract class which asks us to implement one method: `public Fragment getItem(int position)`. 

## Exercise 05.01
Simply return a new **AnimalFragment** in the `public Fragment getItem(int position)` method.
```java
    @Override
    public Fragment getItem(int position) {
        return null; // TODO Exercise 05.01 - Return a new AnimalFragment object for the given position
    }
```

## Exercise 05.02
The **PagerAdapater** itself is an abstract class as well, which in turn asks us to implement the `getCount()` method we saw in [lesson 4](../lesson04).
```java
    @Override
    public int getCount() {
        return 0; // TODO Exercise 05.02 - Return the amount of animals in our data set.
    }
```
##Exercise 05.03
Revisit the `onCreate` method in the **MainActivity** and set the adapter of the `mViewPager` object to a newly created **AnimalPagerAdapter**.

**Note:** A **FragmentPagerAdapter** requires a **FragmentManager** instance to add its fragment to the user interface. You should use `getSupportFragmentManager()` as the argument.

Okay, you should have implemented enough to see the first implementation of the animal image viewer in practice. Take your project for a spin to see how it works.

## Playing an animal sound
You might have noticed that the **Animal** data object holds a new field, `soundResource`. This field is pointing to a so callled _raw_ resource.

> A **raw** resource is basically any binary resource you want to add to your package and use in your app. 

In our case we've included ogg vorbis sound bites for every animal in the `mAnimals` data array in the **AnimalPagerAdapter** class.

##Exercise
* Open your **AnimalFragment** class and add a new integer field called `soundResource`. This looks a lot like the already defined `imageResource` field so walk through the class definition and add all the necessary code to correctly save and restore the value of this new `soundResource` field.

It is good practice to let your fragment know as little as possible about its parent activity. Sometimes your fragments contains a list and when the user clicks on an item in this list it is best to let the containing activity handle the list click. In our case, when a user clicks the image we want to let our **MainActivity** handle this event. One way to do this is define a **Contract** interface in your fragment.

```java
    public interface Contract {
        public void playSound (int soundResource);
    }
```

Then in the `onCreateView` you can add the following code, which basically asks the fragment's activity to handle the click by passing the correct sound resource identifier.

```java
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Contract) getActivity()).playSound(soundResource);
            }
        });
```

In the `onClick` method we _cast_ the parent activity to our `Contract` definition, so our **MainActivity** must implement this interface:

```java
public class MainActivity extends FragmentActivity implements AnimalFragment.Contract
```

If all's well you'll see a red curly line appear, once you add the implements statement. Simply click Alt-Enter to quick fix what's wrong, i.e. implement the missing method.

To make a long story short create a new **MediaPlayer** field with name `mp` in your **MainAcitivity**. With an instance of **MediaPlayer** you can play sounds in Android. Implement the `playSound` method with the following code.

```java
    @Override
    public void playSound(int soundResource) {
        if (mp != null) { // When we've previously created a MediaPlayer object
            mp.release(); // Stop playing the previous sound
        }
        mp = MediaPlayer.create(this, soundResource); // Create a new MediaPlayer object for the given sound resource
        mp.start(); // Start playback
    }
```

> A more convenient approach is to use Jake Wharton's ContractFragment (see [this Gist](https://gist.github.com/JakeWharton/2621173)) which takes care of all the casting and extend your fragments from that class.

That's it! Take your project for a spin!

## Extra exercises
* When you click on an image that animal sound will be played. When it's long and you move to the next page the other animal's sound is still playing, which is kind of confusing. Add an **OnPageChangeListener** to the `mViewPager` instance in **MainActivity** and override the `public void onPageSelected(int position)` method to stop playing the currently playing sound.
* When you click on an image and hear a sound press the back or the home button. Do you still hear a sound? Can you explain what happens? Which activity life cycle method can you override to stop the sound from playing?

## Conclusion
The **ViewPager** is a pretty standard view which you will use frequently in your Android apps. Fragments allow you to cut up your UI in smaller portions and with their modularity force you to chop up your app architecture as well. Fragment should know very little to nothing about their parent activities. Any user events happening inside the fragment should be propagated up to its parent activity.