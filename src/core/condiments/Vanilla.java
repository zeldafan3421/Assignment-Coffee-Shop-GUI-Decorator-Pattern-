package core.condiments;

import core.CoffeeBase;
import core.CondimentBase;
import core.Size;

public class Vanilla extends CondimentBase
{
    private final static double PRICE = 0.6;

    public Vanilla(CoffeeBase owner, Size size) 
    {
        super(owner, "Vanilla", size);
    }

    @Override
    public double cost() 
    {
        return getOwner().cost() + PRICE * getSizeMultiplyer();
    }

}
