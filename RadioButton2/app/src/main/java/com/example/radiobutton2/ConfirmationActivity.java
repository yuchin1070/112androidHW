package com.example.radiobutton2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ConfirmationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        // 从 Intent 中获取数据
        Intent intent = getIntent();
        String gender = intent.getStringExtra("gender");
        String ticketType = intent.getStringExtra("ticketType");
        int quantity = intent.getIntExtra("quantity", 0);
        double totalPrice = intent.getDoubleExtra("totalPrice", 0);

        // 找到布局中的 TextView
        TextView textViewGender = findViewById(R.id.textViewGender);
        TextView textViewTicketType = findViewById(R.id.textViewTicketType);
        TextView textViewQuantity = findViewById(R.id.textViewQuantity);
        TextView textViewTotalPrice = findViewById(R.id.textViewTotalPrice);

        // 将数据设置到 TextView 上
        textViewGender.setText("性別: " + gender);
        textViewTicketType.setText("票種: " + ticketType);
        textViewQuantity.setText("購買張數: " + quantity);
        textViewTotalPrice.setText("總金額: $" + totalPrice);
    }
}