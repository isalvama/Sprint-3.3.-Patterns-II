package bubble_tea;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BubbleTeaTest {

    @Test
    void shouldCreateALatteBubbleTeaWithDecoration(){
        BubbleTea latteTea = new LatteBase();
        latteTea = new Tapioca(latteTea);
        latteTea = new Sugar(latteTea);
        latteTea = new Flavor(latteTea, "Maduixa");
        latteTea = new Flavor(latteTea, "Mango");

        assertEquals("Latte Bubble Tea with tapioca with sugar with Maduixa flavor with Mango flavor", latteTea.getDescription());
        assertEquals(5.50, latteTea.getCost(), 0.001);
    }

    @Test
    void shouldCreateAMatchaBubbleTeaWithDecoration() {
        BubbleTea matchaTea = new MatchaBase();
        matchaTea = new Ice(matchaTea);
        matchaTea = new Sugar(matchaTea);

        assertEquals("Matcha Bubble Tea with ice with sugar", matchaTea.getDescription());
        assertEquals(3.75, matchaTea.getCost(), 0.001);
    }

    @Test
    void shouldCreateATeaBubbleTeaWithDecoration(){
        BubbleTea teaBubbleTea = new TeaBase();
        teaBubbleTea = new Tapioca(teaBubbleTea);
        teaBubbleTea = new Ice(teaBubbleTea);
        teaBubbleTea = new Sugar(teaBubbleTea);

        assertEquals("Tea Bubble Tea with tapioca with ice with sugar", teaBubbleTea.getDescription());
        assertEquals(4.05, teaBubbleTea.getCost(), 0.001);
    }
}