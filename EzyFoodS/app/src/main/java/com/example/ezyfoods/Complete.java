package com.example.ezyfoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Complete extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete);
        String test1 = getIntent().getStringExtra("EXTRA_DRINK_DRINK1");
        int total1 = Integer.parseInt(test1);
        Log.d("onCreate: ","total1 " +total1);
        int total2 = Integer.parseInt(getIntent().getStringExtra("EXTRA_DRINK_DRINK2"));
        Log.d("onCreate: ","total2 " +total2);
        int total3 = Integer.parseInt(getIntent().getStringExtra("EXTRA_DRINK_DRINK3"));
        Log.d("onCreate: ","total3 " +total3);
        int total4 = Integer.parseInt(getIntent().getStringExtra("EXTRA_DRINK_DRINK4"));
        Log.d("onCreate: ","total4 " +total4);

        int total;
        total = (total1 * 5000) + (total2 * 10000) + (total3 * 12000) + (total4 * 15000);
        TextView totals = findViewById(R.id.totalsemua2);
        totals.setText("Rp ." + total + ",-");

        if(total1 < 1) {
            LinearLayout drink1 = findViewById(R.id.drink1);
            drink1.setVisibility(LinearLayout.GONE);
        }
        else{
            TextView tv_qty1 = findViewById(R.id.tv_qty1);
            String akhir = "Qty : " + Integer.toString(total1);
            tv_qty1.setText(akhir);
        }
        if(total2 < 1) {
            LinearLayout drink2 = findViewById(R.id.drink2);
            drink2.setVisibility(LinearLayout.GONE);
        }
        else{
            TextView tv_qty2 = findViewById(R.id.tv_qty2);
            String akhir = "Qty : " + Integer.toString(total2);
            tv_qty2.setText(akhir);
        }
        if(total3< 1) {
            LinearLayout drink3 = findViewById(R.id.drink3);
            drink3.setVisibility(LinearLayout.GONE);
        }
        else{
            TextView tv_qty3 = findViewById(R.id.tv_qty3);
            String akhir = "Qty : " + Integer.toString(total3);
            tv_qty3.setText(akhir);
        }
        if(total4 < 1) {
            LinearLayout drink4 = findViewById(R.id.drink4);
            drink4.setVisibility(LinearLayout.GONE);
        }
        else{
            TextView tv_qty4 = findViewById(R.id.tv_qty4);
            String akhir = "Qty : " + Integer.toString(total4);
            tv_qty4.setText(akhir);
        }

        balcek(total);
    }

    private void balcek(int total){
        Balance bal = new Balance();
        TextView baltot = (TextView) findViewById(R.id.bal3);

        int temp = bal.getTotal();
        temp -= total;
        String STRtotal = Integer.toString(temp);
        baltot.setText(STRtotal);
        bal.setTotal(temp);

    }

    public void home(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}