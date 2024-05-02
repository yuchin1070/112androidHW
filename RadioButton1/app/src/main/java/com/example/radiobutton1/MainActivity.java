package com.example.radiobutton1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String outputStr = "";

                RadioButton boy = (RadioButton) findViewById(R.id.rdbBoy);
                RadioButton girl = (RadioButton) findViewById(R.id.rdbGirl);

                if (boy.isChecked())
                    outputStr += getResources().getString(R.string.male) + "\n";
                else if (girl.isChecked())
                    outputStr += getResources().getString(R.string.female) + "\n";

                RadioGroup type = (RadioGroup) findViewById(R.id.rgType);

                int selectedTypeId = type.getCheckedRadioButtonId();
                double ticketPrice = 0;

                if (selectedTypeId == R.id.rdbAdult) {
                    outputStr += getResources().getString(R.string.regularticket) + "\n";
                    ticketPrice = 500;
                } else if (selectedTypeId == R.id.rdbChild) {
                    outputStr += getResources().getString(R.string.childticket) + "\n";
                    ticketPrice = 250;
                } else {
                    outputStr += getResources().getString(R.string.studentticket) + "\n";
                    ticketPrice = 400;
                }

                EditText quantityEditText = findViewById(R.id.etQuantity);
                int quantity = Integer.parseInt(quantityEditText.getText().toString());
                double totalPrice = ticketPrice * quantity;
                outputStr += getResources().getString(R.string.numberOfTickets) + quantity + "\n" +
                        getResources().getString(R.string.total) + "$" + totalPrice;

                TextView output = (TextView) findViewById(R.id.lblOutput);
                output.setText(outputStr);
            }
        }));
    }
}