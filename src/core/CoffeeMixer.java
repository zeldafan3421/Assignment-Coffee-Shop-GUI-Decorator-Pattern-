package core;

import core.bases.HomeBlend;
import core.condiments.Caramel;
import core.condiments.Milk;
import core.condiments.Mocha;
import core.condiments.Soy;
import core.condiments.Vanilla;
import core.condiments.Whip;

public class CoffeeMixer
{
    private CoffeeBase drink;
    private boolean isReady;

    public CoffeeMixer()
    {
        drink = null;
        isReady = false;
    }

    public CoffeeMixer setBase(CoffeeBase base, Size size)
    {
        drink = base;
        base.setSize(size);

        return this;
    }

    public CoffeeMixer addMixin(CondimentBase base, Size size)
    {
        drink = base.setOwner(drink);
        return this;
    }

    public CoffeeMixer addMilk(Size size)
    {
        drink = new Milk(drink, size);
        return this;
    }

    public CoffeeMixer addWhip(Size size) 
    {
        drink = new Whip(drink, size);
        return this;
    }

    public CoffeeMixer addSoy(Size size) 
    {
        drink = new Soy(drink, size);
        return this;
    }

    public CoffeeMixer addMocha(Size size) 
    {
        drink = new Mocha(drink, size);
        return this;
    }

    public CoffeeMixer addVanilla(Size size) 
    {
        drink = new Vanilla(drink, size);
        return this;
    }

    public CoffeeMixer addCaramel(Size size) 
    {
        drink = new Caramel(drink, size);
        return this;
    }

    public CoffeeBase prepare()
    {
        isReady = true;
        return drink;
    }

    public boolean getIsReady()
    {
        return isReady;
    }

    public boolean hasBase() 
    {
        return drink != null;
    }
}
