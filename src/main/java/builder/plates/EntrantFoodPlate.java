package builder.plates;

public class EntrantFoodPlate extends FoodPlate {
    private String name;

    public static class Builder extends FoodPlate.Builder<Builder>{

        @Override
        protected Builder self() {
            return null;
        }

        public Builder withEntrant (String name){
            ((EntrantFoodPlate)this.foodPlate).name = name;
            return self();
        }

        public EntrantFoodPlate build(){
            return (EntrantFoodPlate) super.build();
        }
    }
}
