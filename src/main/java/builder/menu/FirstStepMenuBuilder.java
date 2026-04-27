package builder.menu;


public interface FirstStepMenuBuilder {
    EntrantFoodPlateBuilder withEntrant(String entrantName);
    MainCoursePlateBuilder withMainCourse(String entrantName);
}
