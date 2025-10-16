package core.condiments;

import core.CoffeeBase;
import core.CondimentBase;
import core.Size;

public class Caramel extends CondimentBase
{
    private final static double PRICE = 0.5;

    public Caramel(CoffeeBase owner, Size size) 
    {
        super(owner, "Caramel", size);
    }

    @Override
    public double cost() 
    {
        return getOwner().cost() + PRICE * getSizeMultiplyer();
    }

}
