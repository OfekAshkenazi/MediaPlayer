package com.example.android.mediaplayer;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import Services.PlayerService;

public class MainActivity extends AppCompatActivity {
    Intent playerServiceIntent;
    Button playButton;
    private PlayerService playerService;
    ServiceConnection serviceConnection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            playerService=((PlayerService.PlayerBinder)service).getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playButton= (Button) findViewById(R.id.playBtn);
        playerServiceIntent=new Intent(this, PlayerService.class);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (playerService.isPlaying()){
                    playerService.pause();
                    playButton.setText("Play");
                }
                else {
                    Intent intent=new Intent(MainActivity.this,PlayerService.class);
                    startService(intent);
                    playerService.play();
                    playButton.setText("Pause");
                }
            }
        });
    }


}
