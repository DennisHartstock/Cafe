package com.example.cafe;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText etName;
    private EditText etPassword;
    private Button btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        btLogin.setOnClickListener(view -> {
            String name = etName.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            if (name.isEmpty() || password.isEmpty()) {
                Toast.makeText(
                        this,
                        R.string.toast_error_fields_empty,
                        Toast.LENGTH_SHORT
                ).show();
            } else {
                launchMakeOrder(name);
            }
        });
    }

    private void launchMakeOrder(String name) {
        Intent intent = MakeOrderActivity.newIntent(this, name);
        startActivity(intent);
    }

    private void initViews() {
        etName = findViewById(R.id.etName);
        etPassword = findViewById(R.id.etPassword);
        btLogin = findViewById(R.id.btLogin);
    }
}