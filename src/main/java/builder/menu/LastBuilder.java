package builder.menu;

public interface LastBuilder {
    Menu build();
    LastBuilder withDrink(String drinkName);
}
