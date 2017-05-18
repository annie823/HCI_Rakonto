package com.hci.www.rakonto;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by dengxi on 5/16/17.
 */

public class ListviewVocabAdapter extends ArrayAdapter<VocabularyFragment.ListviewVocab>{
    private final Context context;
    private final ArrayList<VocabularyFragment.ListviewVocab> item;

    public ListviewVocabAdapter(Context context, ArrayList<VocabularyFragment.ListviewVocab> items) {
        super(context, R.layout.layout_vocab, items);

        this.context = context;
        this.item = items;
    }

    @Override
    public View getView(int position, View converView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //get view
        View row = inflater.inflate(R.layout.layout_vocab, parent, false);

        TextView row_first = (TextView) row.findViewById(R.id.Vocabulary);
        TextView row_third = (TextView) row.findViewById(R.id.Meaning);

        String line1 = item.get(position).GetVocab();

        row_first.setText(line1);
        row_third.setText(item.get(position).GetMean());

        return row;
    }

}

