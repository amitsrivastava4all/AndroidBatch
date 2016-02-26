package com.srivastava.basics.bookmyshow;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bookmyshow);
        ImageButton firstBt = (ImageButton)this.findViewById(R.id.firstmoviebt);
        View.OnClickListener l = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                movieDetails(v);
            }
        };
        firstBt.setOnClickListener(l);
        ImageButton secondBt = (ImageButton)this.findViewById(R.id.secondmoviebt);
        secondBt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                movieDetails(v);
            }
        });

    }

    private void movieDetails(View v){
        Intent i = new Intent(this,SecondActivity.class);
        i.putExtra("salary","90909");
        Bundle b = new Bundle();
        if(v.getId()==R.id.firstmoviebt) {
            i.putExtra("xyz","abc");
            i.putExtra("moviename","RangDeBasanti");
            //Question ques = new Question();
            //b.putSerializable("quesKey",ques);
            b.putString("moviename", "RangDeBasanti");
            b.putInt("price",200);
        }
        else
        if(v.getId()==R.id.secondmoviebt) {
            i.putExtra("moviename","RaOne");
            b.putString("moviename", "RaOne");
            b.putInt("price",200);
            //b.putString("moviename", "RaOne");
        }
        i.putExtra("bundle",b);
        startActivity(i);

    }

}
