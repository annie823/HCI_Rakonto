package com.hci.www.rakonto;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private MyFragmentPagerAdapter myFragmentPagerAdapter;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private ArrayList<Fragment> fragments;

    private DiscoveryFragment discoveryFragment;
    private VocabularyFragment vocabularyFragment;
    private BookshelfFragment bookshelfFragment;
    private SearchFragment searchFragment;
    private MoreFragment moreFragment;
    private String[] actionBarTitle = {"Discovery", "Vocabulary", "Bookshelf", "Search", "Rakonto"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pageSetup();
    }


    // set up all fragments for the view pager
    public void pageSetup(){
        discoveryFragment = new DiscoveryFragment();
        vocabularyFragment = new VocabularyFragment();
        bookshelfFragment = new BookshelfFragment();
        searchFragment = new SearchFragment();
        moreFragment = new MoreFragment();

        fragments = new ArrayList<Fragment>();
        fragments.add(discoveryFragment);
        fragments.add(vocabularyFragment);
        fragments.add(bookshelfFragment);
        fragments.add(searchFragment);
        fragments.add(moreFragment);

        myFragmentPagerAdapter = new MyFragmentPagerAdapter(getFragmentManager(), fragments, this);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(myFragmentPagerAdapter);
        viewPager.setOffscreenPageLimit(5);
        tabLayout = (TabLayout) findViewById(R.id.tab);
        tabLayout.setupWithViewPager(viewPager);

        int i = viewPager.getCurrentItem();
        getSupportActionBar().setTitle(actionBarTitle[i]);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int pos) {
                getSupportActionBar().setTitle(actionBarTitle[pos]);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });


    }


}
