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
import yahoofinance.Stock;


public class WatchList extends AppCompatActivity {
    Button backBtn = findViewById(R.id.Back);
    Button removeBtn = findViewById(R.id.remove);

    String[] WatchListArr = new String[10];
    YahooFinanceData YahooFinanceData = new YahooFinanceData();
    String removeStockstr = removeStock.getText().toString();
    Intent back = new Intent(this, MainActivity.class);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent mainActivityIntent = getIntent();
        WatchListArr = mainActivityIntent.getStringArrayExtra("WatchListArray");
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        TextView stock1 = findViewById(R.id.textView19);
        TextView stock2 = findViewById(R.id.textView18);
        TextView stock3 = findViewById(R.id.textView17);
        TextView stock4 = findViewById(R.id.textView16);
        TextView stock5 = findViewById(R.id.textView15);
        TextView stock6 = findViewById(R.id.textView14);
        TextView stock7 = findViewById(R.id.textView13);
        TextView stock8 = findViewById(R.id.textView12);
        TextView stock9 = findViewById(R.id.textView11);
        TextView stock10 = findViewById(R.id.textView17);
        TextView removeStock = findViewById(R.id.textView21);
    }

        protected void setWatchList() {
            for (int i = 0; i < WatchListArr.length; i++) {
                if (WatchListArr[i] != null) {
                    if (i == 0) {
                        stock1.setText(WatchListArr[i]);
                    }
                    if (i == 1) {
                        stock2.setText(WatchListArr[i]);
                    }
                    if (i == 2) {
                        stock3.setText(WatchListArr[i]);
                    }
                    if (i == 3) {
                        stock4.setText(WatchListArr[i]);
                    }
                    if (i == 4) {
                        stock5.setText(WatchListArr[i]);
                    }
                    if (i == 5) {
                        stock6.setText(WatchListArr[i]);
                    }
                    if (i == 6) {
                        stock7.setText(WatchListArr[i]);
                    }
                    if (i == 7) {
                        stock8.setText(WatchListArr[i]);
                    }
                    if (i == 8) {
                        stock9.setText(WatchListArr[i]);
                    }
                    if (i == 9) {
                        stock10.setText(WatchListArr[i]);
                    }
                } else {
                    if (i == 0) {
                        stock1.setText("No Stock Selected");
                    }
                    if (i == 1) {
                        stock2.setText("No Stock Selected");
                    }
                    if (i == 2) {
                        stock3.setText("No Stock Selected");
                    }
                    if (i == 3) {
                        stock4.setText("No Stock Selected");
                    }
                    if (i == 4) {
                        stock5.setText("No Stock Selected");
                    }
                    if (i == 5) {
                        stock6.setText("No Stock Selected");
                    }
                    if (i == 6) {
                        stock7.setText("No Stock Selected");
                    }
                    if (i == 7) {
                        stock8.setText("No Stock Selected");
                    }
                    if (i == 8) {
                        stock9.setText("No Stock Selected");
                    }
                    if (i == 9) {
                        stock10.setText("No Stock Selected");
                    }
                }
            }
        }
    protected void RemoveStock() {
        removeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YahooFinanceData.removeFromList(removeStockstr, WatchListArr);
                setWatchList();

            }
        });

    }
    protected void setBackBtn() {
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(back);
                back.putExtra("WatchListArr", WatchListArr);
                finish();
            }
        });
    }
}






