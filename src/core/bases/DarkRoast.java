package core.bases;

import core.CoffeeBase;
import core.Size;

public class DarkRoast extends CoffeeBase
{
    private final static double PRICE = 3.0;

    public DarkRoast(Size size) 
    {
        super("Dark Roast Coffee", size);
    }

    @Override
    public double cost()
    {
        return PRICE * getSizeMultiplyer();
    }
}
