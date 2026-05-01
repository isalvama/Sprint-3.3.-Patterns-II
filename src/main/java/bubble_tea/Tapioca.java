package bubble_tea;

public class Tapioca extends BubbleTeaDecorator{
    public Tapioca(BubbleTea bubbleTeaToDecorate){
        super(bubbleTeaToDecorate);
    }

    @Override
    public String getDescription(){
        return bubbleTeaToDecorate.getDescription() + " with tapioca";
    }

    @Override
    public double getCost(){
        return bubbleTeaToDecorate.getCost() + 0.50;
    }
}
