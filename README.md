# AndroidMiscUtils
Android utils for context and thread.

### How to use
###1 Init
Init MiscUtils in you Application class.
```java
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        MiscUtils.init(getApplicationContext()); // Init MiscUtils
    }
}
```

Add the above class to AndroidManifest.xml
```xml
    <application
        android:name=".App"
```

###2 Supported Operations
####2.1 Static Fields
```java
     MiscUtils.MAIN_HANDLER //Handler for main thread
     MiscUtils.SCHEDULED_EXECUTOR
```

####2.2 Static Methods
```java
     MiscUtils.init(Context applicationContext)
     MiscUtils.getApplicationContext()
     MiscUtils.isUiThread()
     MiscUtils.runOnUiThread(Runnable runnable)
     MiscUtils.runOnUiThread(Runnable runnable, long delayMillis)
     MiscUtils.runSeriallyOnBackgroundThread(Runnable runnable)
     MiscUtils.runOnBackgroundThread(Runnable runnable)
     MiscUtils.runOnBackgroundThread(Runnable runnable, long delayMillis)
     MiscUtils.showToast(CharSequence message)
     MiscUtils.showToast(@StringRes int resId)
     MiscUtils.showToast(CharSequence message, int duration)
     MiscUtils.showToast(@StringRes int resId, int duration)
```