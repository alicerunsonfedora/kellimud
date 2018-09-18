/**
 * The Sword item.
 * @author Marquis Kurt
 */
public class Sword extends Item {
    private String name = "Sword";
    private String type = "Attack";

    /**
     * Instantiate the Sword object from Item.
     */
    private int attack;
    private int level;
    public Sword( int itemlevel)
    {
    	level = itemlevel;
    	attack = level;
    }
}
