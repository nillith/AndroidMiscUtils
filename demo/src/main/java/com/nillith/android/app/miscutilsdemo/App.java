package com.nillith.android.app.miscutilsdemo;

import android.app.Application;

import com.nillith.android.common.MiscUtils;

/**
 * Created by Nil on 2016/2/28.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        MiscUtils.init(getApplicationContext());
    }
}
