package com.example.ezyfoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Balance bal = new Balance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();





        if(intent.hasExtra("EXTRA_NUMBER")){
                int total = bal.getTotal();
                String topup = getIntent().getStringExtra("EXTRA_NUMBER");

                int tot1 = Integer.parseInt(topup);
                total = total + tot1 ;
                Log.d("number: ", "da topup " + total);
                String STRtotal = Integer.toString(total);

                TextView baltot = (TextView) findViewById(R.id.baltotal);
                baltot.setText(STRtotal);
                bal.setTotal(total);
        }
        else{

            int total = bal.getTotal();
            String STRtotal = Integer.toString(total);
            TextView baltot = (TextView) findViewById(R.id.baltotal);
            baltot.setText(STRtotal);
        }

    }

    public void drinkClick(View v){
        Intent intent = new Intent(this, Drink.class);

        startActivity(intent);

    }

    public void gotoCart(View v){
        Intent intent = new Intent(this, Cart.class);
        intent.putExtra("EXTRA_BAL", bal.getTotal());
        startActivity(intent);
    }

    public void gotoMaps(View v){
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

    public void gotoTopUp(View v){
        Intent intent = new Intent(this, TopUp.class);
        startActivity(intent);
    }
}