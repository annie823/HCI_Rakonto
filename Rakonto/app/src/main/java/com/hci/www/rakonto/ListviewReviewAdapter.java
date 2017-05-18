package com.hci.www.rakonto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by dengxi on 5/17/17.
 */

public class ListviewReviewAdapter extends ArrayAdapter<ReviewListChildFragment.ReviewsItem> {
        private final Context context;
        private final ArrayList<ReviewListChildFragment.ReviewsItem> item;

        public ListviewReviewAdapter(Context context, ArrayList<ReviewListChildFragment.ReviewsItem> items) {
            super(context, R.layout.layout_review, items);

            this.context = context;
            this.item = items;
        }

        @Override
        public View getView(int position, View converView, ViewGroup parent){
            LayoutInflater inflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            //get view
            View row = inflater.inflate(R.layout.layout_review, parent, false);

            TextView row_first = (TextView) row.findViewById(R.id.rev_title);
            TextView row_third = (TextView) row.findViewById(R.id.rev_detail);

            String line1 = item.get(position).Gettitle();

            row_first.setText(line1);
            row_third.setText(item.get(position).Getdetail());

            return row;
        }
}
