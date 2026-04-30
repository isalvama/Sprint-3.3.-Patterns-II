package stock;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class StockBrokerAgencyTest{
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    StockAgent agent;
    StockBrokerAgency alphaBrokers = new StockBrokerAgency("Alpha Brokers");
    StockBrokerAgency zenithInvestments = new StockBrokerAgency("Zenith Investments");
    StockBrokerAgency betaBrokers = new StockBrokerAgency("Beta Brokers");


    @BeforeEach

    public void setUpStreams(){
        agent = new StockAgent();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams(){
        System.setOut(originalOut);
    }

    @Test
    public void whenAddingNullStockBrokerAgencyShouldThrowException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {agent.addObserver(null);});
        assertEquals("The stockBrokerAgency to add to stockBrokerAgencies list can not be null", exception.getMessage());
    }

    @Test
    public void whenRemovingNullStockBrokerAgencyShouldThrowException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {agent.removeObserver(null);});
        assertEquals("The stockBrokerAgency to remove from stockBrokerAgencies list can not be null", exception.getMessage());
    }

    @Test
    public void shouldAddNewStockBrokerAgency() {
        assertDoesNotThrow(() -> {agent.addObserver(alphaBrokers);});
        assertDoesNotThrow(() -> {agent.addObserver(zenithInvestments);});
        assertDoesNotThrow(() -> {agent.addObserver(betaBrokers);});
        assertEquals(3, agent.getStockBrokerAgencies().size());
        assertTrue(agent.getStockBrokerAgencies().contains(alphaBrokers));
        assertTrue(agent.getStockBrokerAgencies().contains(zenithInvestments));
        assertTrue(agent.getStockBrokerAgencies().contains(betaBrokers));
        assertEquals("", outContent.toString().trim());
    }

    @Test
    public void whenAddingDuplicateStockBrokerAgencyShouldLoggMessage() {
        agent.addObserver(alphaBrokers);
        agent.addObserver(zenithInvestments);
        agent.addObserver(zenithInvestments);
        assertEquals(2, agent.getStockBrokerAgencies().size());
        assertEquals("Logg: The StockBrokerAgency Zenith Investments already exists in the StockAgent's stockBrokerAgencies list", outContent.toString().trim());
    }

    @Test
    public void whenRemovingStockBrokerAgencyIncludedInListShouldNotContainAgency() {
        agent.addObserver(alphaBrokers);
        agent.addObserver(zenithInvestments);
        assertTrue(agent.getStockBrokerAgencies().contains(alphaBrokers));
        assertEquals(2, agent.getStockBrokerAgencies().size());
        agent.removeObserver(alphaBrokers);
        assertFalse(agent.getStockBrokerAgencies().contains(alphaBrokers));
        assertEquals(1, agent.getStockBrokerAgencies().size());

    }

    @Test
    public void whenRemovingStockBrokerAgencyNotIncludedInListShouldLoggMessage() {
        agent.addObserver(alphaBrokers);
        agent.addObserver(zenithInvestments);
        assertEquals(2, agent.getStockBrokerAgencies().size());
        agent.removeObserver(betaBrokers);
        assertEquals(2, agent.getStockBrokerAgencies().size());
        assertEquals("Logg: The StockBrokerAgency Beta Brokers does not exist in the StockAgent's stockBrokerAgencies list", outContent.toString().trim());
    }

    @Test
    public void testStockAgentMarketUpNotification() {
        agent.addObserver(alphaBrokers);
        agent.addObserver(zenithInvestments);
        agent.stockMarketUp(150.75);
        assertEquals( 150.75, alphaBrokers.getStockMarketFirmValue());
        assertEquals( 150.75, zenithInvestments.getStockMarketFirmValue());
        assertEquals(150.75, agent.getStockMarketValue());
        assertEquals("Zenith Investments received notification: Stock market went UP to 150.75, the new value of stock the stock market is: 150.75\nAlpha Brokers received notification: Stock market went UP to 150.75, the new value of stock the stock market is: 150.75", outContent.toString().trim());
    }

    @Test
    public void testStockAgentMarketDownNotification() {
        agent.addObserver(alphaBrokers);
        agent.addObserver(zenithInvestments);
        agent.stockMarketDown(145.50);
        assertEquals( -145.50, alphaBrokers.getStockMarketFirmValue());
        assertEquals( -145.50, zenithInvestments.getStockMarketFirmValue());
        assertEquals(-145.5, agent.getStockMarketValue());
        assertEquals("Zenith Investments received notification: Stock market went DOWN to 145.5, the new value of stock the stock market is: -145.5\nAlpha Brokers received notification: Stock market went DOWN to 145.5, the new value of stock the stock market is: -145.5", outContent.toString().trim());
    }
}