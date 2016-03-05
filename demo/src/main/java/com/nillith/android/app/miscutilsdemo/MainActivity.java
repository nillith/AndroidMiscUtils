package com.nillith.android.app.miscutilsdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

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
        findViewById(R.id.show_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MatchParentDemo().show(getSupportFragmentManager(),null);
            }
        });
    }
}
