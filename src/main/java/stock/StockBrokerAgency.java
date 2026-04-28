package stock;

import java.util.Observable;
import java.util.Observer;

public class StockBrokerAgency implements Observer {
    private String name;
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
        this.stockMarketFirmValue =+ stockMarketUpdate.getValueUpdate();
        System.out.println(this.name + " received notification: " + stockMarketUpdate.getMessage());

    }
}
