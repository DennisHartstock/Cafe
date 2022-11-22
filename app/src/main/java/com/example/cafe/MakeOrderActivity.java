package com.example.cafe;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MakeOrderActivity extends AppCompatActivity {
    private Button btMakeOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_order);

        btMakeOrder = findViewById(R.id.btMakeOrder);

        btMakeOrder.setOnClickListener(view -> {
            Intent intent = new Intent(this, OrderDetailActivity.class);
            startActivity(intent);
        });
    }

    public static Intent newIntent(Context context, String name) {
        Intent intent = new Intent(context, MakeOrderActivity.class);
        intent.putExtra("name", name);
        return intent;
    }
}