package com.example.ezyfoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Drink extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);
        Stock s = new Stock();
        int d1 = s.getStok_air();
        int d2 = s.getStok_apel();
        int d3 = s.getStok_mangga();
        int d4 = s.getStok_alpukat();

        String d1STR = Integer.toString(d1);
        String d2STR = Integer.toString(d2);
        String d3STR = Integer.toString(d3);
        String d4STR = Integer.toString(d4);

        TextView tv_qty1 = (TextView) findViewById(R.id.tv_qty1);
        tv_qty1.setText(d1STR);

        TextView tv_qty2 = (TextView) findViewById(R.id.tv_qty2);
        tv_qty2.setText(d2STR);

        TextView tv_qty3 = (TextView) findViewById(R.id.tv_qty3);
        tv_qty3.setText(d3STR);

        TextView tv_qty4 = (TextView) findViewById(R.id.tv_qty4);
        tv_qty4.setText(d4STR);
    }

    public void drinkChoice(View v){
        Intent intent = new Intent(this, Order.class);
        Log.d("drinkChoice: ", v.getId()+"");

        switch (v.getId()) {
            case R.id.drink1:
                // do something
                TextView nama =findViewById(R.id.tv_nama1);
                TextView harga =findViewById(R.id.tv_harga1);
                String nama_s = nama.getText().toString();
                String harga_s = harga.getText().toString();
                intent.putExtra("EXTRA_DRINK_NAMA", nama_s);
                intent.putExtra("EXTRA_DRINK_HARGA", harga_s);
                break;
            case R.id.drink2:
                // do something else
                TextView nama2 = findViewById(R.id.tv_nama2);
                TextView harga2 = findViewById(R.id.tv_harga2);
                String nama_s2 = nama2.getText().toString();
                String harga_s2 = harga2.getText().toString();
                intent.putExtra("EXTRA_DRINK_NAMA", nama_s2);
                intent.putExtra("EXTRA_DRINK_HARGA", harga_s2);
                break;
            case R.id.drink3:
                // i'm lazy, do nothing
                TextView nama3 = findViewById(R.id.tv_nama3);
                TextView harga3 = findViewById(R.id.tv_harga3);
                String nama_s3 = nama3.getText().toString();
                String harga_s3 = harga3.getText().toString();
                intent.putExtra("EXTRA_DRINK_NAMA", nama_s3);
                intent.putExtra("EXTRA_DRINK_HARGA", harga_s3);
                break;
            case R.id.drink4:
                // i'm lazy, do nothing
                TextView nama4 = findViewById(R.id.tv_nama4);
                TextView harga4 = findViewById(R.id.tv_harga4);
                String nama_s4 = nama4.getText().toString();
                String harga_s4 = harga4.getText().toString();
                intent.putExtra("EXTRA_DRINK_NAMA", nama_s4);
                intent.putExtra("EXTRA_DRINK_HARGA", harga_s4);
                break;
        }
        startActivity(intent);
    }

    public void gotoCart(View v){
        Intent intent = new Intent(this, Cart.class);
        startActivity(intent);
    }

    public void home(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}