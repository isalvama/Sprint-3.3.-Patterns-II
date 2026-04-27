package builder.menu;

public interface MainCoursePlateBuilder {
    MainCoursePlateBuilder isVegan();
    MainCoursePlateBuilder isGlutenFree();
    MainCoursePlateBuilder withSupplement(String supplementName);
    LastBuilder withDessert(String dessertName) throws IllegalAccessException;
    LastBuilder withCoffee(String coffeeName) throws IllegalAccessException;
    MainCoursePlateBuilder withDrink(String drinkName);
    Menu build();
}
