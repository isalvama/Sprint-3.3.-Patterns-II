package bubble_tea;

public abstract class BubbleTeaDecorator implements BubbleTea {
    protected BubbleTea bubbleTeaToDecorate;

    public BubbleTeaDecorator(BubbleTea bubbleTeaToDecorate){
        this.bubbleTeaToDecorate = bubbleTeaToDecorate;
    }

    @Override
    public String getDescription(){
        return bubbleTeaToDecorate.getDescription();
    }

    @Override
    public double getCost(){
        return bubbleTeaToDecorate.getCost();
    }
}
