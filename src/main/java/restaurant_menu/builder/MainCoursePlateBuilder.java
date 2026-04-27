package restaurant_menu.builder;

import restaurant_menu.models.menu.Menu;

public interface MainCoursePlateBuilder {
    MainCoursePlateBuilder isVegan();
    MainCoursePlateBuilder isGlutenFree();
    MainCoursePlateBuilder withSupplement(String supplementName);
    LastBuilder withDessert(String dessertName);
    LastBuilder withCoffee(String coffeeName);
    MainCoursePlateBuilder withDrink(String drinkName);
    Menu build();
}
