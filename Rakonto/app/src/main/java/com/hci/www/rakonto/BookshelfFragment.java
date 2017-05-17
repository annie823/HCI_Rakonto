package com.hci.www.rakonto;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class BookshelfFragment extends Fragment {

    ArrayList<String> dataModels;
    ListView listView;
    private static CustomAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_bookshelf, container, false);


        listView = (ListView)rootView.findViewById(R.id.list);
        dataModels= new ArrayList<>();
        dataModels.add("book 1");
        dataModels.add("book 2");
        dataModels.add("book 3");
        dataModels.add("book 4");
        dataModels.add("book 5");
        dataModels.add("book 6");
        dataModels.add("book 7");
        dataModels.add("book 8");
        dataModels.add("book 9");
        dataModels.add("book 10");
        adapter= new CustomAdapter(dataModels, getActivity().getApplicationContext());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(),
                        "to book click", Toast.LENGTH_SHORT).show();
                //toBookClick(view);
            }
        });

        return rootView;
    }

    public void toBookClick(View view) {
        BookFragment newFragment = new BookFragment();
        //Bundle args = new Bundle();
        //args.putInt(BookshelfFragment.ARG_POSITION, position);
        //newFragment.setArguments(args);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_bookshelf, newFragment);
        ft.remove(this);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }

}