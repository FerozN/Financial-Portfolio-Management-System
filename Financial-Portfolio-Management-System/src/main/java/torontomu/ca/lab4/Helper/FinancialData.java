/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torontomu.ca.lab4.Helper;

/**
 *
 * @author student
 */
public class FinancialData {
    private double volume;
    private double price;
    private String symbol;
    private boolean watchlist;
            
    public FinancialData(double volume, double price, String symbol,boolean watchlist){
        this.price = price;
        this.volume = volume;
        this.symbol = symbol;
        this.watchlist = watchlist;
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public double getVolume(){
        return price;
    }
    public void setVolume(double volume){
        this.volume = volume;
    }
    public String getSymbol(){
        return symbol;
    }
    public void setSymbol(String symbol){
        this.symbol = symbol;
    }
    public boolean getWatchlist(){
        return watchlist;
    }
    public void setWatchlist(boolean watchlist){
        this.watchlist = watchlist;
    }
}