public class Armor extends Item {
    
    /**
     * Instantiate the Armor object from Item.
     */
    private int defense;
    private int level;
    public Armor( int itemlevel)
    {
        super("Armor", "defense");
    	level = itemlevel;
    	defense = level;
    }
}
