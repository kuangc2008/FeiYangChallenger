package com.qihoo.feiyang.adapter;

/**
 * Created by caoyu-xy on 2015/7/23.
 */
import java.util.ArrayList;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class GameFragmentPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragmentsList;
    public GameFragmentPagerAdapter(FragmentManager fm) {super(fm);}
    public GameFragmentPagerAdapter(FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        this.fragmentsList = fragments;
    }


    @Override
    public Fragment getItem(int index) {
        return fragmentsList.get(index);
    }

    @Override
    public int getCount() {
        return fragmentsList.size();
    }

}