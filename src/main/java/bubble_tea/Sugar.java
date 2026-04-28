package bubble_tea;

public class Sugar extends BubbleTeaDecorator{
    public Sugar(BubbleTea bubbleTeaToDecorate){
        super(bubbleTeaToDecorate);
    }

    @Override
    public String getDescription(){
       return bubbleTeaToDecorate.getDescription() + " with sugar";
    }

    @Override
    public double getCost(){
        return bubbleTeaToDecorate.getCost() + 0.30;
    }
}
