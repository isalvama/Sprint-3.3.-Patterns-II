package restaurant_menu.builder;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import restaurant_menu.models.menu.Menu;

import static org.junit.jupiter.api.Assertions.*;

class MenuBuilderTest implements WithAssertions {
    @Test
    void shouldCreateCompleteMenuSuccessfully() {
        MenuBuilder builder = new MenuBuilder();
        Menu completeMenu = builder
                .withEntrant("Tomato salad")
                .isGlutenFree()
                .withMainCourse("Hamburger")
                .isVegan()
                .withSupplement("French fries")
                .withDessert("Cheesecake")
                .withDrink("Red wine")
                .build();

        assertNotNull(completeMenu, "The menu should not be null");

        assertNotNull(completeMenu.getEntrant());
        assertEquals("Tomato salad", completeMenu.getEntrant().getName());
        assertTrue(completeMenu.getEntrant().isGlutenFree());
        assertFalse(completeMenu.getEntrant().isVegan());

        assertNotNull(completeMenu.getMainCourse());
        assertEquals("Hamburger", completeMenu.getMainCourse().getName());
        assertEquals("French fries", completeMenu.getMainCourse().getSupplement());
        assertTrue(completeMenu.getMainCourse().isVegan());

        assertEquals("Cheesecake", completeMenu.getDessert().getName());
        assertEquals("Red wine", completeMenu.getDrink());
        assertNull(completeMenu.getCoffee(), "The coffee should be null if a dessert has been ordered");
    }

    @Test
    void shouldCreateKidsMenuSuccessfully() {
        MenuBuilder builder = new MenuBuilder();
        Menu kidsMenu = builder
                .withMainCourse("Pasta with tomato sauce")
                .isGlutenFree()
                .isVegan()
                .withSupplement("Extra grated cheese")
                .withDessert("Brownie")
                .withDrink("Water")
                .build();

        assertNotNull(kidsMenu, "The menu should not be null");

        assertNotNull(kidsMenu.getMainCourse());
        assertEquals("Pasta with tomato sauce", kidsMenu.getMainCourse().getName());
        assertEquals("Extra grated cheese", kidsMenu.getMainCourse().getSupplement());
        assertTrue(kidsMenu.getMainCourse().isGlutenFree());
        assertTrue(kidsMenu.getMainCourse().isVegan());


        assertEquals("Brownie", kidsMenu.getDessert().getName());
        assertEquals("Water", kidsMenu.getDrink());

        assertNull(kidsMenu.getCoffee());
        assertNull(kidsMenu.getEntrant());
    }

    @Test
    void shouldCreateHalfMenuSuccessfully() {
        MenuBuilder builder = new MenuBuilder();
        Menu halfMenu = builder
                .withMainCourse("Lasagna")
                .isGlutenFree()
                .withDrink("CocaCola")
                .build();

        assertNotNull(halfMenu, "The menu should not be null");

        assertNotNull(halfMenu.getMainCourse());
        assertEquals("Lasagna", halfMenu.getMainCourse().getName());
        assertTrue(halfMenu.getMainCourse().isGlutenFree());
        assertFalse(halfMenu.getMainCourse().isVegan());

        assertEquals("CocaCola", halfMenu.getDrink());
        assertNull(halfMenu.getCoffee());
        assertNull(halfMenu.getEntrant());
        assertNull(halfMenu.getDessert());
    }

    @Test
    void shouldCreateAMenuWithoutDrinkCoffeeNOrDessertSuccessfully() {
        MenuBuilder builder = new MenuBuilder();
        Menu menuWithoutDrinkDessertCoffee = builder
                .withEntrant("Pasta Cesar Salad")
                .isGlutenFree()
                .isVegan()
                .withMainCourse("Tarte Flambé")
                .withSupplement("Mushrooms")
                .build();

        assertNotNull(menuWithoutDrinkDessertCoffee, "The menu should not be null");

        assertNotNull(menuWithoutDrinkDessertCoffee.getEntrant());
        assertEquals("Pasta Cesar Salad", menuWithoutDrinkDessertCoffee.getEntrant().getName());
        assertTrue(menuWithoutDrinkDessertCoffee.getEntrant().isGlutenFree());
        assertTrue(menuWithoutDrinkDessertCoffee.getEntrant().isVegan());

        assertNotNull(menuWithoutDrinkDessertCoffee.getMainCourse());
        assertEquals("Tarte Flambé", menuWithoutDrinkDessertCoffee.getMainCourse().getName());
        assertEquals("Mushrooms", menuWithoutDrinkDessertCoffee.getMainCourse().getSupplement());
        assertFalse(menuWithoutDrinkDessertCoffee.getMainCourse().isVegan());
        assertFalse(menuWithoutDrinkDessertCoffee.getMainCourse().isGlutenFree());


        assertNull(menuWithoutDrinkDessertCoffee.getDessert());
        assertNull(menuWithoutDrinkDessertCoffee.getDrink());
        assertNull(menuWithoutDrinkDessertCoffee.getCoffee(), "The coffee should be null if a dessert has been ordered");
    }

    @Test
    void shouldCreateAMenuWithCoffeeWithoutDessertSuccessfully() {
        MenuBuilder builder = new MenuBuilder();
        Menu menuWithCoffee = builder
                .withEntrant("Gazpacho")
                .withMainCourse("Pasta with pesto")
                .isGlutenFree()
                .isVegan()
                .withCoffee("Capuccino")
                .build();

        assertNotNull(menuWithCoffee, "The menu should not be null");

        assertNotNull(menuWithCoffee.getEntrant());
        assertEquals("Gazpacho", menuWithCoffee.getEntrant().getName());
        assertFalse(menuWithCoffee.getEntrant().isGlutenFree());
        assertFalse(menuWithCoffee.getEntrant().isVegan());

        assertNotNull(menuWithCoffee.getMainCourse());
        assertEquals("Pasta with pesto", menuWithCoffee.getMainCourse().getName());
        assertTrue(menuWithCoffee.getMainCourse().isVegan());
        assertTrue(menuWithCoffee.getMainCourse().isGlutenFree());

        assertNotNull(menuWithCoffee.getCoffee());
        assertEquals("Capuccino", menuWithCoffee.getCoffee());

        assertNull(menuWithCoffee.getDrink());
        assertNull(menuWithCoffee.getDessert(), "The dessert should be null if a coffee has been ordered");
    }
}