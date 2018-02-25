package com.studycase.vanard.vianrasyiddiyatma_1202154186_modul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText uname, pass;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        uname = findViewById(R.id.username);
        pass = findViewById(R.id.password);
        login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = uname.getText().toString().trim();
                String pw = pass.getText().toString().trim();

                if (user.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Please input Username", Toast.LENGTH_SHORT).show();
                }else if (pw.isEmpty()){
                    Toast.makeText(LoginActivity.this, "Please input Password", Toast.LENGTH_SHORT).show();
                }else if (user.equals("EAD") && pw.equals("MOBILE")) {
                    Intent i = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(i);
                }else {
                    Toast.makeText(LoginActivity.this, "Username or Password maybe incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
