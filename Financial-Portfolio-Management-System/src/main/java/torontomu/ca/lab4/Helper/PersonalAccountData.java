package torontomu.ca.lab4.Helper;

public class PersonalAccountData {
    private String accountPortfolio;
    private String portfolioType;
    private String primaryUser;
    private double availableFunds;
    private double totalBalance;
    private double allTimeReturn;

    public PersonalAccountData(String accountPortfolio, String portfolioType, String primaryUser, double availableFunds, double totalBalance, double allTimeReturn) {
        this.accountPortfolio = accountPortfolio;
        this.portfolioType = portfolioType;
        this.primaryUser = primaryUser;
        this.availableFunds = availableFunds;
        this.totalBalance = totalBalance;
        this.allTimeReturn = allTimeReturn;
    }

    public String getAccountPortfolio() {
        return accountPortfolio;
    }

    public void setAccountPortfolio(String accountPortfolio) {
        this.accountPortfolio = accountPortfolio;
    }

    public String getPortfolioType() {
        return portfolioType;
    }

    public void setPortfolioType(String portfolioType) {
        this.portfolioType = portfolioType;
    }

    public String getPrimaryUser() {
        return primaryUser;
    }

    public void setPrimaryUser(String primaryUser) {
        this.primaryUser = primaryUser;
    }

    public double getAvailableFunds() {
        return availableFunds;
    }

    public void setAvailableFunds(double availableFunds) {
        this.availableFunds = availableFunds;
    }
    public double getTotalBalance(){
        return totalBalance;
    }
}