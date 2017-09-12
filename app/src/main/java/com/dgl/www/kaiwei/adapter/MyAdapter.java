package com.dgl.www.kaiwei.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by jh on 2016/3/7.
 */
public class MyAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> list_Fragments;
    private List<String> list_Titles;

    public MyAdapter(FragmentManager fm, List<Fragment> list_Fragments, List<String> list_Titles) {
        super(fm);
        this.list_Fragments = list_Fragments;
        this.list_Titles = list_Titles;
    }

    @Override
    public Fragment getItem(int position) {
        return list_Fragments.get(position);
    }

    @Override
    public int getCount() {
        int rec = 0;
        if (list_Fragments != null && list_Fragments.size() > 0) {
            rec = list_Fragments.size();
        }
        return rec;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list_Titles.get(position);
    }
}