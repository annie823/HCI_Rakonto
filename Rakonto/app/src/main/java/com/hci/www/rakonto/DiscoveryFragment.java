package com.hci.www.rakonto;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.HorizontalScrollView;
import android.widget.Toast;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import java.util.ArrayList;
import android.widget.ImageButton;

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

    private static String[] GENRES = {
            "Science Fiction",
            "Romance",
            "Drama",
            "Mystery",
            "Travel"
    };

    private String[] languages;

    public TextView[] t_titles;
    public TextView[] t_languages;
    public TextView[] t_authors;
    public static String[] new_targets = {"Beginner ", "Intermediate ", "Advanced ", "Beginner "};
    public static String[] all_lang = {"Beginner Russian", "Intermediate French", "Advanced Hebrew", "Beginner Korean"};

    private FeatureCoverFlow mCoverFlow;
    private CoverFlowAdapter mAdapter;
    private ArrayList<String> mData;

    Menu mMenu;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_discovery, container, false);

        languages = all_lang.clone();

        int[] coverflow_ids = new int[] {R.id.coverflow, R.id.coverflow_bestseller, R.id.coverflow_you};
        t_titles = new TextView[] {
                (TextView) rootView.findViewById(R.id.featured_title),
                (TextView) rootView.findViewById(R.id.bestseller_title),
                (TextView) rootView.findViewById(R.id.you_title),
        };

        t_authors = new TextView[] {
                (TextView) rootView.findViewById(R.id.featured_author),
                (TextView) rootView.findViewById(R.id.bestseller_author),
                (TextView) rootView.findViewById(R.id.you_author),
        };

        t_languages = new TextView[] {
                (TextView) rootView.findViewById(R.id.featured_language),
                (TextView) rootView.findViewById(R.id.bestseller_language),
                (TextView) rootView.findViewById(R.id.you_language),
        };


        for (TextView t : t_titles) {
            t.setText(BOOK_TITLES[0]);
        }
        for (TextView t : t_authors) {
            t.setText(AUTHORS[0]);
        }
        for (TextView t : t_languages) {
            t.setText(languages[0]);
        }

        for (int i = 0; i < 3; i++) {

            mData = new ArrayList<>();
            mData.add("book 1");
            mData.add("book 2");
            mData.add("book 3");
            mData.add("book 4");

            mAdapter = new CoverFlowAdapter(getActivity().getApplicationContext());
            mAdapter.setData(mData);
            mCoverFlow = (FeatureCoverFlow) rootView.findViewById(coverflow_ids[i]);
            mCoverFlow.setAdapter(mAdapter);

            mCoverFlow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                    Toast.makeText(getActivity(),
//                            "to book " + position + " click", Toast.LENGTH_SHORT).show();
                    toBookClick(view);
                }
            });

            mCoverFlow.setOnScrollPositionListener(NewScrollListener(i));
        }

        // genres
        ImageButton ib = (ImageButton) rootView.findViewById(R.id.genre_0);
        ib.setOnClickListener(NewGenreClickListener(0, this));
        ib = (ImageButton) rootView.findViewById(R.id.genre_1);
        ib.setOnClickListener(NewGenreClickListener(1, this));
        ib = (ImageButton) rootView.findViewById(R.id.genre_2);
        ib.setOnClickListener(NewGenreClickListener(2, this));
        ib = (ImageButton) rootView.findViewById(R.id.genre_3);
        ib.setOnClickListener(NewGenreClickListener(3, this));
        ib = (ImageButton) rootView.findViewById(R.id.genre_4);
        ib.setOnClickListener(NewGenreClickListener(4, this));

        return rootView;
    }



    public View.OnClickListener NewGenreClickListener(final int index, final DiscoveryFragment df) {
        return new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), GENRES[index], Toast.LENGTH_SHORT).show();
                GenreFragment newFragment = new GenreFragment();
                newFragment.languages = df.languages;
                newFragment.genre = GENRES[index];
                newFragment.mMenu = df.mMenu;
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_discovery, newFragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.addToBackStack(null);
                ft.commit();

            }
        };
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
        if (!lang.contains("Language")) {
//            Toast.makeText(getActivity(), lang, Toast.LENGTH_SHORT).show();
            for (int i = 0; i < languages.length; i++) {
                languages[i] = new_targets[i] + lang;
            }
        } else {
//            Toast.makeText(getActivity(), "All languages are life", Toast.LENGTH_SHORT).show();
            for (int i = 0; i < languages.length; i++) {
                languages[i] = all_lang[i];
            }
        }
        for (int i = 0; i < t_languages.length; i++) {
            t_languages[i].setText(languages[0]);
        }
        return super.onOptionsItemSelected(item);
    }

    protected FeatureCoverFlow.OnScrollPositionListener NewScrollListener (final int index) {
        return new FeatureCoverFlow.OnScrollPositionListener() {

            @Override
            public void onScrolling() {
                t_titles[index].setText("...");
                t_authors[index].setText("");
                t_languages[index].setText("");
            }
            @Override
            public void onScrolledToPosition(int position) {
                t_titles[index].setText(BOOK_TITLES[position]);
                t_authors[index].setText(AUTHORS[position]);
                t_languages[index].setText(languages[position]);
            }};
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
