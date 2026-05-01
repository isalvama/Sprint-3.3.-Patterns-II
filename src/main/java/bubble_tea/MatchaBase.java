package bubble_tea;

public class MatchaBase implements BubbleTea{
    @Override
    public String getDescription(){
        return "Matcha Bubble Tea ";
    }

    @Override
    public double getCost(){
        return 3.20;
    }
}
