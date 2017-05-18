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
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;

public class SynopsisChildFragment extends Fragment {
    protected View rootView;
    private static String discription = "The central character in the series is Harry Potter, an English boy who lives with his aunt, uncle, and cousin, and who discovers, at the age of eleven, that he is a wizard, though he lives in the ordinary world of non-magical people known as Muggles.[11] The wizarding world exists parallel to the Muggle world, albeit hidden and in secrecy. His magical ability is inborn and children with such abilities are invited to attend exclusive magic schools that teach the necessary skills to succeed in the wizarding world.[12] Harry becomes a student at Hogwarts School of Witchcraft and Wizardry, a wizarding academy in Scotland and it is here where most of the events in the series take place. As Harry develops through his adolescence, he learns to overcome the problems that face him: magical, social and emotional, including ordinary teenage challenges such as friendships, infatuation, romantic relationships, schoolwork and exams, anxiety, depression, stress, and the greater test of preparing himself for the confrontation, that lies ahead, in wizarding Britain's increasingly-violent second wizarding war.[13]";
    private static String title = "Harry Potter";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_synopsis_child, container, false);
        TextView t = (TextView) rootView.findViewById(R.id.syn_title);
        TextView d = (TextView) rootView.findViewById(R.id.syn_dis);

        t.setText(title);
        d.setText(discription);
        return rootView;
    }


}
