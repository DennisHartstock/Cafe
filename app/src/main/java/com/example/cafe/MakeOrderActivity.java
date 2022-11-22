package com.example.cafe;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MakeOrderActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "name";

    private TextView tvGreetings;
    private TextView tvAdditives;

    private RadioGroup rgDrinks;
    private RadioButton rbTea;
    private RadioButton rbCoffee;

    private CheckBox cbSugar;
    private CheckBox cbMilk;
    private CheckBox cbLemon;

    private Spinner spinnerTeaTypes;
    private Spinner spinnerCoffeeTypes;

    private Button btMakeOrder;

    private String name;
    private String drink;
    private String choseDrink;
    private String drinkType = "";

    private ArrayList<String> additives;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_order);

        initViews();
        setupName();

        rgDrinks.setOnCheckedChangeListener((radioGroup, id) -> {

            if (id == rbTea.getId()) {
                onUserChoseTea();
            } else if (id == rbCoffee.getId()) {
                onUserChoseCoffee();
            }
        });

        rbTea.setChecked(true);

        btMakeOrder.setOnClickListener(view -> {
            onUserMadeOrder();
            Intent intent = OrderDetailActivity.newIntent(
                    this,
                    name,
                    drink,
                    drinkType,
                    additives.toString()
            );
            startActivity(intent);
        });
    }

    private void onUserMadeOrder() {
        additives = new ArrayList<>();

        if (cbSugar.isChecked()) {
            additives.add(cbSugar.getText().toString());
        }

        if (cbMilk.isChecked()) {
            additives.add(cbMilk.getText().toString());
        }

        if (rbTea.isChecked() && cbLemon.isChecked()) {
            additives.add(cbLemon.getText().toString());
        }

        if (rbTea.isChecked()) {
            drinkType = spinnerTeaTypes.getSelectedItem().toString();
        } else if (rbCoffee.isChecked()) {
            drinkType = spinnerCoffeeTypes.getSelectedItem().toString();
        }
    }

    private void onUserChoseCoffee() {
        drink = getString(R.string.rb_coffee);
        choseDrink = getString(R.string.tv_additives_label, drink);
        tvAdditives.setText(choseDrink);
        cbLemon.setVisibility(View.INVISIBLE);
        spinnerCoffeeTypes.setVisibility(View.VISIBLE);
        spinnerTeaTypes.setVisibility(View.INVISIBLE);
    }

    private void onUserChoseTea() {
        drink = getString(R.string.rb_tea);
        choseDrink = getString(R.string.tv_additives_label, drink);
        tvAdditives.setText(choseDrink);
        cbLemon.setVisibility(View.VISIBLE);
        spinnerTeaTypes.setVisibility(View.VISIBLE);
        spinnerCoffeeTypes.setVisibility(View.INVISIBLE);
    }

    private void setupName() {
        name = getIntent().getStringExtra(EXTRA_NAME);
        String greetings = getString(R.string.tv_greetings_label, name);
        tvGreetings.setText(greetings);
    }

    private void initViews() {
        tvGreetings = findViewById(R.id.tvGreetings);
        tvAdditives = findViewById(R.id.tvAdditives);
        rgDrinks = findViewById(R.id.rgDrinks);
        rbTea = findViewById(R.id.rbTea);
        rbCoffee = findViewById(R.id.rbCoffee);
        cbSugar = findViewById(R.id.cbSugar);
        cbMilk = findViewById(R.id.cbMilk);
        cbLemon = findViewById(R.id.cbLemon);
        btMakeOrder = findViewById(R.id.btMakeOrder);
        spinnerTeaTypes = findViewById(R.id.spinnerTeaTypes);
        spinnerCoffeeTypes = findViewById(R.id.spinnerCoffeeTypes);
        btMakeOrder = findViewById(R.id.btMakeOrder);
    }

    public static Intent newIntent(Context context, String name) {
        Intent intent = new Intent(context, MakeOrderActivity.class);
        intent.putExtra(EXTRA_NAME, name);
        return intent;
    }
}