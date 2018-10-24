package com.example.administrator.mynoelmedia;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class FragmentAdapter extends FragmentPagerAdapter {
    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position==0) return new ListSongFragment();
        else return new FavoriteFragment();
    }

    @Override
    public int getCount() {
        return 2;
    }
}
