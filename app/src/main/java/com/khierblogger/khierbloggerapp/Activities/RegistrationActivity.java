package com.khierblogger.khierbloggerapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.khierblogger.khierbloggerapp.Intefaces.OrganizationsResponseCallback;
import com.khierblogger.khierbloggerapp.KhierBloggerServer;
import com.khierblogger.khierbloggerapp.MainClasses.Organization;
import com.khierblogger.khierbloggerapp.R;
import com.khierblogger.khierbloggerapp.Utils;

import java.util.ArrayList;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        Button registrationButton = (Button) findViewById(R.id.registration_button);
        registrationButton.setOnClickListener(this);

        TextView loginTextView = (TextView) findViewById(R.id.login_bottom_text);
        loginTextView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.registration_button:
                //TODO: check the correct inputs
                //TODO: Post to the server a new user registration
                break;
            case R.id.login_bottom_text:
                startActivity(new Intent(this , LoginActivity.class));
                break;
        }
    }
}
