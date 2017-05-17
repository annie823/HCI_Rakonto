package com.hci.www.rakonto;

import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class VocabularyFragment extends Fragment{
    public static ArrayList<ListviewVocab> currentRecord;
    public static ListviewVocabAdapter vocabAdapter;
//    static final String[] FACULTY = new String[] { "Chris Bailey-Kellogg",
//            "Devin Balkcom", "Andrew Campbell", "Michael Casey",
//            "Amit Chakrabarti", "Thomas H. Cormen ",
//            "Robert L. (Scot) Drysdale, III", "Hany Farid", "Lisa Fleischer",
//            "Gevorg Grigoryan", "Prasad Jayanti", "David Kotz", "Lorie Loeb",
//            "Fabio Pellacini", "Daniel Rockmore", "Sean Smith",
//            "Lorenzo Torresani", "Peter Winkler","Emily Whiting","Xia Zhou" };

//
//    @Override
//    public void onActivityCreated(Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        //XD: you do not need to use your own listview_layout.xml. You can use Android's built-in android.R.layout.simple_list_item_1
////      ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, FACULTY);
//
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), R.layout.vocab_list, FACULTY);
//        setListAdapter(arrayAdapter);
//
//    }

//    @Override
//    public void onListItemClick(ListView l, View view, int position, long id){
//        Log.d("xd", id + "");
//    }
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        currentRecord = GetlistVocab();

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_vocabulary, container, false);
        vocabAdapter = new ListviewVocabAdapter(getActivity(), currentRecord);
        ListView listView = (ListView) v.findViewById(R.id.vocab_list);
        listView.setAdapter(vocabAdapter);
        return v;
//        ArrayAdapter<ListviewVocab> = new ArrayAdapter<＝>()

//        ListView lv = (ListView)v.findViewById();
//        lv.setAdapter(new ListviewVocabAdapter(getActivity(),listvocab));

    }

    public class ListviewVocab{
        public String Vocab = "Null";
        public String Pronounce = "Null";
        public String Mean = "Null";
        public String Examplestentence = "Null";

        public void SetVocab(String vo){Vocab = vo;}
        public void SetPronounce(String pro){Pronounce = pro;}
        public void SetMean(String mean){Mean = mean;}
        public void SetExample(String ex){Examplestentence = ex;}


        public String GetVocab(){return Vocab;}
        public String GetPronounce(){return Pronounce;}
        public String GetMean(){return Mean;}
        public String GetExample(){return Examplestentence;}

    }
//
    public ArrayList<ListviewVocab> GetlistVocab(){
        ArrayList<ListviewVocab> vocablist = new ArrayList<ListviewVocab>();

        ListviewVocab voca1 = new ListviewVocab();

        voca1.SetVocab("Good");
        voca1.SetPronounce("/gud/");
        voca1.SetMean("Great");
        voca1.SetExample("Good Sentence.");

        vocablist.add(voca1);

        voca1 = new ListviewVocab();
        voca1.SetVocab("Test1");
        voca1.SetPronounce("/test1/");
        voca1.SetMean("Test");
        voca1.SetExample("Test test test.");

        vocablist.add(voca1);

        return vocablist;

    }
}
