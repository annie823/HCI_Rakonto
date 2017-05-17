package com.hci.www.rakonto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class CustomAdapter extends ArrayAdapter<String> implements View.OnClickListener{

    private ArrayList<String> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView bookTitle;
        TextView bookDescription;
        ImageView book_cover;
        ImageView book_progress;
    }
    public CustomAdapter(ArrayList<String> data, Context context) {
        super(context, R.layout.row_book_itme, data);
        this.dataSet = data;
        this.mContext=context;

    }
    @Override
    public void onClick(View v) {
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String dataModel = getItem(position);
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_book_itme, parent, false);
            viewHolder.book_cover = (ImageView) convertView.findViewById(R.id.book_cover);
            viewHolder.bookTitle = (TextView) convertView.findViewById(R.id.book_title);
            viewHolder.bookDescription = (TextView) convertView.findViewById(R.id.book_description);
            viewHolder.book_progress = (ImageView) convertView.findViewById(R.id.book_progress);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        lastPosition = position;
        viewHolder.bookTitle.setText("Book " + position);
        viewHolder.bookDescription.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry...");

        Random r = new Random();
        int rand = r.nextInt(5);
        switch (rand) {
            case 0:
                viewHolder.book_progress.setImageResource(R.drawable.progress0);
                break;
            case 1:
                viewHolder.book_progress.setImageResource(R.drawable.progress25);
                break;
            case 2:
                viewHolder.book_progress.setImageResource(R.drawable.progress50);
                break;
            case 3:
                viewHolder.book_progress.setImageResource(R.drawable.progress75);
                break;
            case 4:
                viewHolder.book_progress.setImageResource(R.drawable.progress100);
                break;
            default:
                viewHolder.book_progress.setImageResource(R.drawable.progress0);
                break;
        }

        return convertView;
    }


}