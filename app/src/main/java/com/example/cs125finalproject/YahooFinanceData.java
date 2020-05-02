package com.example.cs125finalproject;
import yahoofinance.YahooFinance;
import yahoofinance.Stock;
import java.io.IOException;
import java.math.BigDecimal;
import android.app.AlertDialog;
public class YahooFinanceData {


    /**
     * @param ticker the ticker for the stock the user wants to add to their watchlist
     */
    public String[] addToList(String ticker, String[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                count++;
            }
        }
        if (count == 10) {
            return arr;
        } else {
            arr[count] = ticker;
        }
        return arr;
    }

    public String[] removeFromList(String ticker, String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ticker) {
                arr[i] = null;
            }
        }
        return arr;
    }

    public boolean isPriceWithinRange(Stock ticker, BigDecimal low, BigDecimal high) {
        BigDecimal currentPrice = ticker.getQuote().getPrice();
        if (currentPrice.compareTo(low) < 0 || currentPrice.compareTo(high) > 0) {
            return false;
        } else return true;
    }
}
















