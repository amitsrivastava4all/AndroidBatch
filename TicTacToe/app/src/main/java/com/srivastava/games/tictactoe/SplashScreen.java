package com.srivastava.games.tictactoe;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;


public class SplashScreen  extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        final MediaPlayer m = MediaPlayer.create(this,R.raw.bmb);
        m.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Intent i  = new Intent(SplashScreen.this,TicTacToeActivity.class);
        m.stop();
        this.startActivity(i);
        this.finish();
                    //SplashScreen.this.startActivity(i);
                    //SplashScreen.this.finish();


    }
}
