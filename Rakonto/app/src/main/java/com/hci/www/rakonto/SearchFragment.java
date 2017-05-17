package com.hci.www.rakonto;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


public class SearchFragment extends Fragment {

    protected View rootView;
    protected EditText searchbar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_search, container, false);
        searchbar = (EditText) rootView.findViewById(R.id.search_bar);
        // TODO: something when you hit search bar? at the very least make background image disappear?
        return rootView;
    }


}