package com.tangcco.application22.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by gdd on 2016/12/15.
 */
public class MyViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> mData;

    public void setData(List<Fragment> mData) {
        this.mData = mData;
    }

    public MyViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (mData != null)
            return mData.get(position);
        return null;
    }

    @Override
    public int getCount() {
        if (mData != null)
            return mData.size();
        return 0;
    }
}
