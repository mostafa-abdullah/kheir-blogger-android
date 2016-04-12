package com.khierblogger.khierbloggerapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button signInButton = (Button)findViewById(R.id.sign_in_button);
        signInButton.setOnClickListener(this);

        TextView forgotPasswordTextView = (TextView) findViewById(R.id.forgot_password_bottom_text);
        forgotPasswordTextView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.sign_in_button:
                //TODO: check for correct inputs
                //TODO: Post to the server to authenticate the given user
                break;
            case R.id.forgot_password_bottom_text:
                startActivity(new Intent(this , ResetPasswordActivity.class));
                break;
        }
    }
}
