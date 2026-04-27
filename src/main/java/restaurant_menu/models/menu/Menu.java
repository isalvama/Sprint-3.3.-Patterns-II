package restaurant_menu.models.menu;

import restaurant_menu.models.plates.Dessert;
import restaurant_menu.models.plates.EntrantFoodPlate;
import restaurant_menu.models.plates.MainFoodPlate;

public class Menu {
    private EntrantFoodPlate entrant;
    private MainFoodPlate mainCourse;
    private Dessert dessert;
    private String drink;
    private String coffee;

    public Menu(){}

    public void setEntrant(EntrantFoodPlate entrant) {
        this.entrant = entrant;
    }

    public void setDessert(Dessert dessert) {
        this.dessert = dessert;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public void setCoffee(String coffeName) {
        this.coffee = coffeName;
    }

    public Dessert getDessert() {
        return dessert;
    }

    public String getCoffee() {
        return coffee;
    }

    public EntrantFoodPlate getEntrant() {
        return entrant;
    }

    public MainFoodPlate getMainCourse() {
        return mainCourse;
    }

    public void setMainCourse(MainFoodPlate mainCourse) {
        this.mainCourse = mainCourse;
    }
}
