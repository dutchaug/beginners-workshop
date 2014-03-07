#Android Cheat Sheet

## General

### _Dips_ (dp) and _sips_ (sp)
You can define view widths and hights and font sizes using **px**, **dp** or **sp**.

**px**
_Pixels_ Corresponds to actual pixels on the screen.

**dp** or **dip**
_Density-independent Pixels_ An abstract unit that is based on the physical density of the screen. These units are relative to a 160 dpi screen, so one dp is one pixel on a 160 dpi screen. The ratio of dp-to-pixel will change with the screen density, but not necessarily in direct proportion. Note: The compiler accepts both "dip" and "dp", though "dp" is more consistent with "sp".

**sp** or **sip**
_Scale-independent Pixels_ This is like the dp unit, but it is also scaled by the user's font size preference. It is recommend you use this unit when specifying font sizes, so they will be adjusted for both the screen density and user's preference.

> **Tip**: Try to never use anything but sp or dp unless you absolutely have to. Using sp and dp will make your Android applications compatible with multiple screen densities and resolutions.

You can resize your graphical resources with the following ratio table:

| mdpi | hdpi | xhdpi | xxhdpi |
| :--: | :--: | :---: | :----: |
| 2    | 3    | 4     | 6      |

### Context
`Context` is an interface to global information about an application environment. This is an abstract class whose implementation is provided by the Android system. It allows access to application-specific resources and classes, as well as up-calls for application-level operations such as launching activities, broadcasting and receiving intents, etc. Both the `Application` class and the `Activity` class implement the `Context` interface. The `Application` instance is tied to the lifecycle of the application, while the `Activity` instance is tied to the lifecycle of an Activity. Thus, they have access to different information about the application environment. You normally use the `Activity` context for view-related actions and the `Application` context generally should only be used if you need a context whose lifecycle is separate from the current context, that is tied to the lifetime of the process rather than the current component.

[More info](http://developer.android.com/reference/android/content/Context.html)

## Android Studio
### Project Structure
When you create a new project in Android Studio almost all your project files are inside the `src` directory, including resources and the manifest file. For the most part, you should need to modify only the files under the `src` directory. More information about the Gradle project structure is available in the [Gradle Plugin User Guide](http://tools.android.com/tech-docs/new-build-system/user-guide).

### Keyboard shortcuts

Keymap for Windows/Linux [PDF](http://www.jetbrains.com/idea/docs/IntelliJIDEA_ReferenceCard.pdf)

Keymap for Mac OS X [PDF](http://www.jetbrains.com/idea/docs/IntelliJIDEA_ReferenceCard_Mac.pdf)

### Import projects in Android Studio
In Android Studio, chose **File > Import Project** and select the folder of the sample, exercise or solution project.
Android Studio may ask you to choose the type of project you are importing. If this is the case, make sure to choose **Import project from external model** and select the **Gradle** option.