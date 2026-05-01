# Sprint 3.3. Patterns II ☕️🍔📈

A practical demonstration of **Creational, Structural, and Behavioral Design Patterns** implemented in Java. This project showcases how to solve common software design challenges using clean, extensible, and maintainable code.

---

## 🏗️ Implemented Patterns

### 1. Decorator Pattern (Bubble Tea Shop) 🧋
Located in the `bubble_tea` package. This pattern allows adding new behaviors to objects dynamically by placing them inside special wrapper objects.

*   **Scenario:** Customizing a Bubble Tea order.
*   **Base Components:** `TeaBase`, `LatteBase`, `MatchaBase`.
*   **Decorators:** `Tapioca`, `Sugar`, `Ice`, `Flavor`.
*   **Key Benefit:** You can combine any number of toppings without creating a massive class hierarchy for every possible combination.

### 2. Fluent Step Builder Pattern (Restaurant Menu) 🍽️
Located in the `restaurant_menu` package. This is a specialized version of the Builder pattern that uses interfaces to guide the user through a specific sequence of steps.

*   **Scenario:** Building a complete restaurant menu (Entrant → Main Course → Dessert/Coffee → Drink).
*   **Features:** Supports optional attributes like `isVegan()`, `isGlutenFree()`, and specific supplements.
*   **Key Benefit:** Prevents "Inconsistent State" and "Telescoping Constructors." The IDE's autocomplete guides you to the next valid step in the construction process.

### 3. Observer Pattern (Stock Market Agent) 🔔
Located in the `stock` package. It defines a subscription mechanism to notify multiple objects about any events that happen to the object they’re observing.

*   **Subject (`StockAgent`):** Tracks the market value and manages the list of subscribers.
*   **Observers (`StockBrokerAgency`):** React automatically to market fluctuations (UP or DOWN).
*   **Key Benefit:** Establishes a loosely coupled relationship between the market data provider and the agencies that consume that data.

---

## 🚀 Code Examples

### Customizing a Drink (Decorator)
```java
BubbleTea myDrink = new MatchaBase(); 
myDrink = new Flavor(myDrink, "Vanilla"); // Add Vanilla
myDrink = new Tapioca(myDrink);            // Add Tapioca
myDrink = new Sugar(myDrink);              // Add Sugar

System.out.println(myDrink.getDescription() + myDrink.getCost()); 
// Output: Matcha Bubble Tea with Vanilla flavor with tapioca with sugar
```

### Ordering a Menu (Builder)
```java
Menu menu = new MenuBuilder()
    .withEntrant("Bruschetta")
        .isVegan()
    .withMainCourse("Salmon")
        .isGlutenFree()
    .withDessert("Tiramisu")
    .withDrink("White Wine")
    .build();
```

### Market Notifications (Observer)
```java
StockAgent agent = new StockAgent();
StockBrokerAgency agencyA = new StockBrokerAgency("Alpha Stocks");

agent.addObserver(agencyA);
agent.stockMarketUp(25.5); // "Alpha Stocks received notification: Stock market went UP..."
```

---

## 📂 Project Structure

```bash
.

└── src
    ├── main
    │   ├── java
    │   │   ├── bubble_tea
    │   │   │   ├── BubbleTea.java
    │   │   │   ├── BubbleTeaDecorator.java
    │   │   │   ├── Flavor.java
    │   │   │   ├── Ice.java
    │   │   │   ├── LatteBase.java
    │   │   │   ├── MatchaBase.java
    │   │   │   ├── Sugar.java
    │   │   │   ├── Tapioca.java
    │   │   │   └── TeaBase.java
    │   │   ├── restaurant_menu
    │   │   │   ├── builder
    │   │   │   │   ├── DessertOrCoffeeBuilder.java
    │   │   │   │   ├── EntrantFoodPlateBuilder.java
    │   │   │   │   ├── FirstStepMenuBuilder.java
    │   │   │   │   ├── LastBuilder.java
    │   │   │   │   ├── MainCoursePlateBuilder.java
    │   │   │   │   └── MenuBuilder.java
    │   │   │   └── models
    │   │   │       ├── menu
    │   │   │       │   └── Menu.java
    │   │   │       └── plates
    │   │   │           ├── Dessert.java
    │   │   │           ├── EntrantFoodPlate.java
    │   │   │           ├── FoodPlate.java
    │   │   │           └── MainFoodPlate.java
    │   │   └── stock
    │   │       ├── StockAgent.java
    │   │       ├── StockBrokerAgency.java
    │   │       ├── StockMarketUpdate.java
    │   │       └── StockValueUpdateType.java
    │   └── resources
    └── test
        ├── java
        │   ├── bubble_tea
        │   │   └── BubbleTeaTest.java  
        │   ├── restaurant_menu
        │   │   └── builder
        │   │       └── MenuBuilderTest.java
        │   └── stock
        │       └── StockBrokerAgencyTest.java
        └── resources
``
---

## 🛠️ Requirements
*   **Java SDK 8+**
*   **Note:** The `StockAgent` implementation uses `java.util.Observable`. Please note that this class is deprecated since Java 9 in favor of the `java.util.concurrent.Flow` API, but it remains excellent for educational purposes.

---

## 📝 License
This project is for educational purposes. Feel free to use the logic to implement design patterns in your own systems! 🚀