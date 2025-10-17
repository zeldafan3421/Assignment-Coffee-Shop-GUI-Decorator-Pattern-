package core.bases;

import core.CoffeeBase;
import core.Size;

public class Expresso extends CoffeeBase
{
    private final static double PRICE = 3.0;

    public Expresso(Size size) 
    {
        super("Expresso", size);
    }

    @Override
    public double cost()
    {
        return PRICE * getSizeMultiplyer();
    }
}
