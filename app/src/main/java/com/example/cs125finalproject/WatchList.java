package com.example.cs125finalproject;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;
import android.widget.ListView;
import android.content.Intent;
import java.math.BigDecimal;
import java.io.IOException;
import java.util.ArrayList;

import yahoofinance.YahooFinance;
import yahoofinance.Stock;
import android.os.StrictMode;


public class WatchList extends AppCompatActivity {
    private TextView stock1;
    private TextView stock2;
    private TextView stock3;
    private TextView stock4;
    private TextView stock5;
    private TextView stock6;
    private TextView stock7;
    private TextView stock8;
    private TextView stock9;
    private TextView stock10;
    private TextView removeStock;
    Button backBtn;
    Button removeBtn;
    ArrayList<String> WatchListArr = new ArrayList<>();
    YahooFinanceData YahooFinanceData = new YahooFinanceData();
    String removeStockstr;
    String Stock;
    String lowRange;
    String highRange;
    int high;
    int low;

    TextView[] txtViewarr = new TextView[10];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Intent mainActivityIntent = getIntent();
        Stock = mainActivityIntent.getStringExtra("Stock");
        WatchListArr = mainActivityIntent.getStringArrayListExtra("WatchListArr");
        highRange = mainActivityIntent.getStringExtra("high");
        lowRange = mainActivityIntent.getStringExtra("low");
        stock1 = findViewById(R.id.textView19);
        stock2 = findViewById(R.id.textView18);
        stock3 = findViewById(R.id.textView17);
        stock4 = findViewById(R.id.textView16);
        stock5 = findViewById(R.id.textView15);
        stock6 = findViewById(R.id.textView14);
        stock7 = findViewById(R.id.textView13);
        stock8 = findViewById(R.id.textView12);
        stock9 = findViewById(R.id.textView11);
        stock10 = findViewById(R.id.textView7);
        removeStock = findViewById(R.id.editText);
        backBtn = findViewById(R.id.Back);
        removeBtn = findViewById(R.id.remove);
        removeStockstr = removeStock.getText().toString();
        txtViewarr[0] = stock1;
        txtViewarr[1] = stock2;
        txtViewarr[2] = stock3;
        txtViewarr[3] = stock4;
        txtViewarr[4] = stock5;
        txtViewarr[5] = stock6;
        txtViewarr[6] = stock7;
        txtViewarr[7] = stock8;
        txtViewarr[8] = stock9;
        txtViewarr[9] = stock10;
        setWatchList();

        removeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*YahooFinanceData.removeFromList(removeStockstr, WatchListArr);
                //removeFromWatchList();*/
                finish();


            }
        });
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(WatchList.this, MainActivity.class);

                startActivity(back);
            }
        });
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    protected void setWatchList() {
        String price;
        for (int i = 0; i < WatchListArr.size(); i++) {
            try {


                Stock stock = YahooFinance.get(WatchListArr.get(i));
                price = stock.getQuote(true).getPrice().toString();
//
                String setText = "TICKER: " + WatchListArr.get(i) + " " + "PRICE: " + price + " YOUR RANGE IS: " + lowRange + " - " + highRange;
                txtViewarr[i].setText(setText);


            } catch (IOException e) {
                e.printStackTrace();
                String bad = "Invalid Ticker";
                txtViewarr[i].setText(bad);
            }
        }


    }


    protected void removeFromWatchList() {
        for (int i = 0; i < txtViewarr.length; i++) {
            if (txtViewarr[i].getText().toString().equals(removeStockstr)) {
                txtViewarr[i].setText("empty");
            }
        }

    }
}








