package core;

/**
 * 
 */
public abstract class CoffeeBase 
{
    private Size size;
    private String description;

    /**
     * 
     * @param desc
     * @param size
     */
    protected CoffeeBase(String desc, Size size)
    {
        this.size = size;
        this.description = desc;
    }

    /**
     * 
     * @return
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * 
     * @return
     */
    public Size getSize()
    {
        return size;
    }

    /**
     * 
     * @return
     */
    public abstract double cost();
}
