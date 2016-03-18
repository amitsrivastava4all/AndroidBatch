package google.sqlitedemo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class SQLDemo extends Activity {
    EditText userName ;
    EditText pwd ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqldemo);
         userName = (EditText)this.findViewById(R.id.username);
         pwd = (EditText)this.findViewById(R.id.pwd);
        Button register = (Button)this.findViewById(R.id.register);
        Button login = (Button)this.findViewById(R.id.login);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });

    }

    private void registerUser(){
        Bundle b = new Bundle();


        String x = userName.getText().toString();
        b.putString("a",x);
        b.putInt("b",21);
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        i.putExtras(b);

        startActivity(i);
        //pwd.setText(x);
    }
    private void loginUser(){

    }





}
