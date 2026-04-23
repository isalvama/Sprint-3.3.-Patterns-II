package builder.plates;

public class Desert extends FoodPlate {
    private String name;

    public static class Builder extends FoodPlate.Builder<Builder>{

        @Override
        protected Builder self() {
            return this;
        }

        public Builder withName(String name) {
            ((Desert)this.foodPlate).name = name;
            return self();
        }

        public Desert build(){
            return (Desert)super.build();
        }
    }
}
