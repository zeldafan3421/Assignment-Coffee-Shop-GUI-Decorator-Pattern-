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

    public void setSize(Size size)
    {
        this.size = size;
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

    protected double getSizeMultiplyer()
    {
        switch (size) 
        {
            case Size.SMALL:
                return 1.0;
            case Size.MEDIUM:
                return 1.2;
            case Size.LARGE:
                return 1.4;
            default:
                return 0.0;
        }
    }
}
