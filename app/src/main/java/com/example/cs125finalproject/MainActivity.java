package com.example.cs125finalproject;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
public class MainActivity extends AppCompatActivity {
    /**
     * WatchList array of stock to watch
     */

    YahooFinanceData Add = new YahooFinanceData();
    EditText lowRange;
    Button btnToWatchList;
    EditText stonk;
    Intent watchList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Intent watchList = new Intent(MainActivity.this, WatchList.class);
        EditText lowRange = findViewById(R.id.LowRange);
        EditText highRange = findViewById(R.id.HighRange);
        Button btnToWatchList = findViewById(R.id.GoToWatchList);
        btnToWatchList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(watchList);
                finish();
            }
        });

        findViewById(R.id.Confirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stonk = findViewById(R.id.Stonk);
                String stock = stonk.getText().toString();
                watchList.putExtra("Stock", stock);

            }
        });
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    /*EditText lowRange = findViewById(R.id.LowRange);
    EditText highRange = findViewById(R.id.HighRange);
    String stonk = findViewById(R.id.Stonk).toString();
    Button btnToWatchList = findViewById(R.id.GoToWatchList);
    Intent watchList = new Intent(this, WatchList.class);*/








    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }


        return super.onOptionsItemSelected(item);
    }
}
