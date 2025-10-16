package client;

import core.CoffeeBase;
import core.CoffeeMixer;
import core.Size;

public class ConsoleShop 
{
    public ConsoleShop()
    {
        System.out.println("Console version: ");

        CoffeeBase drink = new CoffeeMixer()
            .setHouseBlend(Size.LARGE)
            .addMilk(Size.LARGE)
            .addWhip(Size.SMALL)
            .addSoy(Size.SMALL)
            .prepare();

        final String receipt = String.format("%.2f$", drink.cost());
        System.out.println(receipt);
    }
}
