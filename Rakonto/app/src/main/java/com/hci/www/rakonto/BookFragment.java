package com.hci.www.rakonto;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class BookFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_book, container, false);

        Button btnToRead = (Button) rootView.findViewById(R.id.toRead);
        btnToRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toReadClick();
            }
        });


        return rootView;
    }


    public void toReadClick() {
        Intent intent;
        intent = new Intent(getActivity().getApplicationContext(), ReadActivity.class);
        startActivity(intent);
    }



}
