
public class Item {
	private String name;
	private String type;
	private int level;

	public Item(String aname, String atype, int itemlevel)
	{
		name = aname;
		type = atype;
		level = itemlevel;
	}
	
	public String name()
	{
		return name;
	}
	
	public String type()
	{
		return type;
	}

	public int getLevel()
    {
        return level;
    }

}
