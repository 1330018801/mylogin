package com.seimun.mylogin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.seimun.library.DatabaseHandler;
import com.seimun.library.UserFunctions;

import java.util.HashMap;

public class Main extends Activity{
    Button btnLogout, changepas;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        changepas = (Button)findViewById(R.id.btchangepass);
        btnLogout = (Button)findViewById(R.id.logout);

        DatabaseHandler db = new DatabaseHandler(getApplicationContext());
        HashMap user = new HashMap();
        user = db.getUserDetails();

        changepas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent chgpass = new Intent(getApplicationContext(), ChangePassword.class);
                startActivity(chgpass);
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                UserFunctions logout = new UserFunctions();
                logout.logoutUser(getApplicationContext());
                Intent login = new Intent(getApplicationContext(), Login.class);
                login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(login);
                finish();
            }
        });

        final TextView login = (TextView) findViewById(R.id.textwelcome);
        login.setText("Welcome  " + user.get("fname"));
        final TextView lname = (TextView) findViewById(R.id.lname);
        lname.setText((String)user.get("lname"));
    }
}
