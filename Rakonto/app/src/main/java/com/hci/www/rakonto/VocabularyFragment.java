package com.hci.www.rakonto;

import android.app.Fragment;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class VocabularyFragment extends Fragment implements ListView.OnItemClickListener{
    public static ArrayList<ListviewVocab> currentRecord;
    public static ListviewVocabAdapter vocabAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        currentRecord = GetlistVocab();

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.fragment_vocabulary, container, false);
        vocabAdapter = new ListviewVocabAdapter(getActivity(), currentRecord);
        ListView listView = (ListView) v.findViewById(R.id.vocab_list);
        listView.setAdapter(vocabAdapter);
        listView.setOnItemClickListener(this);
        return v;

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

        voca1.SetVocab("Word1");
        voca1.SetPronounce("/phonetic/");
        voca1.SetMean("The meaning of this word");
        voca1.SetExample("Eample sentence of this word.");

        vocablist.add(voca1);

        voca1 = new ListviewVocab();
        voca1.SetVocab("Rakonto");
        voca1.SetPronounce("/ra:kunto/");
        voca1.SetMean("Story and tales");
        voca1.SetExample("Malfelica Rakonto.");

        vocablist.add(voca1);

        return vocablist;

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent = new Intent(getActivity().getApplication(), VocabularyActivity.class);
        startActivity(intent);

    }
}
