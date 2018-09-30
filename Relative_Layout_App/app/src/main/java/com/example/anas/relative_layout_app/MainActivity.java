package com.example.anas.relative_layout_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Creating Objects of Related Views
    private TextView titleTextView;
    private EditText inputEditText;
    private Button addButton, clearButton, calculatorButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleTextView = findViewById(R.id.title);
        inputEditText = findViewById(R.id.input);
        addButton = findViewById(R.id.add);
        clearButton = findViewById(R.id.clear);
        calculatorButton = findViewById(R.id.calact);


        addButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(inputEditText.getText() != null)
                {
                    titleTextView.setText(inputEditText.getText().toString());
                }
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(inputEditText.getText().toString().trim().length() == 0){

                    if(titleTextView.getText().toString().length() != 0){
                        titleTextView.setText("");
                    }

                    Toast.makeText(MainActivity.this , "No Text To Clear" , Toast.LENGTH_SHORT).show();
                }

                if(titleTextView.getText() != null)
                titleTextView.setText("");

                if(inputEditText.getText() != null)
                    inputEditText.setText("");

            }
        });

        calculatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CalculatorActivity.class));
            }
        });
    }
}
