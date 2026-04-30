package stock;

import java.util.Objects;
import java.util.Observable;
import java.util.Observer;

public class StockBrokerAgency implements Observer {
    private final String name;
    private double stockMarketFirmValue;

    public StockBrokerAgency(String name){
        this.name = name;
        this.stockMarketFirmValue = 0;
    }

    public String getName() {
        return name;
    }

    public double getStockMarketFirmValue() {
        return stockMarketFirmValue;
    }


    @Override
    public void update(Observable o, Object update) {
        if (!(update instanceof StockMarketUpdate stockMarketUpdate)) throw new IllegalArgumentException("Invalid type: the update is not of StockMarketUpdate type");
        this.stockMarketFirmValue = stockMarketUpdate.getNewStockMarketValue();
        System.out.println(this.name + " received notification: " + stockMarketUpdate.getMessage());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        StockBrokerAgency that = (StockBrokerAgency) o;
        return Double.compare(stockMarketFirmValue, that.stockMarketFirmValue) == 0 && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, stockMarketFirmValue);
    }
}
