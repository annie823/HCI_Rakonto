package com.hci.www.rakonto;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import java.util.ArrayList;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;


public class DiscoveryFragment extends Fragment {

    private static String[] BOOK_TITLES = {
            "The Greatest Book Ever",
            "Secrets In The Night",
            "Moon Made of Cheese",
            "The Fuzzy Bunny"
    };

    private static String[] AUTHORS = {
            "Simon Simon",
            "Nina Nani",
            "Francis Francisco",
            "Sigmund Sigward"
    };

    private String[] languages;

    private FeatureCoverFlow mCoverFlow;
    private CoverFlowAdapter mAdapter;
    private ArrayList<String> mData = new ArrayList<>();
    private TextView mTitle;
    private TextView mAuthor;
    private TextView mLanguage;
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
        mCoverFlow = (FeatureCoverFlow) rootView.findViewById(R.id.coverflow);
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

        // https://github.com/moondroid/CoverFlow README suggestions not working...things aren't getting logged
        mCoverFlow.setOnScrollPositionListener(new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolling() {
                mTitle.setText("...");
                mAuthor.setText("");
                mLanguage.setText("");
            }
            @Override
            public void onScrolledToPosition(int position) {
                mTitle.setText(BOOK_TITLES[position]);
                mAuthor.setText(AUTHORS[position]);
                mLanguage.setText(languages[position]);
            }});


        mTitle = (TextView) rootView.findViewById(R.id.featured_title);
        mTitle.setText(BOOK_TITLES[0]);

        mAuthor = (TextView) rootView.findViewById(R.id.featured_author);
        mAuthor.setText(AUTHORS[0]);

        mLanguage = (TextView) rootView.findViewById(R.id.featured_language);
        languages = new String[] {"Beginner Russian", "Intermediate French", "Advanced Hebrew", "Beginner Korean"};
        mLanguage.setText(languages[0]);

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
