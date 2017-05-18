package com.hci.www.rakonto;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;

public class ReviewListChildFragment extends Fragment {
    protected View rootView;
    private ArrayList<ReviewsItem> currentRecord;
    public static ListviewReviewAdapter revAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_review_child, container, false);
        currentRecord = GetlistReview();

        ListviewReviewAdapter revAdapter = new ListviewReviewAdapter(getActivity(),currentRecord);

        ListView listview = (ListView) rootView.findViewById(R.id.review_list);
        listview.setAdapter(revAdapter);


        return rootView;
    }

    public class ReviewsItem{

        public String title = "Title";
        public String detail = "Detail";

        public void Settitle(String vo){title = vo;}
        public void Setdetail(String pro){detail = pro;}

        public String Gettitle(){return title;}
        public String Getdetail(){return detail;}

    }
    //
    public ArrayList<ReviewsItem> GetlistReview(){
        ArrayList<ReviewsItem> list = new ArrayList<ReviewsItem>();
        ReviewsItem rev = new ReviewsItem();

        rev.Settitle("Annie.tu.dai");
        rev.Setdetail("This book is the greatest book that I ve ever read!");

        list.add(rev);

        rev = new ReviewsItem();

        rev.Settitle("Jaki");
        rev.Setdetail("This is great!");
        list.add(rev);

        rev = new ReviewsItem();

        rev.Settitle("Josh");
        rev.Setdetail("Good!Good!");
        list.add(rev);

        rev = new ReviewsItem();

        rev.Settitle("Xi Deng");
        rev.Setdetail("Parents need to know that this thrill-a-minute story, the first in the Harry Potter series, respects kids' intelligence and motivates them to tackle its greater length and complexity, play imaginative games, and try to solve its logic puzzles!");
        list.add(rev);

        return list;
    }

}
