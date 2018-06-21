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


import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    public TextToSpeech myTTS;
    //status check code
    public int MY_DATA_CHECK_CODE = 0;


    @Override
    public void onAttachedToWindow() {

        super.onAttachedToWindow();
        runOnUiThread(new Runnable() {

            @Override
            public void run() {
                final Handler handler = new Handler();
                boolean b = handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        String words = getString(R.string.welcome_note);
                        String words1= getString(R.string.desc);
                        String bs = "Click on the button" + getString(R.string.WelcomePageButtonTitle);  // Message for the button

                        speakWords(words + "." + words1 + "." + bs);  // The words are spoken by the application

                    }
                }, 1000);

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       Button buttonObj = (Button) findViewById(R.id.button);
        buttonObj.setOnClickListener(func);

         Intent checkTTSIntent = new Intent();
        checkTTSIntent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivityForResult(checkTTSIntent, MY_DATA_CHECK_CODE);
    }

   private View.OnClickListener func = new View.OnClickListener() {
        public void onClick(View v) {

            Toast.makeText(getApplicationContext(), "button clicked", Toast.LENGTH_LONG).show();
            OnClickOfMainMenuButton(v); // Navigates to activity2 on click of button Main menu
        }

    };

    public void OnClickOfMainMenuButton(View view){
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }

    //speak the user text
    public void speakWords(String speech) {   //private

        //speak straight away
        myTTS.speak(speech, TextToSpeech.QUEUE_FLUSH, null);
    }

    //act on result of TTS data check
    public void onActivityResult(int requestCode, int resultCode, Intent data) {   //protected

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
            Toast.makeText(this, "TTS has failed...Please close the app and restart again", Toast.LENGTH_LONG).show();
        }
    }


}
