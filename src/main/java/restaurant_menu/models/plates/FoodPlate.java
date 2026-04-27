package restaurant_menu.models.plates;

public class FoodPlate {
    private String name;
    private boolean isVegan;
    private boolean isGlutenFree;

    public FoodPlate(String name){
        this.name = name;
        this.isVegan = false;
        this.isGlutenFree = false;
    }

    public boolean isVegan() {
        return isVegan;
    }

    public void setVegan() {
        isVegan = true;
    }

    public boolean isGlutenFree() {
        return isGlutenFree;
    }

    public void setGlutenFree() {
        isGlutenFree = true;
    }

    public void setName(String name) {
        this.name = name;
    }
}
