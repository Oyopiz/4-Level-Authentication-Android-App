package com.example.firebasefullcourse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity {
TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        textView=findViewById(R.id.balancetxt);
    }

    public void withdraw(View view) {
        int i = Integer.valueOf(textView.getText().toString());
        int bro = i - 5000;
            textView.setText(bro);
    }

    public void Deposit(View view) {
    }

    public void Send(View view) {
    }
}