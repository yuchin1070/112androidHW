package com.example.radiobutton2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.example.radiobutton2.ConfirmationActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                } else {
                    ticketType = "學生票";
                    totalPrice = 400;
                }

                EditText quantityEditText = findViewById(R.id.etQuantity);
                if (!quantityEditText.getText().toString().isEmpty()) {
                    quantity = Integer.parseInt(quantityEditText.getText().toString());
                    totalPrice *= quantity;
                }

                // 创建一个Intent对象
                Intent intent = new Intent(MainActivity.this, ConfirmationActivity.class);

                // 将数据添加到Intent中
                intent.putExtra("gender", gender);
                intent.putExtra("ticketType", ticketType);
                intent.putExtra("quantity", quantity);
                intent.putExtra("totalPrice", totalPrice);

                // 启动ConfirmationActivity并传递Intent
                startActivity(intent);
            }
        });
    }
}