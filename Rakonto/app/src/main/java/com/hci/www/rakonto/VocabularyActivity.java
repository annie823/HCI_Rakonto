package com.hci.www.rakonto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class VocabularyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("log","started");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabulary);
    }
}
