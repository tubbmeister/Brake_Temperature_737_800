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
    EditText CalcUplift,ExpectedLitres,ActualLitres;
    String[] FirstArray,SecondArray;//for high weight calc
    String[]ThirdArray,FourthArray;//for low weight calc
    int Brake_onX1,Brake_onX2,OATX1,OATX2,ElevationX1,ElevationX2, WeightX1,WeightX2;
    int Brake_On_Speed1,OAT1,Elevation1,Weight1,ResultBHi,ResultBLo;
    int ElevationArrayHigh, ElevationArrayLo, OATHigh,OATLow;
    double Y1, ResultHeavy,ResultLight,FinalResult;
    double Y2,Y5,Y6,Y7,Y8;
    String Y3,Y4; //data results
    double FirstA, FirstB,FirstAnswer1,FirstAnswer,SecondA,SecondB,SecondAnswer;
    double ThirdA,ThirdB,FourthA,FourthB,ThirdAnswer,FourthAnswer;
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
        ExpectedLitres=findViewById(R.id.ExpectedLitres);
        ActualLitres=findViewById(R.id.ActualLitres);



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


        int Brake_On_Speed1=(Integer.parseInt(Brake_on_speed.getText().toString()));

        int OAT1=((Integer.parseInt(OAT.getText().toString())));
        int Elevation1=(Integer.parseInt(Elevation.getText().toString()));
        int Weight1=(Integer.parseInt(Weight.getText().toString()));




         if(Weight1>69) {
            WeightX2=80;
            WeightX1=70;
        }
         else if(Weight1==70) { //use same weight for both calcs
             WeightX2=70;
             WeightX1=70;
         }
         else if(Weight1==60) {
             WeightX2=60;
             WeightX1=60;
         }
        else if(Weight1>60 && Weight1<70) {
            WeightX2=70;
            WeightX1=60;
         }
         else if(Weight1>59 && Weight1<70) {
             WeightX2=70;
             WeightX1=60;
         }
         else if(Weight1==50) {
             WeightX2=50;
             WeightX1=50;
         }
         else if(Weight1==40) {
             WeightX2=40;
             WeightX1=40;
         }
         else if(Weight1>40 && Weight1<50) {
             WeightX2=50;
             WeightX1=40;
         }
        if(Brake_On_Speed1>179) {
            Brake_onX2=180;
            Brake_onX1=180;
        }
        else if(Brake_On_Speed1==160) {
            Brake_onX2=160;
            Brake_onX1=160;
        }
        else if(Brake_On_Speed1>160 && Brake_On_Speed1<180) {
            Brake_onX2=180;
            Brake_onX1=160;
        }
        else if(Brake_On_Speed1==140) {
            Brake_onX2=140;
            Brake_onX1=140;
        }

        else if(Brake_On_Speed1>140 && Brake_On_Speed1<160) {
            Brake_onX2=160;
            Brake_onX1=140;
        }
        else if(Brake_On_Speed1==120) {
            Brake_onX2=120;
            Brake_onX1=120;
        }
         else if(Brake_On_Speed1>120 && Brake_On_Speed1<140) {
             Brake_onX2=140;
             Brake_onX1=120;
         }
        else if(Brake_On_Speed1==100) {
            Brake_onX2=100;
            Brake_onX1=100;
        }
         else if(Brake_On_Speed1>100 && Brake_On_Speed1<120) {
             Brake_onX2=120;
             Brake_onX1=100;
         }
        else if(Brake_On_Speed1==80) {
            Brake_onX2=80;
            Brake_onX1=80;
        }
         else if(Brake_On_Speed1>80 && Brake_On_Speed1<100) {
             Brake_onX2=100;
             Brake_onX1=80;
         }
         if(Elevation1>4999){
             ElevationX2=10000;ElevationArrayHigh = 2;
             ElevationX1=5000;ElevationArrayLo = 1;
         }
         else if(Elevation1>-1 && Elevation1<5000){
             ElevationX2=5000; ElevationArrayHigh=1;
             ElevationX1=0; ElevationArrayLo=0;
         }
         if(OAT1>39){
             OATX2=50;OATHigh=18; //selects within array
             OATX1=40;OATLow=15;
         }
         else if(OAT1==40){
             OATX2=40;OATHigh=15;
             OATX1=40;OATLow=15;
         }
         else if(OAT1==30){
             OATX2=30;OATHigh=12;
             OATX1=30;OATLow=12;
         }
         else if(OAT1>30 && OAT1<40){
             OATX2=40;OATHigh=15;
             OATX1=30;OATLow=12;
         }
         else if(OAT1==20){
             OATX2=20;OATHigh=9;
             OATX1=20;OATLow=9;
         }
         else if(OAT1>19 && OAT1<30){
             OATX2=30;OATHigh=12;
             OATX1=20;OATLow=9;
         }
         else if(OAT1==15){
             OATX2=15;OATHigh=6;
             OATX1=15;OATLow=6;
         }
         else if(OAT1>14 && OAT1<20){
             OATX2=20;OATHigh=9;
             OATX1=15;OATLow=6;
         }
         else if(OAT1==10){
             OATX2=10;OATHigh=3;
             OATX1=10;OATLow=3;
         }
         else if(OAT1>9 && OAT1<15){
             OATX2=15;OATHigh=6;
             OATX1=10;OATLow=3;
         }
         else if(OAT1==0){
             OATX2=0;OATHigh=0;
             OATX1=0;OATLow=0;
         }
         else if(OAT1>-1 && OAT1<10){
             OATX2=10;OATHigh=3;
             OATX1=0;OATLow=0;
         }
        Resources r = getResources(); //allows array to be loaded

         if(Brake_onX2==180 && WeightX2==80) { //hi spd hi wgt
             FirstArray=r.getStringArray(R.array.RCBS_180_80);
         }
         else if(Brake_onX2==180 && WeightX2==70){
             FirstArray=r.getStringArray(R.array.RCBS_180_70);
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

          if(Brake_onX2==180 && WeightX1==80){ //Hi spd, lo wgt
             SecondArray=r.getStringArray(R.array.RCBS_180_80);
         }
         else if(Brake_onX2==180 && WeightX1==70){
             SecondArray=r.getStringArray(R.array.RCBS_180_70);
         }
         else if(Brake_onX2==160 && WeightX1==80){
             SecondArray=r.getStringArray(R.array.RCBS_160_80);
         }
         else if(Brake_onX2==160 && WeightX1==70){
             SecondArray=r.getStringArray(R.array.RCBS_160_70);
         }
         else if(Brake_onX2==140 && WeightX1==80){
             SecondArray=r.getStringArray(R.array.RCBS_140_80);
         }
         else if(Brake_onX2==140 && WeightX1==70){
             SecondArray=r.getStringArray(R.array.RCBS_140_70);
         }
        if(Brake_onX1==180 && WeightX2==80) { //low spd hi wgt
            ThirdArray = r.getStringArray(R.array.RCBS_180_80);
        }
        else if (Brake_onX1==180 && WeightX2==70) {
            ThirdArray = r.getStringArray(R.array.RCBS_180_70);
        }
        else if (Brake_onX1==160 && WeightX2==80) {
            ThirdArray = r.getStringArray(R.array.RCBS_160_80);
        }
        else if (Brake_onX1==160 && WeightX2==70) {
            ThirdArray = r.getStringArray(R.array.RCBS_160_70);
        }
        else if (Brake_onX1==140 && WeightX2==80) {
            ThirdArray = r.getStringArray(R.array.RCBS_140_80);
        }
        else if (Brake_onX1==140 && WeightX2==70) {
            ThirdArray = r.getStringArray(R.array.RCBS_140_70);
        }


        if(Brake_onX1==180 && WeightX1==80) { //low spd hi wgt
            FourthArray = r.getStringArray(R.array.RCBS_180_80);
        }
        else if (Brake_onX1==180 && WeightX1==70) {
            FourthArray = r.getStringArray(R.array.RCBS_180_70);
        }
        else if (Brake_onX1==160 && WeightX1==80) {
            FourthArray = r.getStringArray(R.array.RCBS_160_80);
        }
        else if (Brake_onX1==160 && WeightX1==70) {
            FourthArray = r.getStringArray(R.array.RCBS_160_70);
        }
        else if (Brake_onX1==140 && WeightX1==80) {
            FourthArray = r.getStringArray(R.array.RCBS_140_80);
        }
        else if (Brake_onX1==140 && WeightX1==70) {
            FourthArray = r.getStringArray(R.array.RCBS_140_70);
        }
         //now start the calculations
        //First Calc

        //ResultA = FirstArray[]
        Y3=FirstArray[OATHigh+ElevationArrayHigh];
        Y4=FirstArray[OATLow+ElevationArrayHigh];
        Y1= Double.parseDouble(Y3);
        Y2= Double.parseDouble(Y4);


        Y5=(OAT1-OATX1);
        Y5=Y5/(OATX2-OATX1);

        Y5=Y5*(Y1-Y2);
        FirstA=Y5+Y2; //High weight, high alt,

        ActualLitres.setText((String.valueOf(FirstA))+" "); //first"A"
        //Y5=Y2+(((OAT1-OATX1)/(OATX2-OATX1))*(Y1-Y2));
        //Y5=FirstArray[OATHigh+ElevationArrayHigh]; //convert array string to double

        Y3=FirstArray[OATHigh+ElevationArrayLo];
        Y4=FirstArray[OATLow+ElevationArrayLo];
        Y1= Double.parseDouble(Y3);
        Y2= Double.parseDouble(Y4);
        Y5=(OAT1-OATX1);
        Y5=Y5/(OATX2-OATX1);

        Y5=Y5*(Y1-Y2);
        FirstB=Y5+Y2; //High weight, high alt,
       // ExpectedLitres.setText((String.valueOf(FirstB))+" ");//first "B"

        FirstAnswer=Elevation1-ElevationX1;
        FirstAnswer=FirstAnswer/(ElevationX2-ElevationX1);
        FirstAnswer=FirstAnswer*(FirstA-FirstB);
        FirstAnswer=FirstAnswer+FirstB; //first number for high wgt high spd

        Y3=ThirdArray[OATHigh+ElevationArrayHigh];
        Y4=ThirdArray[OATLow+ElevationArrayHigh];
        Y1= Double.parseDouble(Y3);
        Y2= Double.parseDouble(Y4);
        Y5=(OAT1-OATX1);
        Y5=Y5/(OATX2-OATX1);

        Y5=Y5*(Y1-Y2);
        SecondA=Y5+Y2; //lo spd,hi weight, high alt,

        Y3=ThirdArray[OATHigh+ElevationArrayLo];
        Y4=ThirdArray[OATLow+ElevationArrayLo];
        Y1= Double.parseDouble(Y3);
        Y2= Double.parseDouble(Y4);
        Y5=(OAT1-OATX1);
        Y5=Y5/(OATX2-OATX1);

        Y5=Y5*(Y1-Y2);
        SecondB=Y5+Y2; //lo spd,hi weight, lo alt,
        SecondAnswer=Elevation1-ElevationX1;
        SecondAnswer=SecondAnswer/(ElevationX2-ElevationX1);
        SecondAnswer=SecondAnswer*(SecondA-SecondB);
        SecondAnswer=SecondAnswer+SecondB; //first number for high wgt high spd


        ResultHeavy=Brake_On_Speed1-Brake_onX1;
        ResultHeavy=ResultHeavy/(Brake_onX2-Brake_onX1);
        ResultHeavy=ResultHeavy*(FirstAnswer-SecondAnswer);
        ResultHeavy=ResultHeavy+SecondAnswer;

        Y3=SecondArray[OATHigh+ElevationArrayHigh];//hi spd low wgt hi alt
        Y4=SecondArray[OATLow+ElevationArrayHigh];
        Y1= Double.parseDouble(Y3);
        Y2= Double.parseDouble(Y4);


        Y5=(OAT1-OATX1);
        Y5=Y5/(OATX2-OATX1);

        Y5=Y5*(Y1-Y2);
        ThirdA=Y5+Y2; //hi spd, low weight, high alt,


        Y3=SecondArray[OATHigh+ElevationArrayLo];//hi spd,low wgt,lo alt
        Y4=SecondArray[OATLow+ElevationArrayLo];
        Y1= Double.parseDouble(Y3);
        Y2= Double.parseDouble(Y4);
        Y5=(OAT1-OATX1);
        Y5=Y5/(OATX2-OATX1);

        Y5=Y5*(Y1-Y2);
        ThirdB=Y5+Y2; //high spd, low weight, low alt,

        ThirdAnswer=Elevation1-ElevationX1;
        ThirdAnswer=ThirdAnswer/(ElevationX2-ElevationX1);
        ThirdAnswer=ThirdAnswer*(ThirdA-ThirdB);
        ThirdAnswer=ThirdAnswer+ThirdB; //first number for high wgt high spd


        Y3=FourthArray[OATHigh+ElevationArrayHigh];//low spd, low wgt, hi alt
        Y4=FourthArray[OATLow+ElevationArrayHigh];
        Y1= Double.parseDouble(Y3);
        Y2= Double.parseDouble(Y4);
        Y5=(OAT1-OATX1);
        Y5=Y5/(OATX2-OATX1);
        Y5=Y5*(Y1-Y2);
        FourthA=Y5+Y2; //lo spd,Lo weight, high alt,

        Y3=FourthArray[OATHigh+ElevationArrayLo];//lo sp,lo wgt,lo alt
        Y4=FourthArray[OATLow+ElevationArrayLo];
        Y1= Double.parseDouble(Y3);
        Y2= Double.parseDouble(Y4);
        Y5=(OAT1-OATX1);
        Y5=Y5/(OATX2-OATX1);
        Y5=Y5*(Y1-Y2);
        FourthB=Y5+Y2; //lo spd,Lo weight, high alt,


        FourthAnswer=Elevation1-ElevationX1;
        FourthAnswer=FourthAnswer/(ElevationX2-ElevationX1);
        FourthAnswer=FourthAnswer*(FourthA-FourthB);
        FourthAnswer=FourthAnswer+FourthB; //first number for high wgt high spd


        ResultLight=Brake_On_Speed1-Brake_onX1;
        ResultLight=ResultLight/(Brake_onX2-Brake_onX1);
        ResultLight=ResultLight*(ThirdAnswer-FourthAnswer);
        ResultLight=ResultLight+FourthAnswer;

        FinalResult=Weight1-WeightX1; //actual - min weight
        FinalResult=FinalResult/(WeightX2-WeightX1);
        FinalResult=FinalResult*(ResultHeavy-ResultLight);
        FinalResult=FinalResult+ResultLight;
        //double d= Double.parseDouble(FinalResult);
        CalcUplift.setText((String.valueOf(FinalResult))+" ");
         //d= Double.parseDouble(Y4);




        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow((null == getCurrentFocus()) ? null : getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }
}