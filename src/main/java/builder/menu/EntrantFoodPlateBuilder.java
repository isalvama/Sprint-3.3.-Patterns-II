package builder.menu;

public interface EntrantFoodPlateBuilder {
    EntrantFoodPlateBuilder isVegan();
    EntrantFoodPlateBuilder isGlutenFree();
    MainCoursePlateBuilder withMainCourse(String mainCourseName);
}
