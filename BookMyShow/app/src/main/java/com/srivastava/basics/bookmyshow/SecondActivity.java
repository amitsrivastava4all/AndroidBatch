package com.srivastava.basics.bookmyshow;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;




public class SecondActivity extends Activity {

    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView tv = (TextView)this.findViewById(R.id.textView);
        String value = this.getIntent().getStringExtra("moviename");
        Bundle b = this.getIntent().getBundleExtra("bundle");
        b.remove("moviename");
        String movieNameLbl = this.getString(R.string.movie_name);
        String priceLbl = this.getString(R.string.price);
        tv.setText(movieNameLbl+b.getString("moviename")+priceLbl+b.getInt("price"));
        AutoCompleteTextView av = (AutoCompleteTextView)this.findViewById(R.id.autoCompleteTextView);
        String[] countries  = this.getResources().getStringArray(R.array.countries_array);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,countries );
        av.setAdapter(adapter);
        Button wsBT  = (Button)this.findViewById(R.id.wsbt);
        wsBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //CurrencyConvertor c = new CurrencyConvertor();
                //double rate = c.getCurrencyConvertorSoap().conversionRate(Currency.USD, Currency.INR);
                //TextView tv = (TextView)SecondActivity.this.findViewById(R.id.textView2);
                //tv.setText("CURRENCY RATE is "+rate);
                //System.out.println("INR Rate is "+rate);
            }
        });
        Button notificationBt  = (Button)this.findViewById(R.id.notificationBt);
        notificationBt.setOnClickListener(new View.OnClickListener(){
            @Override
        public void onClick(View view){
                NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(SecondActivity.this);
                mBuilder.setSmallIcon(R.drawable.ticket);
                mBuilder.setContentTitle("Notification Alert, Click Me!");
                mBuilder.setContentText("Hi, This is Android Notification Detail!");
                Intent resultIntent = new Intent(SecondActivity.this, SecondActivity.class);
                TaskStackBuilder stackBuilder = TaskStackBuilder.create(SecondActivity.this);
                stackBuilder.addParentStack(SecondActivity.class);

// Adds the Intent that starts the Activity to the top of the stack
                stackBuilder.addNextIntent(resultIntent);
                PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
                mBuilder.setContentIntent(resultPendingIntent);
                NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

// notificationID allows you to update the notification later on.
                mNotificationManager.notify(2, mBuilder.build());

            }
        });
        Button audioBt  = (Button)this.findViewById(R.id.playbt);
        audioBt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(mp==null){
                    mp=MediaPlayer.create(SecondActivity.this,R.raw.zinda);
                    Log.d("amit",""+mp);
                    /*Uri myUri = Uri.parse("file:///sdcard/mp3/example.mp3");

                    mp.setAudioStreamType(AudioManager.STREAM_MUSIC);

                    mp.setDataSource(getApplicationContext(), myUri);
*/
                    try {
                        mp.prepare();
                    }
                    catch (Exception e){
                        Log.e("Amit",""+e);
                    }
                    mp.start();
                }
            }
        });

        Button audioStopBt  = (Button)this.findViewById(R.id.audiostop);
        audioBt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(mp!=null){
                    mp.stop();
                }
            }
        });

        ToggleButton toggle = (ToggleButton) findViewById(R.id.toggleButton);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                } else {
                    // The toggle is disabled
                }
            }
        });
    }


    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkbox_meat:
               /* if (checked)
                // Put some meat on the sandwich
                else
               */ // Remove the meat
                break;
            case R.id.checkbox_cheese:
                /*if (checked)
                // Cheese me
                else
                */// I'm lactose intolerant
                break;
            // TODO: Veggie sandwich
        }
    }
}
