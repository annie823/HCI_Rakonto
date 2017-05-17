package com.hci.www.rakonto;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

// referred to:
// http://www.viralandroid.com/2015/11/simple-android-listview-example.html
// http://androidexample.com/Create_A_Simple_Listview_-_Android_Example/index.php?view=article_discription&aid=65&aaid=90#

public class MoreFragment extends Fragment {

    protected View rootView;
    protected ListView menu;
    protected String[] options;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_more, container, false);

        options = new String[] {
                getString(R.string.menu_account),
                getString(R.string.menu_preferences),
                getString(R.string.menu_accessibility)
        };

        // android.R.layout.simple_list_item_1, android.R.id.text1

        menu = (ListView) rootView.findViewById(R.id.menu);
        menu.setAdapter(new ArrayAdapter<String>(rootView.getContext(), R.layout.textview_secondary_alt, options));
        menu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String val = (String) menu.getItemAtPosition(position);
                Toast.makeText(rootView.getContext(), "Position :"+position+"  ListItem : " +val , Toast.LENGTH_LONG)
                        .show();
            }
        });

        return rootView;
    }

    protected void DidClickMenu(String s) {

    }
}