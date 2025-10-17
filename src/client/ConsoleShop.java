package client;

import java.util.ArrayList;
import java.util.Scanner;

import core.CoffeeBase;
import core.CoffeeMixer;
import core.Size;
import core.bases.DarkRoast;
import core.bases.DecafCoffee;
import core.bases.Expresso;
import core.bases.HomeBlend;
import core.condiments.Caramel;
import core.condiments.Milk;
import core.condiments.Mocha;
import core.condiments.Soy;
import core.condiments.Vanilla;
import core.condiments.Whip;

public class ConsoleShop 
{
    private ArrayList<CoffeeBase> baseOptions;
    private ArrayList<CoffeeBase> addonOptions;

    public ConsoleShop()
    {
        baseOptions = new ArrayList<>();
        addonOptions = new ArrayList<>();
        
        baseOptions.add(new DarkRoast(null));
        baseOptions.add(new Expresso(null));
        baseOptions.add(new DecafCoffee(null));
        baseOptions.add(new HomeBlend(null));

        CoffeeBase noCostOwner = new CoffeeBase(null, null)
        {
            @Override
            public double cost() 
            {
                return 0.0;
            }
        };

        addonOptions.add(new Caramel(noCostOwner, null));
        addonOptions.add(new Milk(noCostOwner, null));
        addonOptions.add(new Mocha(noCostOwner, null));
        addonOptions.add(new Soy(noCostOwner, null));
        addonOptions.add(new Vanilla(noCostOwner, null));
        addonOptions.add(new Whip(noCostOwner, null));

        run();
    }

    private void run()
    {
        Scanner kb = new Scanner(System.in);

        System.out.println("Console version: ");

        printMenu();

        while (kb.hasNextLine())
        {
            final String input = kb.nextLine();
        }
    }

    private void printMenu() 
    {
        System.out.println("Menu:\n");

        System.out.println("Coffee Blends:");
        printMenuList(baseOptions);

        System.out.println("Extras: ");
        printMenuList(addonOptions);
    }

    private void printMenuList(ArrayList<CoffeeBase> list)
    {
        final String entryTemplate = "\t%-20s\tlarge %.2f$\tmedium %.2f$\t small %.2f$";

        for (CoffeeBase o : list)
        {
            final String name = o.getDescription();
            
            o.setSize(Size.SMALL);
            final double smallCost = o.cost(); 

            o.setSize(Size.MEDIUM);
            final double mediumCost = o.cost(); 

            o.setSize(Size.LARGE);
            final double largeCost = o.cost();
            
            System.out.println(String.format(entryTemplate, name, largeCost, mediumCost, smallCost));
        }
    }
}
