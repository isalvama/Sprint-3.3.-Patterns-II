package builder.menu;

import builder.plates.Desert;
import builder.plates.EntrantFoodPlate;
import builder.plates.MainFoodPlate;

import java.util.List;

/**
 * Implementar una restricció per la qual, si es tria postres, no es podrà afegir cafè, i viceversa.
 * Aquesta regla s’ha de garantir gràcies al disseny d’interfícies.
 * Permetre configurar les propietats dels plats (vegà, apta per celíacs, suplement) amb mètodes fluents i expressius,
 * evitant paràmetres booleanos.
 * Implementa tests unitaris on es mostri la creació diversos menús:
 */

public class Menu {
    // ordre correcte i obligatori: no es podrà afegir postres abans d’afegir el plat principal
    private EntrantFoodPlate entrant;
    private MainFoodPlate mainCourse;
    private List<Desert> postres;
    // Les postres són opcionals a tots els menus i poden ser postres o cafè.
    private String drink;
    private String coffe;

    private Menu(){}
    public static class MenuBuilder{
        private Menu menuManagedInstance = new Menu();

        public MenuBuilder withEntrant (String name){
            this.menuManagedInstance.entrant = new EntrantFoodPlate.Builder().withEntrant(name).build();
            return this;
        }

        public MenuBuilder isGlutenFree() {

            this.menuManagedInstance != null ? this.menuManagedInstance.entrant. =
            }
            return this;
        }

        public Menu withMainCourse(){

        }

        public Menu build() {
            return menuManagedInstance;
        }



    }
}
