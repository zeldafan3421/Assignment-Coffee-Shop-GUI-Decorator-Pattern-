package core.condiments;

import core.CoffeeBase;
import core.CondimentBase;
import core.Size;

public class Mocha extends CondimentBase
{
    private static final double PRICE = 0.20;

    public Mocha(CoffeeBase owner, Size size) 
    {
        super(owner, "Mocha", size);
    }

    @Override
    public double cost() 
    {
        return getOwner().cost() + PRICE * getSizeMultiplyer();
    }
}
