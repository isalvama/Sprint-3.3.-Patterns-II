package stock;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Observer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StockBrokerAgencyTest{
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;


    @BeforeEach
    public void setUpStreams(){
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams(){
        System.setOut(originalOut);
    }

    @Test
    public void testStockAgentMarketUpNotifications() {
        StockAgent agent = new StockAgent();

        Observer alphaBrokers = new StockBrokerAgency("Alpha Brokers");
        Observer zenithInvestments = new StockBrokerAgency("Zenith Investments");

        agent.addObserver(alphaBrokers);
        agent.addObserver(zenithInvestments);

        agent.stockMarketUp(150.75);
        assertEquals("Zenith Investments received notification: Stock market went UP to 150.75\nAlpha Brokers received notification: Stock market went UP to 150.75", outContent.toString().trim());
    }

    @Test
    public void testStockAgentMarketDownNotifications() {
        StockAgent agent = new StockAgent();

        Observer alphaBrokers = new StockBrokerAgency("Alpha Brokers");
        Observer zenithInvestments = new StockBrokerAgency("Zenith Investments");

        agent.addObserver(alphaBrokers);
        agent.addObserver(zenithInvestments);

        agent.stockMarketDown(145.50);
        assertEquals("Zenith Investments received notification: Stock market went DOWN to 145.5\nAlpha Brokers received notification: Stock market went DOWN to 145.5", outContent.toString().trim());
    }
}