package com.example.radiobutton1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonConfirm = findViewById(R.id.buttonConfirm);
        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get selected gender
                RadioButton boy = findViewById(R.id.rdbBoy);
                String gender = boy.isChecked() ? "男生" : "女生";

                // Get selected ticket type and price
                RadioButton adult = findViewById(R.id.rdbAdult);
                RadioButton child = findViewById(R.id.rdbChild);
                RadioButton student = findViewById(R.id.rdbStudent);
                String ticketType;
                int ticketPrice;
                if (adult.isChecked()) {
                    ticketType = "成人";
                    ticketPrice = 500;
                } else if (child.isChecked()) {
                    ticketType = "孩童";
                    ticketPrice = 250;
                } else {
                    ticketType = "學生";
                    ticketPrice = 400;
                }

                // Get quantity
                TextView editTextQuantity = findViewById(R.id.editTextQuantity);
                int quantity = Integer.parseInt(editTextQuantity.getText().toString());

                // Calculate total price
                int totalPrice = ticketPrice * quantity;

                // Create intent for next activity
                Intent intent = new Intent(MainActivity.this, ConfirmationActivity.class);
                intent.putExtra("gender", gender);
                intent.putExtra("ticketType", ticketType);
                intent.putExtra("quantity", quantity);
                intent.putExtra("totalPrice", totalPrice);
                startActivity(intent);
            }
        });
    }
}