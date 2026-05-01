package restaurant_menu.builder;

import restaurant_menu.models.menu.Menu;

public interface LastBuilder {
    Menu build();
    LastBuilder withDrink(String drinkName);
}
