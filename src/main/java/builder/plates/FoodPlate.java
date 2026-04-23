package builder.plates;

public class FoodPlate {
    protected boolean isVegan;
    protected boolean isGlutenFree;

    protected FoodPlate (){}

    public abstract static class Builder<T extends Builder<T>> {
        protected FoodPlate foodPlate;
        protected abstract T self();

        public T isVegan() {
            foodPlate.isVegan = true;
            return self();
        }

        public T isGlutenFree() {
            foodPlate.isGlutenFree = true;
            return self();
        }

        public FoodPlate build() {
            return foodPlate;
        }
    }
}
