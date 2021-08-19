package com.example.braketemperature737800;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    EditText Brake_on_speed;
    EditText OAT;
    EditText Elevation;
    EditText Weight;
    String[] FirstArray,SecondArray;
    int Brake_onX1,Brake_onX2,OATX1,OATX2,ElevationX1,ElevationX2, WeightX1,WeightX2;
    int Brake_On_Speed1,OAT1,Elevation1,Weight1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent intent = getIntent();
        //String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        Brake_on_speed = findViewById(R.id.Brake_on_Speed);
        OAT = findViewById(R.id.OAT);
        Elevation = findViewById(R.id.Elevation);
        Weight = findViewById(R.id.Weight);



        Brake_on_speed.setOnClickListener(this);
        OAT.setOnClickListener(this);
        Elevation.setOnClickListener(this);
        Weight.setOnClickListener(this);





    }

    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.Brake_on_Speed:
                Brake_on_speed.getText().clear(); //or you can use editText.setText("");
                break;
            case    R.id.OAT:
                OAT.getText().clear(); //or you can use editText.setText("");
                break;
            case     R.id.Elevation:
                Elevation.getText().clear(); //or you can use editText.setText("");
                break;
            case     R.id.Weight:
                Weight.getText().clear(); //or you can use editText.setText("");
                break;

        }

    }

    public void Calculate(View view){

        String Brake_onString=Brake_on_speed.getText().toString();
        if(TextUtils.isEmpty(Brake_onString)) {
            Brake_on_speed.setError("Add Speed!");
            return;
        }
        String OATString=OAT.getText().toString();
        if(TextUtils.isEmpty(OATString)) {
            OAT.setError("Add Temp!");
            return;
        }
        String ElevationString=Elevation.getText().toString();
        if(TextUtils.isEmpty(ElevationString)) {
            Elevation.setError("Add Elevation!");

        }
        String WeightString=Weight.getText().toString();
        if(TextUtils.isEmpty(ElevationString)) {
            Weight.setError("Add Weight!");

        }


        int Brake_on_Speed1=(Integer.parseInt(Brake_on_speed.getText().toString()));

        int OAT1=((Integer.parseInt(OAT.getText().toString())));
        int Elevation1=(Integer.parseInt(Elevation.getText().toString()));
        int Weight1=(Integer.parseInt(Weight.getText().toString()));




         if(Weight1>69) {
            WeightX2=80;
            WeightX1=70;
        }
        else if(Weight1>59 && Weight1<70) {
            WeightX2=70;
            WeightX1=60;
         }
         else if(Weight1>49 && Weight1<60) {
             WeightX2=60;
             WeightX1=50;
         }
         else if(Weight1>39 && Weight1<50) {
             WeightX2=50;
             WeightX1=40;
         }

         if(Brake_on_Speed1>159) {
             Brake_onX2=180;
             Brake_onX1=160;
         }
        else if(Brake_on_Speed1>139 && Brake_on_Speed1<160) {
            Brake_onX2=160;
            Brake_onX1=140;
        }
         else if(Brake_on_Speed1>119 && Brake_on_Speed1<140) {
             Brake_onX2=140;
             Brake_onX1=120;
         }
         else if(Brake_on_Speed1>99 && Brake_on_Speed1<120) {
             Brake_onX2=120;
             Brake_onX1=100;
         }
         else if(Brake_on_Speed1>79 && Brake_on_Speed1<100) {
             Brake_onX2=100;
             Brake_onX1=80;
         }
         if(Elevation1>4){
             ElevationX2=10;
             ElevationX1=5;
         }
         else if(Elevation1>-1 && Elevation1<5){
             ElevationX2=5;
             ElevationX1=0;
         }
         if(OAT1>39){
             OATX2=50;
             OATX1=40;
         }
         else if(OAT1>29 && OAT1<40){
             OATX2=40;
             OATX1=30;
         }
         else if(OAT1>19 && OAT1<30){
             OATX2=30;
             OATX1=20;
         }
         else if(OAT1>14 && OAT1<20){
             OATX2=20;
             OATX1=15;
         }
         else if(OAT1>9 && OAT1<15){
             OATX2=15;
             OATX1=10;
         }
         else if(OAT1>-1 && OAT1<10){
             OATX2=10;
             OATX1=0;
         }
        Resources r = getResources();

         if(Brake_onX2==180 && WeightX2==80) {
             FirstArray=r.getStringArray(R.array.RCBS_160_80);
         }
    }
}