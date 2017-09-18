package com.example.richard.volmet_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Bordeaux extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bordeaux);
        // TextView textView1 = (TextView) findViewById(R.id.Bord_freq);
        //  textView1.setText(R.string.Bordeaux_freq);
        //  TextView textView = (TextView) findViewById(R.id.textView5);
        //  textView.setText(R.string.Bordeaux);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        // String volmet = message().toString();
        TextView textView = (TextView) findViewById(R.id.textView5);
        TextView textView2 = (TextView) findViewById(R.id.Bord_freq);
        TextView textView1 = (TextView) findViewById(R.id.textView5);
        TextView textView3 = (TextView) findViewById(R.id.textView3);


        if (message.equals("Bordeaux"))
             {


            textView1.setText(R.string.Bordeaux);
            textView2.setText(R.string.Bord_freq);

            textView3.setText(message);
            // Capture the layout's TextView and set the string as its text

            //textView.setText(message);

             }
            else if (message.equals("Madrid"))
        {


            textView1.setText(R.string.Madrid);
            textView2.setText(R.string.Madrid_freq);

            textView3.setText(message);
            // Capture the layout's TextView and set the string as its text

            //textView.setText(message);

        }
        else if (message.equals("Lisbon"))
        {


            textView1.setText(R.string.Lisbon);
            textView2.setText(R.string.Lisbon_freq);

            textView3.setText(message);
            // Capture the layout's TextView and set the string as its text

            //textView.setText(message);

        }

        else if (message.equals("Barcelona"))
        {


            textView1.setText(R.string.Barcelona);
            textView2.setText(R.string.Barcelona_freq);

            textView3.setText(message);
            // Capture the layout's TextView and set the string as its text

            //textView.setText(message);

        }
        else if (message.equals("Marseille"))
        {


            textView1.setText(R.string.Marseille);
            textView2.setText(R.string.Marseille_freq);

            textView3.setText(message);
            // Capture the layout's TextView and set the string as its text

            //textView.setText(message);

        }
        else if (message.equals("Paris"))
        {


            textView1.setText(R.string.Paris);
            textView2.setText(R.string.Paris_freq);

            textView3.setText(message);
            // Capture the layout's TextView and set the string as its text

            //textView.setText(message);

        }
            else     {
            textView1.setText("Unknown");
            textView3.setText("Unknown");
            textView2.setText("Unknown");
                 }
    }
}

