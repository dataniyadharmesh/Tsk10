package com.dharmesh.task_10;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private Button btn_playsong;
    private MediaPlayer mp;
    private boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



            ActionBar actionBar = getSupportActionBar();
            actionBar.setTitle("Music Player");

            mp = MediaPlayer.create(MainActivity.this, R.raw.play);
            btn_playsong = (Button)findViewById(R.id.btn_song);


        btn_playsong.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mp.isPlaying() && flag==true){
                        stopSong();
                    }
                    else if (flag == false){
                        playSong();
                    }
                }
            });
        }
    public void playSong() {
        mp.start();
        btn_playsong.setText("Pause");
        //   TextView textView = (TextView) findViewById(R.id.myTxtView);
        flag = true;
    }

    public void stopSong() {
        mp.stop();
        btn_playsong.setText("Play");
     //   TextView textView = (TextView) findViewById(R.id.myTxtView);
        flag = false;
        try {
            mp.prepare();
            btn_playsong.setText("Play");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

