package com.auburnuniversity.www.educationalApp;


/**
 * Created by Sonali on 9/13/2017.
 */

        import android.os.Handler;
        import android.speech.tts.TextToSpeech;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.MotionEvent;
        import android.view.View;
        import android.content.Intent;
        import android.widget.AdapterView;
        import android.widget.AdapterView.OnItemClickListener;
        import android.widget.ArrayAdapter;
        import android.widget.ListView;
        import android.widget.TextView;
        import android.widget.Toast;

public class Main2Activity extends MainActivity {

    ListView listOfItems;
    DBHandler dbHandler;

    public int MY_DATA_CHECK_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        dbHandler = new DBHandler(this);
       // dbHandler.insertRational("x^2+6x+9","x+3","x+3");

        Intent checkTTSIntent = new Intent();
        checkTTSIntent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivityForResult(checkTTSIntent, MY_DATA_CHECK_CODE);


        listOfItems= (ListView)findViewById(R.id.lstitems);
        listOfItems.setOnHoverListener( new View.OnHoverListener(){
            @Override
            public boolean onHover(View viewClicked, MotionEvent me) {
                TextView textView = (TextView) viewClicked;
                String list_name = (String) ((TextView) viewClicked).getText();
                String message = "You have selected #" + (list_name);
                Toast.makeText(Main2Activity.this, message, Toast.LENGTH_LONG).show();
                        return true;
            }
        });
        listOfItems.setAdapter(new ArrayAdapter<String>(Main2Activity.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.dataelements)));
        listOfItems.setOnItemClickListener(new OnItemClickListener(){
                 @Override
            public void onItemClick(AdapterView<?> paret,View viewClicked,int position, long id)
                 {
                     TextView textView =  (TextView) viewClicked;
                     String list_name = (String) ((TextView) viewClicked).getText();
                     final String message = "You have clicked " + (list_name);
                     Toast.makeText(Main2Activity.this,message,Toast.LENGTH_LONG).show();

                     runOnUiThread(new Runnable() {

                         @Override
                         public void run() {
                             final Handler handler = new Handler();
                             boolean b = handler.postDelayed(new Runnable() {
                                 @Override
                                 public void run() {
                                     speakWords(message);  // The words are spoken by the application
                                     //}
                                 }
                             }, 1000);

                         }
                     });

                     if(position==7) {
                         Intent intent = new Intent(Main2Activity.this, Chapter8_activity1.class);
                         startActivity(intent);
                     }
                 }

        });


    }
}
