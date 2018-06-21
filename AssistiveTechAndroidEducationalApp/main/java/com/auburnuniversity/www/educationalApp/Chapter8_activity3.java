package com.auburnuniversity.www.educationalApp;


/**
 * Created by Sonali on 9/13/2017.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class Chapter8_activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter8_activity3);

        String value1= getIntent().getStringExtra("factor1_value");
        TextView factor1_tv =(TextView)findViewById(R.id.textView6);
        factor1_tv.setText(value1);

        String value2= getIntent().getStringExtra("factor2_value");
        TextView factor2_tv=(TextView)findViewById(R.id.textView7);
        factor2_tv.setText(value2);
    }
}


