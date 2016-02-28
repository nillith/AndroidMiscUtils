package com.nillith.android.app.miscutilsdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nillith.android.common.MiscUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MiscUtils.runOnBackgroundThread(new Runnable() {
            @Override
            public void run() {
                MiscUtils.showToast("Hello World!");
            }
        }, 1500);
    }
}
