package com.example.rongchen.androidlabs;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity {
    protected static final String ACTIVITY_NAME = "LoginActivity";
    public static final String myPreference= "mypref";
    //protected static final String myEmail="emailkey";
            EditText email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.i(ACTIVITY_NAME, "In onCreate()");

        email=(EditText)findViewById(R.id.email);
        final SharedPreferences sharedPref = getSharedPreferences(myPreference, Context.MODE_PRIVATE);
        email.setText(sharedPref.getString("Defaultemail", "email@yahoo.com"));
        final Button button_login =(Button)findViewById(R.id.button);
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              String MyEmail = email.getText().toString();
                SharedPreferences.Editor editor= sharedPref.edit();
                editor.putString("email",MyEmail);
                editor.commit();
                Intent intent = new Intent(LoginActivity.this,StartActivity.class);
                startActivity(intent);

            }
        });
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.i(ACTIVITY_NAME, "In onStart()");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.i(ACTIVITY_NAME, "In onResume()");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.i(ACTIVITY_NAME, "In onPause()");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.i(ACTIVITY_NAME, "In onStop()");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i(ACTIVITY_NAME, "In onDestroy()");
    }
}
