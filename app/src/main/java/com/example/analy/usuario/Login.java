package com.example.analy.usuario;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.login, new SessionFragment()).commit();

    }
}
