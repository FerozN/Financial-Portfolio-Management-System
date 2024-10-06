package torontomu.ca.lab4.Helper;



public class WatchlistItem {
    private int portfolioID;
    private double price;
    private String name;

    
    public WatchlistItem(double price,String name) {
        this.price = price;
        this.name = name;
    }

    
    public int getPortfolioID() {
        return portfolioID;
    }

    public void setPortfolioID(int portfolioID) {
        this.portfolioID = portfolioID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }    
}
