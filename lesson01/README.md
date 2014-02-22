# Lesson 01 - Exploring your Android development environment

## What you'll learn in this lesson
* Importing an Android project in Android Studio
* Understand and navigate the basic Android project structure in Android Studio
  * Learn about the AndroidManifest.xml file
  * Know where the java source files are located
  * Understand the basics of resources
* Know the basics about and how to start the Android Tools from Android Studio
  * The Android SDK Manager 
  * The Android Virtual Device (AVD) Manager
  * The Device Debug Monitoring System (DDMS)
  
If you know all about the learning goals for this lesson move on to [lesson 2](../lesson02)

## Android Studio

### Importing an Android project in Android Studio
Android Studio contains a new project wizard which is started by chosing **File > New Project...**. However convenient it also poses a lot of questions, settings and steps which might be a bit too much at this point. For this workshop we would like to teach you how to import an existing Android project so we can keep the project contents consise to what is needed in the sample or exercise. In this lesson we are going to import a very tiny "Hello World" app.

![The File Menu](img/as-file-menu.png)
> The File Menu

![The Quick Start Menu](img/as-quick-start-menu.png)
>The Quick Start Menu

In Android Studio, chose **File > Import Project...** or select the **Import Project...** option from the quick start menu and select the `sample01` folder. 

![Select Gradle Project import](img/as-project-import.png)
>Select Gradle Project import. Android Studio may ask you to choose the type of project you are importing. If this is the case, make sure to choose **Import project from external model** and select the **Gradle** option.

If all's well Android Studio will start to build your project right away.

### The Android Project structure
If you have imported the `sample01` project correctly you will end up with a project structure like this

![Typical Android Gradle project structure](img/project-structure.png)

#### Gradle build files
At the root of the project folder you can see various gradle files.

* A `gradle` directory
* A `build.gradle` file
* A `gradle.properties` file
* A `gradlew` shell script for unix based OS-es
* A `gradlew.bat` batch script for the Windows OS
* A `settings.gradle` file

#### AndroidManfest.xml

#### Java source files

#### Resources
![res folder](img/res-folder.png)
> The Android project resources

##### strings.xml

##### drawables

##### layouts

## Android Tools

### SDK Manager

### AVD Manager

### DDMS

