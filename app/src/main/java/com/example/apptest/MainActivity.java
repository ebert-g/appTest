package com.example.apptest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText etNameForm = findViewById(R.id.etNameForm);
        EditText etEmailForm = findViewById(R.id.etEmailForm);
        EditText etPasswordForm = findViewById(R.id.etPasswordForm);
        Button btnLoginForm = findViewById(R.id.btnLogin);

        btnLoginForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etNameForm.getText().toString().trim();
                String email = etEmailForm.getText().toString().trim();
                String password = etPasswordForm.getText().toString().trim();
                if (name.isEmpty()) {
                    etNameForm.setError("Name is Required");

                } else if (email.isEmpty()) {
                    etEmailForm.setError("Email is Required");

                } else if (password.isEmpty()) {
                    etPasswordForm.setError("Password is Required");

                }

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("NAME_FORM", name);
                intent.putExtra("EMAIL_FORM", email);
                startActivity(intent);


            }
        });


    }
}