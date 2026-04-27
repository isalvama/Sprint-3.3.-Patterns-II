package restaurant_menu.builder;


public interface FirstStepMenuBuilder {
    EntrantFoodPlateBuilder withEntrant(String entrantName);
    MainCoursePlateBuilder withMainCourse(String entrantName);
}
