package com.hci.www.rakonto;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v13.app.FragmentPagerAdapter;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.inputmethod.InputMethodManager;

import java.util.ArrayList;


public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragments;
    Drawable myDrawable;
    Context context;
    String title;

    public MyFragmentPagerAdapter (FragmentManager fm, ArrayList<Fragment> fragments, Context _context) {
        super(fm);
        this.fragments = fragments;
        context = _context;
    }

    @Override
    public Fragment getItem(int pos) {
        return fragments.get(pos);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    // set up the title for each tab
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                myDrawable = context.getResources().getDrawable(R.drawable.discovery);
                title = "Discovery";
                break;
            case 1:
                myDrawable = context.getResources().getDrawable(R.drawable.vocabulary);
                title = "Vocab";
                break;
            case 2:
                myDrawable = context.getResources().getDrawable(R.drawable.bookshelf);
                title = "Bookshelf";
                break;
            case 3:
                myDrawable = context.getResources().getDrawable(R.drawable.search);
                title = "Search";
                break;
            case 4:
                myDrawable = context.getResources().getDrawable(R.drawable.more);
                title = "More";
                break;
            default:
                break;
        }
        // set up the icon for each tab
        myDrawable.setBounds(0, 0, 80, 80);
        myDrawable.setColorFilter(Color.WHITE, PorterDuff.Mode.MULTIPLY);
        SpannableString sb = new SpannableString(" \n" + title);
        ImageSpan imageSpan = new ImageSpan(myDrawable, ImageSpan.ALIGN_BOTTOM);
        sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return sb;
    }
}
