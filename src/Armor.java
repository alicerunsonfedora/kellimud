public class Armor extends Item {
    private String name = "Armor";
    private String type = "defense";

    /**
     * Instantiate the Armor object from Item.
     */
    private int defense;
    private int level;
    public Armor( int itemlevel)
    {
    	level = itemlevel;
    	defense = level;
    }
}
