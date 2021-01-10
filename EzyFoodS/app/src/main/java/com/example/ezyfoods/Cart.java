package com.example.ezyfoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Cart extends AppCompatActivity {

    static int total1 = 0, total2 = 0, total3 = 0, total4 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);



        if(getIntent().getStringExtra("EXTRA_DRINK_NAMA") != null) {
            if (getIntent().getStringExtra("EXTRA_DRINK_NAMA").length() > 1) {
                addData();
            }
        }

        check();
        balcek();
    }

    private void balcek(){
        Balance bal = new Balance();
        TextView baltot = (TextView) findViewById(R.id.bal2);
        String STRtotal = Integer.toString(bal.getTotal());
        baltot.setText(STRtotal);

    }

    private void check(){
        TextView tv_qty1 = findViewById(R.id.tv_qty1);
        TextView tv_qty2 = findViewById(R.id.tv_qty2);
        TextView tv_qty3 = findViewById(R.id.tv_qty3);
        TextView tv_qty4 = findViewById(R.id.tv_qty4);
        LinearLayout drink1 = findViewById(R.id.drink1);
        LinearLayout drink2 = findViewById(R.id.drink2);
        LinearLayout drink3 = findViewById(R.id.drink3);
        LinearLayout drink4 = findViewById(R.id.drink4);
        Button button = findViewById(R.id.button);
        TextView kosong = findViewById(R.id.kosong);
        TextView totalsemua = findViewById(R.id.totalsemua);


        if(total1 == 0){
            drink1.setVisibility(LinearLayout.GONE);
            tv_qty1.setText("Qty : 0");
        }
        else{
            drink1.setVisibility(LinearLayout.VISIBLE);
            tv_qty1.setText("Qty : "+total1);
        }
        if(total2 == 0){
            drink2.setVisibility(LinearLayout.GONE);
            tv_qty2.setText("Qty : 0");
        }
        else{
            drink2.setVisibility(LinearLayout.VISIBLE);
            tv_qty2.setText("Qty : "+total2);
        }
        if(total3 == 0){
            drink3.setVisibility(LinearLayout.GONE);
            tv_qty3.setText("Qty : 0");
        }
        else{
            drink3.setVisibility(LinearLayout.VISIBLE);
            tv_qty3.setText("Qty : "+total3);
        }
        if(total4 == 0){
            drink4.setVisibility(LinearLayout.GONE);
            tv_qty4.setText("Qty : 0");
        }
        else{
            drink4.setVisibility(LinearLayout.VISIBLE);
            tv_qty4.setText("Qty : "+total4);
        }

        if(total1+total2+total3+total4 == 0){
            button.setVisibility(button.GONE);
            kosong.setVisibility(kosong.VISIBLE);
            totalsemua.setVisibility(button.GONE);

        }
        else{
            button.setVisibility(button.VISIBLE);
            kosong.setVisibility(kosong.GONE);
            totalsemua.setVisibility(button.VISIBLE);
            totalsemua();
        }


    }

    public void home(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void totalsemua(){
        int total;
        total = (total1 * 5000) + (total2 * 10000) + (total3 * 12000) + (total4 * 15000);
        TextView totals = findViewById(R.id.totalsemua);
        totals.setText("Rp ." + total + ",-");


    }

    private void addData(){
        Intent intent = getIntent();
        String nama_s = intent.getStringExtra("EXTRA_DRINK_NAMA");
        TextView tv_nama1 = findViewById(R.id.tv_nama1);
        String nama_s1 = (String) tv_nama1.getText();
        TextView tv_nama2 = findViewById(R.id.tv_nama2);
        String nama_s2 = (String) tv_nama2.getText();
        TextView tv_nama3 = findViewById(R.id.tv_nama3);
        String nama_s3 = (String) tv_nama3.getText();
        TextView tv_nama4 = findViewById(R.id.tv_nama4);
        String nama_s4 = (String) tv_nama4.getText();

        int number, plus;



        if(nama_s.equals(nama_s1)){
            String qty_s = intent.getStringExtra("EXTRA_DRINK_QTY");
            TextView tv_qty1 = findViewById(R.id.tv_qty1);
            number = Integer.parseInt(qty_s);
            plus = Integer.parseInt(tv_qty1.getText().toString().replaceAll("[^0-9]",""));
            Log.d("addData: ", "number " + number);
            Log.d("addData: ", "plus" + plus);
            total1 = number + total1;
            String akhir = "Qty : " + Integer.toString(total1);
            tv_qty1.setText(akhir);
        }
        else if(nama_s.equals(nama_s2)){
            String qty_s = intent.getStringExtra("EXTRA_DRINK_QTY");
            TextView tv_qty2 = findViewById(R.id.tv_qty2);
            number = Integer.parseInt(qty_s);
            plus = Integer.parseInt(tv_qty2.getText().toString().replaceAll("[^0-9]",""));
            Log.d("addData: ", "number " + number);
            Log.d("addData: ", "plus" + plus);
            total2 = number + total2;
            String akhir = "Qty : " + Integer.toString(total2);
            tv_qty2.setText(akhir);
        }
        else if(nama_s.equals(nama_s3)){
            String qty_s = intent.getStringExtra("EXTRA_DRINK_QTY");
            TextView tv_qty3 = findViewById(R.id.tv_qty3);
            number = Integer.parseInt(qty_s);
            plus = Integer.parseInt(tv_qty3.getText().toString().replaceAll("[^0-9]",""));
            Log.d("addData: ", "number " + number);
            Log.d("addData: ", "plus" + plus);
            total3 = number + total3;
            String akhir = "Qty : " + Integer.toString(total3);
            tv_qty3.setText(akhir);
        }
        else if(nama_s.equals(nama_s4)){
            String qty_s = intent.getStringExtra("EXTRA_DRINK_QTY");
            TextView tv_qty4 = findViewById(R.id.tv_qty4);
            number = Integer.parseInt(qty_s);
            plus = Integer.parseInt(tv_qty4.getText().toString().replaceAll("[^0-9]",""));
            Log.d("addData: ", "number " + number);
            Log.d("addData: ", "plus" + plus);
            total4 = number + total4;
            String akhir = "Qty : " + Integer.toString(total4);
            tv_qty4.setText(akhir);
        }


    }

    public void delete(View v){
        Log.d("drinkChoice: ", v.getId()+"");

        switch (v.getId()) {
            case R.id.iv_delete1:
                // do something
                total1 = 0;
                TextView tv_qty1 = findViewById(R.id.tv_qty1);
                tv_qty1.setText("Qty : 0");
                break;
            case R.id.iv_delete2:
                // do something else
                total2 = 0;
                TextView tv_qty2 = findViewById(R.id.tv_qty2);
                tv_qty2.setText("Qty : 0");
                break;
            case R.id.iv_delete3:
                // i'm lazy, do nothing
                total3 = 0;
                TextView tv_qty3 = findViewById(R.id.tv_qty3);
                tv_qty3.setText("Qty : 0");
                break;
            case R.id.iv_delete4:
                // i'm lazy, do nothing
                total4 = 0;
                TextView tv_qty4 = findViewById(R.id.tv_qty4);
                tv_qty4.setText("Qty : 0");
                break;
        }

        check();
    }



    public void payNow(View v){
        Intent intent = new Intent(this, Complete.class);

        String total1_s = String.valueOf(total1);
        intent.putExtra("EXTRA_DRINK_DRINK1", total1_s);
        String total2_s = String.valueOf(total2);
        intent.putExtra("EXTRA_DRINK_DRINK2", total2_s);
        String total3_s = String.valueOf(total3);
        intent.putExtra("EXTRA_DRINK_DRINK3", total3_s);
        String total4_s = String.valueOf(total4);
        intent.putExtra("EXTRA_DRINK_DRINK4", total4_s);

        TextView max = (TextView) findViewById(R.id.bal2);
        TextView tv7 = (TextView) findViewById(R.id.textView7);

        int totalsemua = (total1*5000)+(total2*10000)+(total3*12000)+(total4*15000);
        Balance bal = new Balance();
        Stock s = new Stock();
        if(bal.getTotal() - totalsemua < 0){
            max.setTextColor(this.getResources().getColor(android.R.color.holo_red_light));
            tv7.setTextColor(this.getResources().getColor(android.R.color.holo_red_light));
        }
        else{
            max.setTextColor(this.getResources().getColor(android.R.color.black));
            tv7.setTextColor(this.getResources().getColor(android.R.color.black));

            s.setStok_air(s.getStok_air() - total1);
            s.setStok_apel(s.getStok_apel() - total2);
            s.setStok_mangga(s.getStok_mangga() - total3);
            s.setStok_alpukat(s.getStok_alpukat() - total4);
            startActivity(intent);
            total1 = 0;
            total2 = 0;
            total3 = 0;
            total4 = 0;
            finish();
        }

    }

    public void orderMore(View v){
        Intent intent2 = new Intent(this, Drink.class);
        startActivity(intent2);
    }
}