package core.bases;

import core.CoffeeBase;
import core.Size;

public class HomeBlend extends CoffeeBase
{
    private final static double PRICE = 2.0;

    public HomeBlend(Size size) 
    {
        super("Home Blend Coffee", size);
    }

    @Override
    public double cost()
    {
        return PRICE * getSizeMultiplyer();
    }
}
