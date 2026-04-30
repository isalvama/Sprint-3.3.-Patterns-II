package stock;

public class StockMarketUpdate {
    private double valueUpdate;
    private String message;

    public StockMarketUpdate(String message, double valueUpdate) {
        this.message = message;
        this.valueUpdate = valueUpdate;
    }

    public double getValueUpdate() {
        return valueUpdate;
    }

    public String getMessage() {
        return message;
    }
}
