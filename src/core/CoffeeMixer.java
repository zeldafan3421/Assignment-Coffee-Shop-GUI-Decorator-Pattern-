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

    public CoffeeMixer()
    {
        drink = null;
    }

    public CoffeeMixer setHouseBlend(Size size)
    {
        drink = new HomeBlend(size);
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
        return drink;
    }
}
