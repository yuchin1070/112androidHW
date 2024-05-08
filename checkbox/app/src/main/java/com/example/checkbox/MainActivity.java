package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CheckBox chk1, chk2, chk3, chk4;
    private ImageView output1, output2, output3, output4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chk1 = findViewById(R.id.chk1);
        chk2 = findViewById(R.id.chk2);
        chk3 = findViewById(R.id.chk3);
        chk4 = findViewById(R.id.chk4);

        output1 = findViewById(R.id.output1);
        output2 = findViewById(R.id.output2);
        output3 = findViewById(R.id.output3);
        output4 = findViewById(R.id.output4);
    }

    public void placeOrder(View view) {
        StringBuilder orderSummary = new StringBuilder("Your order:");

        if (chk1.isChecked()) {
            orderSummary.append("\n漢堡");
            output1.setImageResource(R.drawable.burger);
        } else {
            output1.setImageResource(android.R.color.transparent);
        }

        if (chk2.isChecked()) {
            orderSummary.append("\n咖啡");
            output2.setImageResource(R.drawable.coffee);
        } else {
            output2.setImageResource(android.R.color.transparent);
        }

        if (chk3.isChecked()) {
            orderSummary.append("\n薯條");
            output3.setImageResource(R.drawable.frenchfry);
        } else {
            output3.setImageResource(android.R.color.transparent);
        }

        if (chk4.isChecked()) {
            orderSummary.append("\n飲料");
            output4.setImageResource(R.drawable.softdrink);
        } else {
            output4.setImageResource(android.R.color.transparent);
        }

        Toast.makeText(this, orderSummary.toString(), Toast.LENGTH_SHORT).show();
    }
}