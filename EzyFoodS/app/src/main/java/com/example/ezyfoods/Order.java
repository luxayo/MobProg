package com.example.ezyfoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Order extends AppCompatActivity {
    Stock s = new Stock();
    private int d = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Intent intent = getIntent();
        String nama_s = intent.getStringExtra("EXTRA_DRINK_NAMA");
        TextView tv_nama = findViewById(R.id.nama);
        tv_nama.setText(nama_s);
        String harga_s = intent.getStringExtra("EXTRA_DRINK_HARGA");
        TextView tv_harga = findViewById(R.id.harga);
        tv_harga.setText(harga_s);



        if (nama_s.equals("Jus Alpukat")) d = s.getStok_alpukat();
        if (nama_s.equals("Jus Mangga")) d = s.getStok_mangga();
        if (nama_s.equals("Jus Apel")) d = s.getStok_apel();
        if (nama_s.equals("Air Mineral")) d = s.getStok_air();

        String dSTR = Integer.toString(d);

        TextView tv_qty = (TextView) findViewById(R.id.tv_qty);
        tv_qty.setText(dSTR);
    }

    int minteger = 0;
    public void plusClick(View v){
        minteger = minteger + 1;
        display(minteger);
    }

    public void minusClick(View v){
        minteger = minteger - 1;
        display(minteger);
    }

    private void display(int number) {
        EditText displayInteger =findViewById(R.id.et_qty);
        if(number < 0){
            minteger = 0;
            displayInteger.setText("0");
        }
        else if(d < number){
            minteger = d;
            displayInteger.setText("" + d);
        }
        else{
            displayInteger.setText("" + number);
        }

    }

    public void orderMore(View v){
        Intent intent2 = new Intent(this, Drink.class);
        startActivity(intent2);
    }

    public void addcart(View v){
        EditText displayInteger =findViewById(R.id.et_qty);
        int number = Integer.parseInt(displayInteger.getText().toString());
        TextView tv_qty = (TextView) findViewById(R.id.tv_qty);
        TextView tv_qty_temp = (TextView) findViewById(R.id.tv_qty_temp);
        if(d < number){
            tv_qty.setTextColor(this.getResources().getColor(android.R.color.holo_red_light));
            tv_qty_temp.setTextColor(this.getResources().getColor(android.R.color.holo_red_light));
        }
        else{
            tv_qty.setTextColor(this.getResources().getColor(android.R.color.black));
            tv_qty_temp.setTextColor(this.getResources().getColor(android.R.color.black));
            Intent intent = new Intent(this, Cart.class);
            TextView nama =findViewById(R.id.nama);
            EditText qty =findViewById(R.id.et_qty);
            String nama_s = nama.getText().toString();
            String qty_s = qty.getText().toString();
            intent.putExtra("EXTRA_DRINK_NAMA", nama_s);
            intent.putExtra("EXTRA_DRINK_QTY", qty_s);
            startActivity(intent);
        }

    }

    public void gotoCart(View v){
        Intent intent = new Intent(this, Cart.class);
        startActivity(intent);
    }


}