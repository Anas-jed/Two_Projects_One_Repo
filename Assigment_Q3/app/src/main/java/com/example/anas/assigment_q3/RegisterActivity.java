package com.example.anas.assigment_q3;

import android.content.Intent;
import android.os.PatternMatcher;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    //fields
    private EditText firstNameText, lastNameText, passwordText, cpasswordText, emailText;
    private Button homeActButton;
    boolean check;

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
        setContentView(R.layout.activity_register);

        //fields references from xml
        firstNameText = findViewById(R.id.fname);
        lastNameText = findViewById(R.id.lname);
        emailText = findViewById(R.id.email);
        passwordText = findViewById(R.id.pass);
        cpasswordText = findViewById(R.id.cpass);
        homeActButton = findViewById(R.id.regtohomeact);

        //listener on button
        homeActButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                check = false; //specially made for email validation and to run after values if email format is correct

                //if validation for all fields
                if(firstNameText.getText().toString().trim().length() == 0 ||
                        lastNameText.getText().toString().trim().length() == 0 ||
                        emailText.getText().toString().trim().length() == 0 ||
                        passwordText.getText().toString().trim().length() == 0 ||
                        cpasswordText.getText().toString().trim().length() == 0 )
                {
                    Toast.makeText(RegisterActivity.this,"All Fields Must Be Filled",Toast.LENGTH_SHORT).show();
                }
                //else if validation for name error of less than 3 and greater than 15 characters
                else if((firstNameText.getText().toString().trim().length() < 3) || (firstNameText.getText().toString().trim().length() > 15)
                || (lastNameText.getText().toString().trim().length() < 3) || (lastNameText.getText().toString().trim().length() > 15))
                {
                    Toast.makeText(RegisterActivity.this,"Characters mustbe greaterthan 3 and lessthan 15",Toast.LENGTH_SHORT).show();
                }

                //validation for email
                else if(emailText.getText().toString().trim().length() != 0)
                {
                    boolean tf=EmailValidator(emailText.getText().toString());
                    if(!tf)
                    Toast.makeText(RegisterActivity.this,"Email Format is not Correct",Toast.LENGTH_SHORT).show();
                    else
                        check=true;
                }

                //special validation with boolean check to continue if email format is correct
                if(check)
                {
                    if(passwordText.getText().toString().equals(cpasswordText.getText().toString()))
                    {
                        startActivity( new Intent(RegisterActivity.this,HomeActivity.class));
                     }
                 else
                    {
                        Toast.makeText(RegisterActivity.this,"Password fields must be same",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
