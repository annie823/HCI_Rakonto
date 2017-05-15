package com.hci.www.rakonto;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class BookshelfFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_bookshelf, container, false);


        Button btnToBook = (Button) rootView.findViewById(R.id.toBook);
        btnToBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toBookClick();
            }
        });


        return rootView;
    }

    public void toBookClick() {
        Intent intent;
        intent = new Intent(getActivity().getApplicationContext(), BookActivity.class);
        startActivity(intent);
    }

}