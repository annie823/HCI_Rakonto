package com.hci.www.rakonto;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class CoverFlowAdapter extends BaseAdapter {

    private ArrayList<String> mData = new ArrayList<>(0);
    private Context mContext;

    public CoverFlowAdapter(Context context) {
        mContext = context;
    }

    public void setData(ArrayList<String> data) {
        mData = data;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int pos) {
        return mData.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View rowView = convertView;

        if (rowView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.item_coverflow, null);

            ViewHolder viewHolder = new ViewHolder();
            viewHolder.text = (TextView) rowView.findViewById(R.id.label);
            viewHolder.image = (ImageView) rowView.findViewById(R.id.image);
            rowView.setTag(viewHolder);
        }

        ViewHolder holder = (ViewHolder) rowView.getTag();

        holder.image.setImageResource(R.drawable.bookcover2);


        Random r = new Random();
        int rand = r.nextInt(4);
        switch (rand) {
            case 0:
                holder.image.setImageResource(R.drawable.bookcover1);
                break;
            case 1:
                holder.image.setImageResource(R.drawable.bookcover2);
                break;
            case 2:
                holder.image.setImageResource(R.drawable.bookcover3);
                break;
            case 3:
                holder.image.setImageResource(R.drawable.bookcover4);
                break;
            case 4:
                holder.image.setImageResource(R.drawable.bookcover5);
                break;
            default:
                holder.image.setImageResource(R.drawable.bookcover1);
                break;
        }




        holder.text.setText("Book " + position);

        return rowView;
    }


    static class ViewHolder {
        public TextView text;
        public ImageView image;
    }
}