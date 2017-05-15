package com.hci.www.rakonto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);




        Button btnToRead = (Button) findViewById(R.id.toRead);
        btnToRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toReadClick();
            }
        });



    }


    public void toReadClick() {
        Intent intent;
        intent = new Intent(getApplicationContext(), ReadActivity.class);
        startActivity(intent);
    }



}
