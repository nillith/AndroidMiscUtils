package com.nillith.android.common.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Nil on 2016/3/5.
 */
public abstract class SimplePagerAdapter extends PagerAdapter {
    @Override
    public abstract int getCount();

    public abstract View onCreateView(ViewGroup container, int position);

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = onCreateView(container, position);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
        onRemoveView(view, position);
    }

    public void onRemoveView(View view, int position) {

    }

}
