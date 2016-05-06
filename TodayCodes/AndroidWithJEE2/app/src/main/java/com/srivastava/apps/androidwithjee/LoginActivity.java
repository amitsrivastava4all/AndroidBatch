package com.srivastava.apps.androidwithjee;

import android.app.Activity;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;


public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button loginBt = (Button)this.findViewById(R.id.loginBt);
        loginBt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                try {
                    makeServerCall();
                }
                catch(Exception e){
                    Log.e("testengine", "exception raised in server call ",e);
                    //Log.e("testengine",e.getMessage());
                    e.printStackTrace();
                }
            }
        });
    }

    private void makeServerCall() throws Exception{
        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        EditText useridTxt = (EditText)this.findViewById(R.id.useridTxt);
        EditText pwdTxt = (EditText)this.findViewById(R.id.pwdTxt);
        String userid = useridTxt.getText().toString();
        String  pwd = pwdTxt.getText().toString();
        URL url = new URL("http://10.0.2.2:7676/testengineapp/login?userid="+userid+"&pwd="+pwd);
        URLConnection connection = url.openConnection();
        connection.setDoOutput(true);
        //connection.setDoInput(true);
        //OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());

        //out.write(useridTxt.getText().toString());
        //out.write(pwdTxt.getText().toString());

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String data = in.readLine();
        while(data!=null){
            sb.append(data);
            data = in.readLine();
        }
        in.close();
        connection = null;
        TextView tv = (TextView)this.findViewById(R.id.msg);
        tv.setText(sb.toString());
    }



}
