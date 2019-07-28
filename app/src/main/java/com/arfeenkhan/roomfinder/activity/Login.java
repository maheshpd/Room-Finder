package com.arfeenkhan.roomfinder.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.arfeenkhan.roomfinder.R;

public class Login extends AppCompatActivity implements View.OnClickListener {

    //Widget
    Button btn_forgot, btn_login, btn_facebook, btn_register;
    EditText edt_email, edt_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Init widget
        initWidget();
    }

    private void initWidget() {
        edt_email = findViewById(R.id.login_email_edit);
        edt_password = findViewById(R.id.login_edt_password);
        btn_forgot = findViewById(R.id.forgot_password_btn);
        btn_login = findViewById(R.id.login_btn_login);
        btn_facebook = findViewById(R.id.login_btn_facebook);
        btn_register = findViewById(R.id.login_btn_register);

        //on Btn Click
        btn_forgot.setOnClickListener(this);
        btn_login.setOnClickListener(this);
        btn_facebook.setOnClickListener(this);
        btn_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.forgot_password_btn) {
            forgotPassword();
        } else if (id == R.id.login_btn_login) {
            startLogin();
        } else if (id == R.id.login_btn_facebook) {
            startFacebookLogin();
        } else if (id == R.id.login_btn_register) {
            startRegisterActivity();
        }
    }

    private void startFacebookLogin() {
    }

    private void startLogin() {

        Intent intent = new Intent(Login.this, CreateProfile.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);

    }

    private void forgotPassword() {
        Intent intent = new Intent(Login.this, ForgotPassword.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    private void startRegisterActivity() {
        Intent intent = new Intent(Login.this, Register.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
