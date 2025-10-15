import java.util.ArrayList;
import java.util.Arrays;

import client.ConsoleShop;

public class App 
{
    enum Flags
    {
        NO_VALUE,
        CONSOLE_ONLY
    };

    /**
     * Entrypoint to application.
     * 
     * arguments:
     *  -nogui : console only version
     * 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) 
        throws Exception 
    {
        new ConsoleShop();
    }
}
