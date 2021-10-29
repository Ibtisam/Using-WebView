package com.example.usingwebview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class ActivityForJavaScript extends AppCompatActivity {
    private EditText et_1, et_2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_java_script);

        et_1 = findViewById(R.id.editText);
        et_2 = findViewById(R.id.editText2);

        Intent data = getIntent();
        et_1.setText(data.getStringExtra("FNAME"));
        et_2.setText(data.getStringExtra("LNAME"));
    }
}
