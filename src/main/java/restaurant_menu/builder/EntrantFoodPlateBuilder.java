package restaurant_menu.builder;

public interface EntrantFoodPlateBuilder {
    EntrantFoodPlateBuilder isVegan();
    EntrantFoodPlateBuilder isGlutenFree();
    MainCoursePlateBuilder withMainCourse(String mainCourseName);
}
