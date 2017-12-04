package Services;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;

import com.example.android.mediaplayer.R;

public class PlayerService extends Service {
    IBinder localBinder;
    private MediaPlayer mediaPlayer;
    public PlayerService() {

    }

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer=MediaPlayer.create(this,R.raw.rockstar);

    }

    @Override
    public IBinder onBind(Intent intent) {

        return localBinder;
    }
    public void play(){
        mediaPlayer.start();
    }

    public void pause(){
        mediaPlayer.pause();
    }

    public boolean isPlaying(){
        return mediaPlayer.isPlaying();
    }


    public class PlayerBinder extends Binder{


        public PlayerService getService(){
            return PlayerService.this;
        }

    }
}
