package com.hci.www.rakonto;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class BookFragment extends Fragment implements  ViewPager.OnPageChangeListener{
    View rootView;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ArrayList<Fragment> fragments;
    private ActionTabsViewPagerAdapter myViewPageAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_book, container, false);

        Button btnToRead = (Button) rootView.findViewById(R.id.toRead);
        btnToRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toReadClick();
            }
        });

        Button btnDownload = (Button) rootView.findViewById(R.id.toDownload);
        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toDownloadClick();
            }
        });

        FragmentManager fm = getFragmentManager();
        fm.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                onBackPressed();
            }
        });

        tabLayout = (TabLayout) rootView.findViewById(R.id.subtab);
        viewPager = (ViewPager) rootView.findViewById(R.id.subviewpager);

        fragments = new ArrayList<Fragment>();
        fragments.add(new SynopsisChildFragment());
        fragments.add(new ReviewListChildFragment());
        fragments.add(new SynopsisChildFragment());

        myViewPageAdapter = new ActionTabsViewPagerAdapter(getChildFragmentManager(),fragments);
        viewPager.setAdapter(myViewPageAdapter);

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);


        return rootView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
    }

    public void toReadClick() {
        Intent intent;
        intent = new Intent(getActivity().getApplicationContext(), ReadActivity.class);
        startActivity(intent);
    }

    public void toDownloadClick(){
        Toast.makeText(getActivity(),
                "Downloading" , Toast.LENGTH_SHORT).show();
    }



    @Override
    public void onResume() {
        super.onResume();
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        ActionBar actionBar = activity.getSupportActionBar();
        //actionBar.setTitle("Book Detail Page");
    }


    @Override
    public void onStop() {

        super.onStop();
    }


    public void onBackPressed() {
//        BookshelfFragment newFragment = new BookshelfFragment();
//        FragmentTransaction ft = getFragmentManager().beginTransaction();
//        ft.replace(R.id.fragment_book, newFragment);
//        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
//        ft.addToBackStack(null);
//        ft.commit();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
