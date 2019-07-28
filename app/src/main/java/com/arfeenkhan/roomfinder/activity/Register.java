package com.arfeenkhan.roomfinder.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.arfeenkhan.roomfinder.R;

public class Register extends AppCompatActivity implements View.OnClickListener {

    //Widget
    Button btn_login,btn_register,btn_facebook;
    EditText edt_first_name,edt_last_name,edt_email,edt_password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Initialize widget

        initWidget();



    }

    private void initWidget() {
        edt_first_name = findViewById(R.id.first_name_edt);
        edt_last_name = findViewById(R.id.edt_last_name);
        edt_email = findViewById(R.id.email_edit);
        edt_password = findViewById(R.id.edt_password);
        btn_login = findViewById(R.id.btn_login);
        btn_register = findViewById(R.id.btnRegister);
        btn_facebook = findViewById(R.id.btn_facebook);


        //on Butoon Click
        btn_login.setOnClickListener(this);
        btn_register.setOnClickListener(this);
        btn_facebook.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.btn_login) {
            startLoginActivity();
        } else if (id == R.id.btnRegister) {
            startRegister();
        }else if (id == R.id.btn_facebook) {
            doFacebookLogin();
        }

    }

    private void doFacebookLogin() {
    }

    private void startRegister() {
    }

    private void startLoginActivity() {
        Intent intent = new Intent(Register.this, Login.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
