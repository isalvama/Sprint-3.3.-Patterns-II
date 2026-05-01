package stock;

public class StockMarketUpdate {
    private double newStockMarketValue;
    private String message;

    public StockMarketUpdate(String message, double newStockMarketValue) {
        this.message = message;
        this.newStockMarketValue = newStockMarketValue;
    }

    public double getNewStockMarketValue() {
        return newStockMarketValue;
    }

    public String getMessage() {
        return message;
    }
}
