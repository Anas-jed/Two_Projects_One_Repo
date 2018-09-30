package com.example.anas.assigment_q3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    //fields
    private EditText editEmailText , editPasswordText;
    private Button LoginButton, RegisterButton;

    //email validation function
    public boolean EmailValidator(String input)
    {
        String EmailRegex="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern emailpattern = Pattern.compile(EmailRegex,Pattern.CASE_INSENSITIVE);
        Matcher matcher = emailpattern.matcher(input);
        return matcher.find();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //fields references from xml
        editEmailText = findViewById(R.id.edittextemail);
        editPasswordText = findViewById(R.id.edittextpass);
        LoginButton = findViewById(R.id.loginbutton);
        RegisterButton = findViewById(R.id.regbutton);

        //listener on button
        LoginButton.setOnClickListener(new View.OnClickListener() {
            boolean check;

            @Override
            public void onClick(View v) {

                check=false;    //specially made for email validation and to run after values if email format is correct

                //if validation for all fields
                if(editEmailText.getText().toString().trim().length() == 0 || editPasswordText.getText().toString().trim().length() == 0)
                {
                    Toast.makeText(LoginActivity.this,"All Fields must be filled", Toast.LENGTH_SHORT).show();
                }

                //validation for email
                else if(editEmailText.getText().toString().trim().length() != 0)
                {
                    boolean tf=EmailValidator(editEmailText.getText().toString());
                    if(!tf)
                        Toast.makeText(LoginActivity.this,"Email Format is not Correct",Toast.LENGTH_SHORT).show();
                    else
                        check=true;
                }

                //special validation with boolean check to continue if email format is correct
                if(check){
                if (editPasswordText.getText().toString().trim().length() <6) //validation of password
                {
                    Toast.makeText(LoginActivity.this, "Password must greater than 5 digits", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(LoginActivity.this, "Login Button is Pressed", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this,HomeActivity.class));
                }
                }
            }
        });

        //listener on button
        RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
    }
}
