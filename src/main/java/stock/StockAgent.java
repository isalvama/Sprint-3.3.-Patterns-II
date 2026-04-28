package stock;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Observable;

public class StockAgent extends Observable {
    private List<StockBrokerAgency> stockBrokerAgencies = new ArrayList<>();
    private double stockMarketValue = 0;

    public void addObserver(StockBrokerAgency stockBrokerAgency){
        Objects.requireNonNull(stockBrokerAgency, "The stockBrokerAgency can not be null");
        if (stockBrokerAgencies.contains(stockBrokerAgency)) throw new IllegalArgumentException("The StockBrokerAgency " + stockBrokerAgency.getName() + " already exists in the StockAgent's stockBrokerAgencies list");
        stockBrokerAgencies.add(stockBrokerAgency);
    }

    public void removeObserver(StockBrokerAgency stockBrokerAgency){
        Objects.requireNonNull(stockBrokerAgency, "The stockBrokerAgency can not be null");
        if (!(stockBrokerAgencies.contains(stockBrokerAgency))) throw new IllegalArgumentException("The StockBrokerAgency " + stockBrokerAgency.getName() + " does not exist in the StockAgent's stockBrokerAgencies list");
        stockBrokerAgencies.remove(stockBrokerAgency);
    }

    public void stockMarketUp(double stockMarketValueIncrease) {
        this.stockMarketValue+= stockMarketValueIncrease;
        setChanged();
        notifyObservers(new StockMarketUpdate("Stock market went UP to " + stockMarketValueIncrease, stockMarketValueIncrease));
    }

    public void stockMarketDown(double stockMarketValueDecrease){
        this.stockMarketValue -= stockMarketValueDecrease;
        setChanged();
        notifyObservers(new StockMarketUpdate("Stock market went DOWN to " + stockMarketValueDecrease, stockMarketValueDecrease));
    }

}
