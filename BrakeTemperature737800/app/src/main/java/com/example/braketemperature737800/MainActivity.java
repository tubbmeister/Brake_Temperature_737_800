package com.example.braketemperature737800;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    EditText Brake_on_speed;
    EditText OAT;
    EditText Elevation;
    EditText Weight;
    EditText CalcUplift;
    String[] FirstArray,SecondArray;
    int Brake_onX1,Brake_onX2,OATX1,OATX2,ElevationX1,ElevationX2, WeightX1,WeightX2;
    int Brake_On_Speed1,OAT1,Elevation1,Weight1,ResultAHi,ResultALo,ResultBHi,ResultBLo;
    int ElevationArrayHigh, ElevationArrayLo, OATHigh,OATLow;
    double Y1;
    double Y2;
    String Y3; //data results

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
        CalcUplift=findViewById(R.id.CalcUplift);



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
            Brake_on_speed.setError("Speed!");
            return;
        }
        String OATString=OAT.getText().toString();
        if(TextUtils.isEmpty(OATString)) {
            OAT.setError("Temp!");
            return;
        }
        String ElevationString=Elevation.getText().toString();
        if(TextUtils.isEmpty(ElevationString)) {
            Elevation.setError("Elevation!");

        }
        String WeightString=Weight.getText().toString();
        if(TextUtils.isEmpty(WeightString)) {
            Weight.setError("Weight!");

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
        if(Brake_on_Speed1>179) {
            Brake_onX2=180;
            Brake_onX1=160;
        }
        else if(Brake_on_Speed1>159 && Brake_on_Speed1<180) {
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
         if(Elevation1>4999){
             ElevationX2=10;ElevationArrayHigh = 2;
             ElevationX1=5;ElevationArrayLo = 1;
         }
         else if(Elevation1>-1 && Elevation1<5000){
             ElevationX2=5; ElevationArrayHigh=1;
             ElevationX1=0; ElevationArrayLo=0;
         }
         if(OAT1>39){
             OATX2=50;OATHigh=18; //selects within array
             OATX1=40;OATLow=15;
         }
         else if(OAT1>29 && OAT1<40){
             OATX2=40;OATHigh=15;
             OATX1=30;OATLow=12;
         }
         else if(OAT1>19 && OAT1<30){
             OATX2=30;OATHigh=12;
             OATX1=20;OATLow=9;
         }
         else if(OAT1>14 && OAT1<20){
             OATX2=20;OATHigh=9;
             OATX1=15;OATLow=6;
         }
         else if(OAT1>9 && OAT1<15){
             OATX2=15;OATHigh=6;
             OATX1=10;OATLow=3;
         }
         else if(OAT1>-1 && OAT1<10){
             OATX2=10;OATHigh=3;
             OATX1=0;OATLow=0;
         }
        Resources r = getResources(); //allows array to be loaded

         if(Brake_onX2==180 && WeightX2==80) {
             FirstArray=r.getStringArray(R.array.RCBS_180_80);
         }
         else if(Brake_onX2==180 && WeightX2==70){
             SecondArray=r.getStringArray(R.array.RCBS_180_70);
         }
         else if(Brake_onX2==160 && WeightX2==80){
             FirstArray=r.getStringArray(R.array.RCBS_160_80);
         }
         else if(Brake_onX2==160 && WeightX2==70){
             FirstArray=r.getStringArray(R.array.RCBS_160_70);
         }
         else if(Brake_onX2==140 && WeightX2==80){
             FirstArray=r.getStringArray(R.array.RCBS_140_80);
         }
         else if(Brake_onX2==140 && WeightX2==70){
             FirstArray=r.getStringArray(R.array.RCBS_140_70);
         }

          if(Brake_onX1==180 && WeightX1==80){
             SecondArray=r.getStringArray(R.array.RCBS_180_80);
         }
         else if(Brake_onX1==180 && WeightX1==70){
             SecondArray=r.getStringArray(R.array.RCBS_180_70);
         }
         else if(Brake_onX1==160 && WeightX1==80){
             SecondArray=r.getStringArray(R.array.RCBS_160_80);
         }
         else if(Brake_onX1==160 && WeightX1==70){
             SecondArray=r.getStringArray(R.array.RCBS_160_70);
         }
         else if(Brake_onX1==140 && WeightX1==80){
             SecondArray=r.getStringArray(R.array.RCBS_140_80);
         }
         else if(Brake_onX1==140 && WeightX1==70){
             SecondArray=r.getStringArray(R.array.RCBS_140_70);
         }


         //now start the calculations

        Y3=FirstArray[OATHigh]; //convert array string to double
        double d= Double.parseDouble(Y3);
        CalcUplift.setText((String.valueOf(d))+" ");

        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow((null == getCurrentFocus()) ? null : getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }
}