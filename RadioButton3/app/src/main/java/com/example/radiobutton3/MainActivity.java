package com.example.radiobutton3;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textViewOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        textViewOutput = findViewById(R.id.lblOutput);

        RadioGroup genderGroup = findViewById(R.id.rgGender);
        genderGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                updateOutputText();
            }
        });

        RadioGroup typeGroup = findViewById(R.id.rgType);
        typeGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                updateOutputText();
            }
        });

        EditText quantityEditText = findViewById(R.id.etQuantity);
        quantityEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                updateOutputText();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ConfirmationActivity.class));
            }
        });
    }

    private void updateOutputText() {
        String gender = "";
        String ticketType = "";
        int quantity = 0;
        double totalPrice = 0;

        RadioButton boy = findViewById(R.id.rdbBoy);
        RadioButton girl = findViewById(R.id.rdbGirl);

        if (boy.isChecked())
            gender = "男生";
        else if (girl.isChecked())
            gender = "女生";

        RadioGroup type = findViewById(R.id.rgType);

        int selectedTypeId = type.getCheckedRadioButtonId();

        if (selectedTypeId == R.id.rdbAdult) {
            ticketType = "全票";
            totalPrice = 500;
        } else if (selectedTypeId == R.id.rdbChild) {
            ticketType = "兒童票";
            totalPrice = 250;
        } else if (selectedTypeId == R.id.rdbStudent) {
            ticketType = "學生票";
            totalPrice = 400;
        }

        EditText quantityEditText = findViewById(R.id.etQuantity);
        String quantityString = quantityEditText.getText().toString();
        if (!quantityString.isEmpty()) {
            quantity = Integer.parseInt(quantityString);
            totalPrice = totalPrice * quantity;
        }

        textViewOutput.setText(String.format("性別: %s\n票種: %s\n購買張數: %d\n總金額: $%.2f", gender, ticketType, quantity, totalPrice));
    }
}