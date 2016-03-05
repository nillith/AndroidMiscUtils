package com.nillith.android.app.miscutilsdemo;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;

import com.nillith.android.common.support.widget.MatchParentDialog;

/**
 * Created by Nil on 2016/3/5.
 */
public class MatchParentDemo extends MatchParentDialog {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = new Dialog(getContext());

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_match_parent);
        dialog.getWindow().findViewById(R.id.close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        return dialog;
    }
}
