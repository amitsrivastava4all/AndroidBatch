package com.srivastava.games.testgame;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends Activity {
private boolean isXorZero = true;
    private Button one,two,three,four,five,six;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerEvents();

    }
    private void registerEvents(){
         one = (Button)this.findViewById(R.id.one);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printXOrZero(one);
            }
        });
         two = (Button)this.findViewById(R.id.two);
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printXOrZero(two);
            }
        });
         three = (Button)this.findViewById(R.id.three);
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printXOrZero(three);
            }
        });

         four = (Button)this.findViewById(R.id.four);
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printXOrZero(four);
            }
        });

         five = (Button)this.findViewById(R.id.five);
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printXOrZero(five);
            }
        });

         six = (Button)this.findViewById(R.id.six);
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printXOrZero(six);
            }
        });
    }
    private void printXOrZero(Button bt){
        if(bt.getText().toString().trim().length()==0) {
            if (isXorZero) {
                bt.setText("X");
            } else {
                bt.setText("0");
            }
            if(isWin()){
                ImageView gameOver = (ImageView)this.findViewById(R.id.gameover);
                gameOver.setImageResource(R.drawable.gameover);
            }
            isXorZero = !isXorZero;
        }
    }

    private boolean isWin(){
        if(!isBlankRow(one,two,three)){
            if((one.getText().toString().equals(two.getText().toString()))
                    && (one.getText().toString().equals(three.getText().toString()))){
                return true;
            }
        }
        return false;
    }

    private boolean isBlankRow(Button b1, Button b2, Button b3){
        if(isBlank(b1) && isBlank(b2) && isBlank(b3)){
            return true;
        }
        return false;
    }

    private boolean isBlank(Button b1){
        if(b1.getText().toString().trim().length()==0){
            return true;
        }
        return false;
    }




}
