package core.condiments;

import core.CoffeeBase;
import core.CondimentBase;
import core.Size;

public class Soy extends CondimentBase
{
    private static final double PRICE = 0.3;

    public Soy(CoffeeBase owner, Size size)
    {
        super(owner, "Soy", size);
    }
    @Override
    public double cost() 
    {
        return getOwner().cost() + PRICE * getSizeMultiplyer();
    }

}
