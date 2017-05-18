package com.hci.www.rakonto;

import android.app.Fragment;
import android.app.FragmentManager;

import android.support.v13.app.FragmentPagerAdapter;

import java.util.ArrayList;


/**
 * Created by dengxi on 5/17/17.
 */
public class ActionTabsViewPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragments;

    public static final int SYN = 0;
    public static final int REV = 1;
    public static final int DET = 2;
    public static final String UI_TAB_START = "Synopsis";
    public static final String UI_TAB_HISTORY = "Review";
    public static final String UI_TAB_SETTING = "Details";


    public ActionTabsViewPagerAdapter(FragmentManager fm, ArrayList<Fragment> frs){
        super(fm);
        this.fragments = frs;
    }

    public Fragment getItem(int pos){
        return fragments.get(pos);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    public  CharSequence getPageTitle(int position){
        switch (position){
            case SYN:
                return UI_TAB_START;
            case REV:
                return UI_TAB_HISTORY;
            case DET:
                return UI_TAB_SETTING;
            default:
                break;
        }
        return null;
    }
}
