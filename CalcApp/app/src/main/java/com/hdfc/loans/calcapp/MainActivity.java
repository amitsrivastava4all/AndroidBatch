package com.hdfc.loans.calcapp;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button ok = (Button)this.findViewById(R.id.ok);
        ok.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ((Button)MainActivity.this.findViewById(v.getId())).setText("Cancel");
                Toast.makeText(MainActivity.this,"U Click on OK ",Toast.LENGTH_LONG).show();
            }
        });
    }


}
