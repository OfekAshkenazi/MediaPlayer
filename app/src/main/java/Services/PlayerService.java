package Services;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.IntDef;

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
    public int onStartCommand(Intent intent,int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
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
