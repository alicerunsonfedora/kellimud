public class Armor extends Item {
    
    /**
     * Instantiate the Armor object from Item.
     */
    private int defense;

    public Armor(int itemlevel)
    {
        super("Armor", "defense", itemlevel);
    	defense = itemlevel;
    }
}
