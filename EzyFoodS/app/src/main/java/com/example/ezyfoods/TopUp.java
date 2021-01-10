package com.example.ezyfoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.graphics.Color;

public class TopUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_up);

        Balance bal = new Balance();
        TextView balance = (TextView) findViewById(R.id.bal);
        String temp = Integer.toString(bal.getTotal());
        balance.setText(temp);

    }
    public void home(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void numberCheck(View v){
        Intent intent = new Intent(this, MainActivity.class);
        EditText et = (EditText) findViewById(R.id.editTextNumberSigned);
        TextView max = (TextView) findViewById(R.id.textView_max);


        if(et.getText().toString().matches("")){
            max.setTextColor(this.getResources().getColor(android.R.color.holo_red_light));
        }
        else{
            String numb = et.getText().toString();
            int number = Integer.parseInt(numb);
            if(number > 2000000 || number < 10000){
                max.setTextColor(this.getResources().getColor(android.R.color.holo_red_light));
            }
            else {
                max.setTextColor(this.getResources().getColor(android.R.color.black));
                intent.putExtra("EXTRA_NUMBER", numb);
                startActivity(intent);
            }
        }

    }
}