package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import edu.gatech.seclass.jobcompare6300.database.JobDetailHelper;
import edu.gatech.seclass.jobcompare6300.database.model.JobDetail;
import edu.gatech.seclass.jobcompare6300.database.model.Login;


import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.content.Intent;
import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import edu.gatech.seclass.jobcompare6300.database.JobDetailHelper;
import edu.gatech.seclass.jobcompare6300.database.model.Login;

public class LoginActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;

    private String _username;
    private String _password;
    JobDetailHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
            db = new JobDetailHelper(this);


        Login login = db.getLoginDetail();
        _username = login.getUsername();
        _password = login.getPassword();


        Intent i = getIntent();
        Login model = (Login) i.getSerializableExtra("Login");


        username = (EditText) findViewById(R.id.username);
        username.setText(login.getUsername());

        password = (EditText) findViewById(R.id.password);
        password.setText(login.getPassword());
    }


    public void handleClick(View view) {
        //boolean is_error = true;
        if (username.getText().toString().matches("")) {
            username.requestFocus();
            username.setError("You did not enter a username");
            return;
        }

        if (password.getText().toString().matches("")) {
            password.setError("You did not enter a password");
            password.requestFocus();
            return;
        }

        if (!username.getText().toString().matches(_username)) {
            username.requestFocus();
            username.setError("You entered a wrong username");
            return;
        }

        if (!password.getText().toString().matches(_password)) {
            password.setError("You entered a wrong password");
            password.requestFocus();
            return;
        }


        //is_error = false;

        //if(!is_error) {
            // TODO Auto-generated method stub
            Intent i = new Intent(getApplicationContext(), JobManagementActivity.class);
            startActivity(i);
        //}
    }

}




