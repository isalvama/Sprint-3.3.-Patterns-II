package builder.menu;

import builder.plates.Dessert;
import builder.plates.EntrantFoodPlate;
import builder.plates.MainFoodPlate;

public class Menu {
    private EntrantFoodPlate entrant;
    private MainFoodPlate mainCourse;
    private Dessert dessert;
    private String drink;
    private String coffe;

    Menu(){}

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
        this.coffe = coffeName;
    }

    public Dessert getDessert() {
        return dessert;
    }

    public String getCoffe() {
        return coffe;
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
