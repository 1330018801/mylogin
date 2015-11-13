package com.seimun.mylogin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.seimun.library.DatabaseHandler;

import java.util.HashMap;

public class Registered extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registered);

        DatabaseHandler db = new DatabaseHandler(getApplicationContext());
        HashMap user = db.getUserDetails();

        final TextView fname = (TextView)findViewById(R.id.fname);
        final TextView lname = (TextView)findViewById(R.id.lname);
        final TextView uname = (TextView)findViewById(R.id.uname);
        final TextView email = (TextView)findViewById(R.id.email);
        final TextView created_at = (TextView)findViewById(R.id.regat);
        fname.setText((String)user.get("fname"));
        lname.setText((String)user.get("lname"));
        uname.setText((String)user.get("uname"));
        email.setText((String)user.get("email"));
        created_at.setText((String)user.get("created_at"));

        Button login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Login.class);
                startActivityForResult(myIntent, 0);
                finish();
            }
        });

    }
}
