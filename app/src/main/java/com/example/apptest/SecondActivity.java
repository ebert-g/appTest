package com.example.apptest;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView tvName = findViewById(R.id.tvName);
        TextView tvAge = findViewById(R.id.tvAge);

        Button btnBack = findViewById(R.id.btnBack);

        String name = getIntent().getStringExtra("USER_NAME");
        String age = getIntent().getStringExtra("USER_AGE");

        if (name != null && age != null) {
            tvName.setText("Name: " + name);
            tvName.setTypeface(null, Typeface.BOLD);

            tvAge.setText("Age: " + age);
            tvAge.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 24);
        }

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}