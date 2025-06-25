package com.example.umrechner;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.umrechner.R;

public class MainActivity extends AppCompatActivity {

    private EditText hexInput;
    private TextView octalOutput;
    private Button convertButton, resetButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hexInput = findViewById(R.id.hexInput);
        octalOutput = findViewById(R.id.octalOutput);
        convertButton = findViewById(R.id.convertButton);
        resetButton = findViewById(R.id.resetButton);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hex = hexInput.getText().toString().trim();
                if (hex.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Bitte eine Hexadezimalzahl eingeben.", Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    int decimal = Integer.parseInt(hex, 16);
                    String octal = Integer.toOctalString(decimal);
                    octalOutput.setText(octal);
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Ungültige Hexadezimalzahl.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hexInput.setText("");
                octalOutput.setText("");
            }
        });
    }
}