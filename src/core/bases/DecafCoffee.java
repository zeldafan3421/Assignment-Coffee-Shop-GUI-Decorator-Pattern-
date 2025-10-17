package core.bases;

import core.CoffeeBase;
import core.Size;

public class DecafCoffee extends CoffeeBase
{
    private final static double PRICE = 3.0;

    public DecafCoffee(Size size) 
    {
        super("Decaf Coffee", size);
    }

    @Override
    public double cost()
    {
        return PRICE * getSizeMultiplyer();
    }
}
