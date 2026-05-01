package restaurant_menu.models.plates;

public class MainFoodPlate extends FoodPlate {
    private String supplement;

    public MainFoodPlate(String name) {
        super(name);
    }


    public void setName(String name) {
        this.setName(name);
    }

    public void setSupplement(String supplement) {
        this.supplement = supplement;
    }

    public String getSupplement() {
        return supplement;
    }
}
