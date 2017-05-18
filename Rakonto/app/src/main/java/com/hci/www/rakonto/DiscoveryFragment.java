package com.hci.www.rakonto;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextSwitcher;
import android.widget.Toast;

import java.util.ArrayList;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;


public class DiscoveryFragment extends Fragment {

    private FeatureCoverFlow mCoverFlow;
    private CoverFlowAdapter mAdapter;
    private ArrayList<String> mData = new ArrayList<>();
    private TextSwitcher mTitle;

    Menu mMenu;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_discovery, container, false);

        mData.add("book 1");
        mData.add("book 2");
        mData.add("book 3");
        mData.add("book 4");

        mAdapter = new CoverFlowAdapter(getActivity().getApplicationContext());
        mAdapter.setData(mData);
        FeatureCoverFlow mCoverFlow = (FeatureCoverFlow) rootView.findViewById(R.id.coverflow);
        mCoverFlow.setAdapter(mAdapter);

        mCoverFlow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //TODO CoverFlow item clicked
                Toast.makeText(getActivity(),
                        "to book " + position + " click", Toast.LENGTH_SHORT).show();
                toBookClick(view);
            }
        });

        mCoverFlow.setOnScrollPositionListener(new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                //TODO CoverFlow stopped to position
            }

            @Override
            public void onScrolling() {
                //TODO CoverFlow began scrolling
            }
        });

        return rootView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        mMenu = menu;
        getActivity().getMenuInflater().inflate(R.menu.menu_main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String lang = item.getTitle().toString();
        mMenu.findItem(R.id.menu_settings).setTitle(lang);
        //Toast.makeText(getActivity(), "language: " + lang, Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }



    public void toBookClick(View view) {
//      listView.setVisibility(View.GONE);
        BookFragment newFragment = new BookFragment();
        //Bundle args = new Bundle();
        //args.putInt(BookshelfFragment.ARG_POSITION, position);
        //newFragment.setArguments(args);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_discovery, newFragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.addToBackStack(null);
        ft.commit();

        //getActivity().setContentView(R.layout.fragment_book);

    }













}
