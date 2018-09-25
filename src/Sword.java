/**
 * The Sword item.
 * @author Marquis Kurt
 */
public class Sword extends Item {
    private int attack;

    /**
     * Instantiate the Sword object from Item. The name and type are defined when you initialize the super() function. This function will initialize the parent class, so you must pass the name and type directly into super. Defining the name and the type are done through that instead of redefining them inside of this class.
     * @param itemlevel Level of the item
     * @author Marquis Kurt
     */
    public Sword(int itemlevel)
    {
        super("Sword", "Attack", itemlevel);
    	attack = itemlevel;
    }
}
