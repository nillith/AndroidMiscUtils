package com.nillith.android.common.widget;

import android.annotation.TargetApi;
import android.app.DialogFragment;
import android.os.Build;
import android.support.annotation.CallSuper;
import android.view.WindowManager.LayoutParams;

/**
 * Created by Nil on 2016/3/5.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public abstract class MatchParentDialog extends DialogFragment {
    @Override
    @CallSuper
    public void onStart() {
        super.onStart();
        getDialog().getWindow().setLayout(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
    }
}
