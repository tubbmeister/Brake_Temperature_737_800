package com.example.richard.volmet_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    public static final String EXTRA_MESSAGE = "com.example.richard.volmet_project.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    /**
     * called when user taps button
     */

    Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
    // Create an ArrayAdapter using the string array and a default spinner layout
    ArrayAdapter adapter = ArrayAdapter.createFromResource(this,
            R.array.AirportsArray, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
spinner.setAdapter(adapter);





}


   // public void sendMessage(View view) {
        //do something

     //   Intent intent = new Intent(this, DisplayMessageActivity.class);
     //   EditText editText = (EditText) findViewById(R.id.editText);
     //   String message = editText.getText().toString();
       // String message = item;
     //   intent.putExtra(EXTRA_MESSAGE, message);
      //  startActivity(intent);
    //}

    public void Bordeaux(View view) {
        //do something

        Intent intent = new Intent(MainActivity.this, Bordeaux.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);


    }


    //@Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long l) {
    String item = parent.getItemAtPosition(pos).toString();
        Intent intent = new Intent(this, Bordeaux.class);
       // TextView textView7 = (TextView) findViewById(R.id.textView2);
       // EditText editText = (EditText) findViewById(R.id.editText);
      //  textView7.setText(item);
      //  editText.=item
        //String message = editText.getText().toString();
        String message = item;
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}