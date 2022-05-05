package com.example.activity2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class ThirdActivity extends AppCompatActivity {
    private List<Button> buttons;
    private Intent intent;
    private EditText send_text;
    private TextView viewAct2msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        viewAct2msg = findViewById(R.id.displayMSG);

        Intent intent = getIntent();
        String str = intent.getStringExtra("message_key");
        viewAct2msg.setText(str);

    }
}