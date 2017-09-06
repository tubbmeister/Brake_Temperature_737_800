package com.example.richard.volmet_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Madrid extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_madrid);

        TextView textView1 = (TextView) findViewById(R.id.Bord_freq);
        textView1.setText(R.string.Bordeaux_freq);
        TextView textView = (TextView) findViewById(R.id.textView5);
        textView.setText(R.string.Bordeaux);
    }
}
