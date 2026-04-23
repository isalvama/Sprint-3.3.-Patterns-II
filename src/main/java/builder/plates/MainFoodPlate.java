package builder.plates;

public class MainFoodPlate extends FoodPlate {
    private String name;
    private String supplement;

    protected MainFoodPlate(){
        super();
    };

    public static class Builder extends FoodPlate.Builder<Builder>{

        public Builder(){
            this.foodPlate = new MainFoodPlate();
        }

        @Override
        public Builder self(){
            return this;
        }
        public Builder withMainCourse(String name){
            ((MainFoodPlate)this.foodPlate).name = name;
            return self();
        }

        public Builder withSupplement(String supplement){
            ((MainFoodPlate)this.foodPlate).supplement = supplement;
            return self();
        }

        public MainFoodPlate build(){
            return (MainFoodPlate) super.build();
        }
    }
}
