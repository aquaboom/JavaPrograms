package com.auburnuniversity.www.educationalApp;


/**
 * Created by Sonali on 9/13/2017.
 */

import android.content.Intent;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;


public class Chapter8_activity1 extends AppCompatActivity implements TextToSpeech.OnInitListener{

    private TextToSpeech myTTS;
    //status check code
    private int MY_DATA_CHECK_CODE = 0;

    DBHandler dbHandler;

    public void init(final String[]  expressions){
        Button buttonObj = (Button) findViewById(R.id.button4);
        buttonObj.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Chapter8_activity1.this, Chapter8_activity2.class);
                intent.putExtra("numerator", expressions[0]);
                intent.putExtra("denominator", expressions[1]);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter8_activity1);
        dbHandler = new DBHandler(this);
        String[] expressions = dbHandler.getRational();
        init(expressions);
        TextView numerator = (TextView) findViewById(R.id.textView3);
        TextView denominator = (TextView) findViewById(R.id.textView4);
        numerator.setText(expressions[0]);
        denominator.setText(expressions[1]);

        Button buttonObject = (Button) findViewById(R.id.Read);
        buttonObject.setOnClickListener(onClickReadListener);
        Intent checkTTSIntent = new Intent();
        checkTTSIntent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivityForResult(checkTTSIntent, MY_DATA_CHECK_CODE);
    }

    private View.OnClickListener onClickReadListener = new View.OnClickListener() {
        public void onClick(View v) {         //protected
            runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    final Handler handler = new Handler();
                    boolean b = handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {


                            TextView numerator = (TextView) findViewById(R.id.textView3);
                            TextView denominator = (TextView) findViewById(R.id.textView4);

                            String bs = "numerator is " + numerator.getText() + " and denominator is " + denominator.getText();  // Message for the button

                            speakWords(bs);  // The words are spoken by the application
                            //}
                        }
                    }, 1000);

                }
            });

        }
    };

    public void speakWords(String speech) {   //private

        //speak straight away
        myTTS.speak(speech, TextToSpeech.QUEUE_FLUSH, null);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {         //protected

        if (requestCode == MY_DATA_CHECK_CODE) {
            if (resultCode == TextToSpeech.Engine.CHECK_VOICE_DATA_PASS) {
                //the user has the necessary data - create the TTS
                myTTS = new TextToSpeech(this, this);
            }
            else {
                //no data - install it now
                Intent installTTSIntent = new Intent();
                installTTSIntent.setAction(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
                startActivity(installTTSIntent);
            }
        }
    }

    //setup TTS
    public void onInit(int initStatus) {

        //check for successful instantiation
        if (initStatus == TextToSpeech.SUCCESS) {
            if(myTTS.isLanguageAvailable(Locale.US)==TextToSpeech.LANG_AVAILABLE)
                myTTS.setLanguage(Locale.US);
        }
        else if (initStatus == TextToSpeech.ERROR) {
            Toast.makeText(this, "Text To Speech failed...Please try again later by closing the app", Toast.LENGTH_LONG).show();
        }
    }

    }
