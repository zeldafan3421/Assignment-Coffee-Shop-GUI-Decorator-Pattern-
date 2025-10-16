package core.condiments;

import core.CoffeeBase;
import core.CondimentBase;
import core.Size;

public class Milk extends CondimentBase
{
    private static double PRICE = 0.40;

    public Milk(CoffeeBase owner, Size size) 
    {
        super(owner, "Milk", size);
    }

    @Override
    public double cost() 
    {
        return getOwner().cost() + PRICE * getSizeMultiplyer();
    }
}
