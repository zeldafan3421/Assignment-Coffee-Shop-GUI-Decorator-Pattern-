package core.condiments;

import core.CoffeeBase;
import core.CondimentBase;
import core.Size;

public class Whip extends CondimentBase
{
    private final static double PRICE = 0.1;

    public Whip(CoffeeBase owner, Size size) 
    {
        super(owner, "Whip", size);
    }

    @Override
    public double cost() 
    {
        return getOwner().cost() + PRICE * getSizeMultiplyer();
    }

}
