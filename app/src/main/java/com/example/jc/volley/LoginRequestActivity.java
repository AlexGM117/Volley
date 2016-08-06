package com.example.jc.volley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.jc.volley.models.LoginRequest;
import com.example.jc.volley.models.LoginResponse;

public class LoginRequestActivity extends AppCompatActivity {

    private TextView respuestaLoginService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_request);

        respuestaLoginService = (TextView) findViewById(R.id.respuestaLoginService);

        String infoUser = getIntent().getStringExtra("Respuesta");

        respuestaLoginService.setText(infoUser);


    }
}
