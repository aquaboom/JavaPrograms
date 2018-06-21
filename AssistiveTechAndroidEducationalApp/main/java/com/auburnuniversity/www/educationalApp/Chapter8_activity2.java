package com.auburnuniversity.www.educationalApp;


/**
 * Created by Sonali on 9/13/2017.
 */


import android.content.Intent;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Chapter8_activity2 extends Chapter8_activity1 {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter8_activity2);
        Intent myIntent = getIntent();
        String denominator = myIntent.getStringExtra("denominator");
        TextView denominator_tv = (TextView) findViewById(R.id.textView5);
        denominator_tv.setText(denominator);
        NavigateToNextPage();
    }

    public void NavigateToNextPage() {
        Button buttonObj = (Button) findViewById(R.id.Next);
        buttonObj.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String[] val=new String[2];
                //Gets the first factor using the editText
                EditText factor1_edTxt = (EditText) findViewById(R.id.factor1);
                // Converts the editText value to string value and is assigned to val
                val[0] = factor1_edTxt.getText().toString();
                EditText factor2_edTxt = (EditText) findViewById(R.id.factor2);
                // Converts the editText value to string value and is assigned to val
                val[1]= factor2_edTxt.getText().toString();
                if (val[0].length() > 0 && val[1].length() > 0){
                    Intent intent = new Intent(Chapter8_activity2.this, Chapter8_activity3.class);
                    // The value of the variable val is assigned to factor1_value and passed to Chapter8_activity3
                    intent.putExtra("factor1_value", val[0]);
                    intent.putExtra("factor2_value",val[1]);

                    startActivity(intent);
                }else{
                    Toast.makeText(Chapter8_activity2.this, "Warning: Factor 1 and Factor 2 cannot be null", Toast.LENGTH_LONG).show();
                }

            }
        });
       }




}

