package com.example.myapp;

import static com.example.myapp.R.id.txt3;

import android.graphics.Color;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button buttonB,buttons;
    EditText ed1,ed2;

    TextView txt3;
    int counter = 3;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonB = (Button)findViewById(R.id.buttonB);
        ed1 = (EditText)findViewById(R.id.ed1);
        ed2 = (EditText)findViewById(R.id.ed2);

        buttons = (Button)findViewById(R.id.buttons);
        txt3 = (TextView)findViewById(R.id.txt3);
        txt3.setVisibility(View.GONE);

        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ed1.getText().toString().equals("M.R.SIVARAM") &&
                        ed2.getText().toString().equals("@60/1")) {
                    Toast.makeText(getApplicationContext(),
                            "Logged in successfully...",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this,MA2.class));
                }else{
                    Object Credentials;
                    Toast.makeText(getApplicationContext(), "LOGIN FAILED...",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this,MA3.class));

                            txt3.setVisibility(View.VISIBLE);
                    txt3.setBackgroundColor(Color.RED);
                    counter--;
                    txt3.setText(Integer.toString(counter));

                    if (counter == 0) {
                        buttonB.setEnabled(false);
                    }
                }
            }
        });

        buttons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}