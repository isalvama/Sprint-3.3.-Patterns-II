package bubble_tea;

public class Flavor extends BubbleTeaDecorator {
    private String name;
    public Flavor(BubbleTea bubbleTeaToDecorate, String name){
        super(bubbleTeaToDecorate);
        this.name = name;
    }

    @Override
    public String getDescription(){
        return String.format("%s with %s flavor", bubbleTeaToDecorate.getDescription(), name);
    }

    @Override
    public double getCost(){
        return bubbleTeaToDecorate.getCost() + 0.60;
    }
}
