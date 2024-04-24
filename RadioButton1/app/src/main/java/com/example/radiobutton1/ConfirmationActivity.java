package com.example.radiobutton1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ConfirmationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        // 從 Intent 中取得資料
        Intent intent = getIntent();
        String gender = intent.getStringExtra("gender");
        String ticketType = intent.getStringExtra("ticketType");
        int quantity = intent.getIntExtra("quantity", 0);
        int totalPrice = intent.getIntExtra("totalPrice", 0);

        // 找到佈局中的 TextView
        TextView textViewGender = findViewById(R.id.textViewGender);
        TextView textViewTicketType = findViewById(R.id.textViewTicketType);
        TextView textViewQuantity = findViewById(R.id.textViewQuantity);
        TextView textViewTotalPrice = findViewById(R.id.textViewTotalPrice);

        // 將資料設置到 TextView 上
        textViewGender.setText("性別: " + gender);
        textViewTicketType.setText("票種: " + ticketType);
        textViewQuantity.setText("購買張數: " + quantity);
        textViewTotalPrice.setText("總金額: $" + totalPrice);
    }
}