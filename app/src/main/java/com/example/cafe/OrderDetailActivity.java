package com.example.cafe;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class OrderDetailActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "name";
    public static final String EXTRA_DRINK = "drink";
    public static final String EXTRA_ADDITIVES = "additives";
    public static final String EXTRA_DRINK_TYPE = "drinkType";

    private TextView tvNameValue;
    private TextView tvDrinkValue;
    private TextView tvDrinkTypeValue;
    private TextView tvAdditivesValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        initViews();
        setupTextViews();
    }

    public static Intent newIntent(
            Context context,
            String name,
            String drink,
            String drinkType,
            String additives
    ) {
        Intent intent = new Intent(context, OrderDetailActivity.class);
        intent.putExtra(EXTRA_NAME, name);
        intent.putExtra(EXTRA_DRINK, drink);
        intent.putExtra(EXTRA_DRINK_TYPE, drinkType);
        intent.putExtra(EXTRA_ADDITIVES, additives);
        return intent;
    }

    private void initViews() {
        tvNameValue = findViewById(R.id.tvNameValue);
        tvDrinkValue = findViewById(R.id.tvDrinkValue);
        tvDrinkTypeValue = findViewById(R.id.tvDrinkTypeValue);
        tvAdditivesValue = findViewById(R.id.tvAdditivesValue);
    }

    private void setupTextViews() {
        Intent intent = getIntent();

        String name = intent.getStringExtra(EXTRA_NAME);
        String drink = intent.getStringExtra(EXTRA_DRINK);
        String drinkType = intent.getStringExtra(EXTRA_DRINK_TYPE);
        String additives = intent.getStringExtra(EXTRA_ADDITIVES);

        tvNameValue.setText(name);
        tvDrinkValue.setText(drink);
        tvDrinkTypeValue.setText(drinkType);
        tvAdditivesValue.setText(additives);
    }
}