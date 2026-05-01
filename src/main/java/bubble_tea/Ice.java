package bubble_tea;

public class Ice extends BubbleTeaDecorator {
    public Ice(BubbleTea bubbleTeaToDecorate){
        super(bubbleTeaToDecorate);
    }

    @Override
    public String getDescription(){
        return bubbleTeaToDecorate.getDescription() + " with Ice";
    }

    @Override
    public double getCost(){
        return bubbleTeaToDecorate.getCost() + 0.25;
    }
}
