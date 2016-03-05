package com.nillith.android.common.support.widget;

import android.support.annotation.CallSuper;
import android.support.v4.app.DialogFragment;
import android.view.WindowManager.LayoutParams;

/**
 * Created by Nil on 2016/3/5.
 */
public abstract class MatchParentDialog extends DialogFragment {
    @Override
    @CallSuper
    public void onStart() {
        super.onStart();
        getDialog().getWindow().setLayout(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
    }
}
