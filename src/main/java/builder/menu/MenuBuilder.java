package builder.menu;

import builder.plates.Dessert;
import builder.plates.EntrantFoodPlate;
import builder.plates.MainFoodPlate;

public class MenuBuilder implements FirstStepMenuBuilder {
    Menu menuManagedInstance = new Menu();

    @Override
    public EntrantFoodPlateBuilder withEntrant(String entrantName) {
        menuManagedInstance.setEntrant(new EntrantFoodPlate(entrantName));
        return new EntrantStepBuilder();
    }

    @Override
    public MainCoursePlateBuilder withMainCourse(String mainCourseName) {
        menuManagedInstance.setMainCourse(new MainFoodPlate(mainCourseName));
        return new MainCourseStepBuilder();
    }

    private class EntrantStepBuilder implements EntrantFoodPlateBuilder {

        @Override
        public EntrantFoodPlateBuilder isVegan() {
            menuManagedInstance.getEntrant().setVegan();
            return this;
        }

        @Override
        public EntrantFoodPlateBuilder isGlutenFree() {
            menuManagedInstance.getEntrant().setGlutenFree();
            return this;
        }

        @Override
        public MainCoursePlateBuilder withMainCourse(String mainCourseName) {
            menuManagedInstance.setMainCourse(new MainFoodPlate(mainCourseName));
            return new MainCourseStepBuilder();
        }
    }

    private class MainCourseStepBuilder implements MainCoursePlateBuilder {

        @Override
        public MainCoursePlateBuilder isVegan() {
            menuManagedInstance.getMainCourse().setVegan();
            return this;
        }

        @Override
        public MainCoursePlateBuilder isGlutenFree() {
            menuManagedInstance.getMainCourse().setGlutenFree();
            return this;
        }

        @Override
        public MainCoursePlateBuilder withSupplement(String supplementName) {
            menuManagedInstance.getMainCourse().setSupplement(supplementName);
            return this;
        }

        @Override
        public LastStepBuilder withDessert(String dessertName) {
            menuManagedInstance.setDessert(new Dessert(dessertName));
            return new LastStepBuilder();
        }

        @Override
        public LastBuilder withCoffee(String coffeeName) {
            menuManagedInstance.setCoffee(coffeeName);
            return new LastStepBuilder();
        }

        @Override
        public MainCoursePlateBuilder withDrink(String drinkName) {
            menuManagedInstance.setDrink(drinkName);
            return this;
        }

        @Override
        public Menu build(){
            return menuManagedInstance;
        }
    }


    private class LastStepBuilder implements LastBuilder {

        @Override
        public LastBuilder withDrink(String drinkName) {
            menuManagedInstance.setDrink(drinkName);
            return this;
        }

        @Override
        public Menu build(){
            return menuManagedInstance;
        }
    }
}
