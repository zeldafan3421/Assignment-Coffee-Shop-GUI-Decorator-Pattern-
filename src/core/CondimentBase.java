package core;

/**
 * 
 */
public abstract class CondimentBase extends CoffeeBase
{
    private CoffeeBase owner;

    /**
     * 
     * @param owner
     * @param desc
     * @param size
     */
    protected CondimentBase(CoffeeBase owner, String desc, Size size) 
    {
        super(desc, size);
        this.owner = owner;
    }

    /**
     * 
     * @return
     */
    public CoffeeBase getOwner()
    {
        return owner;
    }
}
