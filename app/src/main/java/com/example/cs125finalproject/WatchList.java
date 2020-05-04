package com.example.cs125finalproject;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;
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
    TextView[] txtViewarr = new TextView[10];
    @Override
    public void onSaveInstanceState(Bundle outState) {
        // Save UI state changes to the savedInstanceState.
        // This bundle will be passed to onCreate if the process is
        // killed and restarted.
        super.onSaveInstanceState(outState);
        outState.putStringArrayList("WatchListArr", WatchListArr);




    }
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.
        WatchListArr = savedInstanceState.getStringArrayList("WatchListArr");


    }




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

        /*for (int i = 0; i < WatchListArr.length; i++) {
            if (WatchListArr[i] == null) {
                WatchListArr[i] = Stock;
                break;
            }
        }*/
        for (int i = 0; i < WatchListArr.size(); i++) {
            txtViewarr[i].setFreezesText(true);
            txtViewarr[i].setText(WatchListArr.get(i));
        }

//        txtViewarr[0].setText(WatchListArr[0]);
//        txtViewarr[1].setText(WatchListArr[1]);
//        txtViewarr[2].setText(WatchListArr[2]);
//        txtViewarr[3].setText(WatchListArr[3]);
//        txtViewarr[4].setText(WatchListArr[4]);
//        txtViewarr[5].setText(WatchListArr[5]);
//        txtViewarr[6].setText(WatchListArr[6]);
//        txtViewarr[7].setText(WatchListArr[7]);
//        txtViewarr[8].setText(WatchListArr[8]);
//        txtViewarr[9].setText(WatchListArr[9]);



    }
        /*YahooFinanceData.addToList(Stock, WatchListArr);
        for (int i = 0; i < WatchListArr.length; i++) {
            if (WatchListArr[i] == null) {
                txtViewarr[i].setText("Empty");
            } else {
                String setPrice = getStockPrice();
                String setText = "TICKER: " + WatchListArr[i] + " " + "PRICE: " + setPrice;
                txtViewarr[i].setText(setText);
            }
        }
    }
        /*if (WatchListArr != null) {
            final int length = WatchListArr.length;
            String setPrice = getStockPrice();
            for (int i = 0; i < length; i++) {
                if (WatchListArr[i] != null) {
                    String setText = "TICKER: " + WatchListArr[i] + " " + "PRICE: " + setPrice;
                    txtViewarr[i].setFreezesText(true);
                    txtViewarr[i].setText(setText);
                }
                if (WatchListArr[i] == null) {
                    WatchListArr[i] = Stock;

                    txtViewarr[i].setFreezesText(true);
                    txtViewarr[i].setText(setText);
                    break;
                }
            }
        }*/





    protected void removeFromWatchList() {
        for (int i = 0; i < txtViewarr.length; i++) {
            if (txtViewarr[i].getText().toString().equals(removeStockstr)) {
                txtViewarr[i].setText("empty");
            }
        }

    }

    protected String getStockPrice() {
        try {
            Stock stock = YahooFinance.get(Stock);
            String price = stock.getQuote(true).getPrice().toString();
            return price;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Invalid Ticker";
    }

}






