package stock;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Observable;

public class StockAgent extends Observable {

    private List<StockBrokerAgency> stockBrokerAgencies = new ArrayList<>();
    private double stockMarketValue = 0;

    public void addObserver(StockBrokerAgency stockBrokerAgency){
        if (stockBrokerAgency == null) throw new IllegalArgumentException("The stockBrokerAgency to add to stockBrokerAgencies list can not be null");
        if (stockBrokerAgencies.contains(stockBrokerAgency)) {
            System.out.println("Logg: The StockBrokerAgency " + stockBrokerAgency.getName() + " already exists in the StockAgent's stockBrokerAgencies list");
        } else {
            super.addObserver(stockBrokerAgency);
            stockBrokerAgencies.add(stockBrokerAgency);
        }
    }

    public void removeObserver(StockBrokerAgency stockBrokerAgency){
        if (stockBrokerAgency == null) throw new IllegalArgumentException("The stockBrokerAgency to remove from stockBrokerAgencies list can not be null");
        if (!(stockBrokerAgencies.contains(stockBrokerAgency))) {
            System.out.println("Logg: The StockBrokerAgency " + stockBrokerAgency.getName() + " does not exist in the StockAgent's stockBrokerAgencies list");
        } else {
            super.deleteObserver(stockBrokerAgency);
            stockBrokerAgencies.remove(stockBrokerAgency);
        }
    }

    public void stockMarketUp(double stockMarketValueIncreasePoints) {
        if (stockMarketValueIncreasePoints < 0) throw new IllegalArgumentException("The stockMarketValueIncreasePoints value can not be negative");
        this.stockMarketValue += stockMarketValueIncreasePoints;
        notifyAgencies(StockValueUpdateType.UP, stockMarketValueIncreasePoints);
    }

    public void stockMarketDown(double stockMarketValueDecreasePoints){
        if (stockMarketValueDecreasePoints < 0) throw new IllegalArgumentException("The stockMarketValueDecreasePoints value can not be negative");
        this.stockMarketValue -= stockMarketValueDecreasePoints;
        notifyAgencies(StockValueUpdateType.DOWN, stockMarketValueDecreasePoints);
    }

    public void notifyAgencies(StockValueUpdateType updateType, double stockMarketValueUpdate){
        setChanged();
        notifyObservers(
                new StockMarketUpdate(String.format("Stock market went %s to %s, the new value of stock the stock market is: %s", updateType.name(), stockMarketValueUpdate, this.stockMarketValue), this.stockMarketValue));
    }

    public List<StockBrokerAgency> getStockBrokerAgencies() {
        return List.copyOf(stockBrokerAgencies);
    }

    public double getStockMarketValue() {
        return stockMarketValue;
    }
}
