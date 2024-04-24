package com.example.accountpassword;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 正確的帳號和密碼
    private static final String CORRECT_USERNAME = "A111221070";
    private static final String CORRECT_PASSWORD = "001070";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editTextUsername = findViewById(R.id.editTextUsername);
        final EditText editTextPassword = findViewById(R.id.editTextPassword);
        Button buttonLogin = findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 獲取輸入的帳號和密碼
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();

                // 檢查帳號和密碼是否正確
                if (username.equals(CORRECT_USERNAME) && password.equals(CORRECT_PASSWORD)) {
                    // 登入成功
                    Toast.makeText(MainActivity.this, "登入成功", Toast.LENGTH_SHORT).show();
                } else {
                    // 帳號或密碼錯誤
                    Toast.makeText(MainActivity.this, "帳號或密碼錯誤", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}