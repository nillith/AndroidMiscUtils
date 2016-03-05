package com.nillith.android.common;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.LayoutRes;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Created by Nil on 2016/2/28.
 */
public class MiscUtils {
    private MiscUtils() {
    }

    public static final Handler MAIN_HANDLER = new Handler();
    public static final ScheduledExecutorService SCHEDULED_EXECUTOR =
            Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors());

    private static Context applicationContext;
    private static final Thread UI_THREAD = Thread.currentThread();


    @MainThread
    public static void init(Context applicationContext) {
        MiscUtils.applicationContext = applicationContext;
    }

    public static Context getApplicationContext() {
        if (null == applicationContext) {
            throw new IllegalStateException("MiscUtils not initialized! Add MiscUtils.init(getApplicationContext()); in your Application's onCreate callback.");
        }
        return applicationContext;
    }

    public static boolean isUiThread() {
        return isUiThread(Thread.currentThread());
    }

    public static boolean isUiThread(Thread thread) {
        return UI_THREAD == thread;
    }

    public static void runOnUiThread(@NonNull Runnable runnable) {
        if (isUiThread()) {
            runnable.run();
        } else {
            MAIN_HANDLER.post(runnable);
        }
    }


    public static void runOnUiThread(@NonNull Runnable runnable, long delayMillis) {
        MAIN_HANDLER.postDelayed(runnable, delayMillis);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static void runSeriallyOnBackgroundThread(@NonNull Runnable runnable) {
        AsyncTask.SERIAL_EXECUTOR.execute(runnable);
    }

    public static void runOnBackgroundThread(@NonNull Runnable runnable) {
        SCHEDULED_EXECUTOR.execute(runnable);
    }

    public static ScheduledFuture<?> runOnBackgroundThread(@NonNull Runnable runnable, long delayMillis) {
        return SCHEDULED_EXECUTOR.schedule(runnable, delayMillis, TimeUnit.MILLISECONDS);
    }

    public static void showToast(final CharSequence message) {
        showToast(message, Toast.LENGTH_SHORT);
    }

    public static void showToast(@StringRes final int resId) {
        showToast(resId, Toast.LENGTH_SHORT);
    }

    public static void showToast(final CharSequence message, final int duration) {
        runOnUiThread(new Runnable() {
            public void run() {
                Toast.makeText(MiscUtils.applicationContext, message, duration).show();
            }
        });
    }

    public static void showToast(@StringRes final int resId, final int duration) {
        runOnUiThread(new Runnable() {
            public void run() {
                Toast.makeText(MiscUtils.applicationContext, resId, duration).show();
            }
        });
    }

    public static View inflateLayout(View view, @LayoutRes int resId) {
        return LayoutInflater.from(view.getContext()).inflate(resId, view instanceof ViewGroup ? (ViewGroup) view : null, false);
    }

    public static View inflateLayout(Activity activity, @LayoutRes int resId) {
        return LayoutInflater.from(activity).inflate(resId, (ViewGroup) activity.getWindow().getDecorView(), false);
    }

    public static View inflateLayout(Window window, @LayoutRes int resId) {
        return LayoutInflater.from(window.getContext()).inflate(resId, (ViewGroup) window.getDecorView(), false);
    }

    public static View inflateLayout(Dialog dialog, @LayoutRes int resId) {
        return inflateLayout(dialog.getWindow(), resId);
    }

    public static View inflateLayout(@LayoutRes int resId) {
        return inflateLayout(getApplicationContext(), resId);
    }

    public static View inflateLayout(Context context, @LayoutRes int resId) {
        return LayoutInflater.from(context).inflate(resId, new FrameLayout(context), false);
    }

    public static View attachLayout(ViewGroup viewGroup, @LayoutRes int resId) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(resId, viewGroup, true);
    }
}
