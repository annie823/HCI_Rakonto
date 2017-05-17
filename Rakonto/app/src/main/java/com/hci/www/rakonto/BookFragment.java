package com.hci.www.rakonto;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class BookFragment extends Fragment {
    View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_book, container, false);

        Button btnToRead = (Button) rootView.findViewById(R.id.toRead);
        btnToRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toReadClick();
            }
        });

        FragmentManager fm = getFragmentManager();
        fm.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                onBackPressed();
            }
        });

        return rootView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void toReadClick() {
        Intent intent;
        intent = new Intent(getActivity().getApplicationContext(), ReadActivity.class);
        startActivity(intent);
    }

    @Override
    public void onStop() {

        super.onStop();
    }


    public void onBackPressed() {
//        BookshelfFragment newFragment = new BookshelfFragment();
//        FragmentTransaction ft = getFragmentManager().beginTransaction();
//        ft.replace(R.id.fragment_book, newFragment);
//        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
//        ft.addToBackStack(null);
//        ft.commit();
    }

}
