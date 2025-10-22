package client;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

import core.CoffeeBase;
import core.CoffeeMixer;
import core.CondimentBase;
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
        CoffeeMixer currentMixer = new CoffeeMixer();

        int userSel = 0;

        do
        {
            System.out.print("Input:");

            if (!currentMixer.hasBase())
            {
                userSel = kb.nextInt();
                CoffeeBase base = null;

                if (baseOptions.size() <= userSel)
                {
                    System.out.println("invalid selection");
                }
                else if ((base = baseOptions.get(userSel)) != null)
                {
                    System.out.printf("Select Size:\n0:Small\n1:Medium\n2:Large\nInput:");
                    userSel = kb.nextInt();
                    currentMixer.setBase(base, Size.values()[userSel]);
                    
                    System.out.println(baseOptions.get(0).getDescription());
                }
            }
            else
            {
                boolean addons = false;
                System.out.print("Add more addons? 0 : yes, 1 : no\nInput:");
                userSel = kb.nextInt();

                if (userSel == 0) 
                    addons = true;

                CondimentBase base = null;

                if (!addons)
                {
                    final CoffeeBase mix = currentMixer.prepare();
                    final double totalCost = mix.cost();

                    Stack<String> ticketItems = new Stack();
                    CoffeeBase current = mix;
                    System.out.printf("Ticket:\n");

                    while (current instanceof CondimentBase)
                    {
                        final String name = current.getDescription();
                        final Size size = current.getSize();
                        current = ((CondimentBase) current).getOwner();

                        final double cost = totalCost - (totalCost - current.cost());

                        ticketItems.push(String.format("\t%-20s\t %-8s \t %.2f$", name, size.toString(), cost));
                    }

                    final String name = current.getDescription();
                    final Size size = current.getSize();
                    final double cost = (totalCost - current.cost());

                    System.out.printf("\t%-20s\t %-8s \t %.2f$\n", name, size.toString(), cost);
                    for (String s : ticketItems)
                    {
                        System.out.println(s);
                    }

                    System.out.printf("Total : %.2f$", totalCost);
                }
                else
                {
                    userSel = kb.nextInt();
                    base = (CondimentBase)addonOptions.get(userSel);

                    System.out.printf("Select Size:\n0:Small\n1:Medium\n2:Large\nInput:");
                    userSel = kb.nextInt();
                    currentMixer.addMixin(base, Size.values()[userSel]);
                }
            }
        } while (!currentMixer.getIsReady());
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
        final String entryTemplate = "%d:\t%-20s\tlarge %.2f$\tmedium %.2f$\t small %.2f$";

        int id = 0;

        for (CoffeeBase o : list)
        {
            final String name = o.getDescription();
            
            o.setSize(Size.SMALL);
            final double smallCost = o.cost(); 

            o.setSize(Size.MEDIUM);
            final double mediumCost = o.cost(); 

            o.setSize(Size.LARGE);
            final double largeCost = o.cost();
            
            System.out.println(String.format(entryTemplate, id++, name, largeCost, mediumCost, smallCost));
        }
    }
}
