# Lesson 4<br/>ListViews and Adapters

## What you'll learn in this lesson
* Basic understanding of ListViews and Adapters

## Introduction
One of the most frequently used views in Android apps is the [ListView](http://developer.android.com/guide/topics/ui/layout/listview.html). It's also one of the more complex views and one of the most cumbersome things to work with if you don't play by the rules. We hope to give you a solid introduction to good use of this powerful view.

## Adding a ListView to your layout.
A ListView usually displays a (large) list of things which you can vertically scroll. The _things_ in the list can have a custom view layout themselves. For now we'll simply use one of the standard layouts which you can find in the android runtime library itself. It's the layout with id `android.R.layout.simple_list_item_1`. It's a very simple layout with just one `TextView` with id `@android:id/text1`

> Press `Cmd-Shift-O` on a Mac or `Ctrl-Shift-N` on a Windows/Linux machine to open the **go to file** prompt. Simply type `simple_list_item_1` in the search field. Click on one of the items you see to view this systems layout file's contents.

Okay, we've got a layout, now a list of things. You might retrieve your list from a server, or a database in real world Android applications, but it is good to know that for fixed lists you can easily create string array resources for every language or device specifically, just as any other Android resource.

```xml
<string-array name="animals">
    <item>bear</item>
    <item>cat</item>
    <item>chicken</item>
</string-array>
```

You can reference a string array resource from a [context](../cheatsheet.md#context) using `getResources().getStringArray(R.array.animals)`

## Adapters
An **Adapter** object acts as a _bridge_ or between an **AdapterView** (in our case the **ListView** which extends from **AdapterView**) and the underlying data for that view (our String array). The Adapter provides access to the data items. The Adapter is also responsible for making a **View** for each item in the data set by implementing a `public View getView (int position, View convertView, ViewGroup parent)` method, which our **ListView** conveniently calls whenever it needs to render the next view for item with position **position** in the list.

The **ArrayAdapter** is a simple implementation of the **Adapter** interface, which allows us to bind data in an array to a layout XML file and a **TextView** in that layout.

We've got all the necessary information to construct an **ArrayAddapter** in our example.

```java
public ArrayAdapter (Context context, int resource, T[] objects)
```

Parameters:
**context** The current context.
**resource** The resource ID for a layout file containing a TextView to use when instantiating views.
**objects** The objects to represent in the ListView.

## Exercise 04.01
It's time to put the learned stuff into practice!

1. Import [sample04](sample04) in Android Studio 
1. Click on the TODO Tool View double click on the `TODO Exercise 04.01` item. This opens the `ListViewInLayoutActivity.java` file at the spot where you should enter the code below.
1. Set the content view to the `activity_listview_in_layout.xml` layout file.
1. Bind a local `ListView` object to the `ListView` in the layout with a `findViewById` and the id you can find in the `activity_listview_in_layout.xml` layout file.
1. Create a local variable `String[] entries` which contains the items in the `animals` string resource array (see [arrays.xml](sample04/listviews/src/main/res/values/arrays.xml))
1. Create a new array adapter with layout id `android.R.layout.simple_list_item_1` and assign this adapter to the list view object. (At this time you should be able to see something on screen, so take your project for a spin here and click on the "ListView in layout" item)
1. **Extra** Create a custom list item layout, with at least one `TextView` with id `@android:id/text1`, and assign that to the `ArrayAdapter` constructor.

##Exercise 04.02
1. Import [sample04](sample04) in Android Studio (if you have not done that already in exercise 04.01)
1. Click on the TODO Tool View double click on the `TODO Exercise 04.02` item.
1. Again create a local variable `String[] entries` which contains the items in the `animals` string resource array (see [arrays.xml](sample04/listviews/src/main/res/values/arrays.xml))
1. Create a new array adapter with layout id `android.R.layout.simple_list_item_1` and assign this adapter to the list view via the `getListView()` method. (You should be able to see something on screen, so take your project for a spin here and click on the "ListActivity" item)
1. **Extra** Override the `protected void onListItemClick(ListView l, View v, int position, long id)` method and try to display the animal name via a [Toast](../cheatsheet.md#toast)