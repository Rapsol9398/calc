package com.example.umrechner;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText octalInput;
    private TextView hexOutput;
    private Button convertButton, resetButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        octalInput = findViewById(R.id.octalInput);
        hexOutput = findViewById(R.id.hexOutput);
        convertButton = findViewById(R.id.convertButton);
        resetButton = findViewById(R.id.resetButton);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String octal = octalInput.getText().toString().trim();
                if (octal.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Bitte eine Oktalzahl eingeben.", Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    int decimal = Integer.parseInt(octal, 8);
                    String hex = Integer.toHexString(decimal).toUpperCase();
                    hexOutput.setText(hex);
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Ungültige Oktalzahl.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                octalInput.setText("");
                hexOutput.setText("");
            }
        });
    }
}