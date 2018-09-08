
public class Player {
	
	private String name,playerclass;
	private int lvl,health,attack,defense,exp;
	private Item hand,armor;
	private Item[] backpack = new Item[10];
	private int flag;
	
	public Player(String aname,String aclass) 
	{
		name = aname;
		playerclass = aclass;
		lvl = 1;
		health = 10;
		attack = 1;
		defense = 0;
		exp = 0;
		flag = 0;
	}
	
	public void die()
	{
		
	}
	
	public String manage_inventory(String action,String item)
	{
		int i;
		Item temp;
		
		if (action.equals("pick up"))
		{
			backpack[flag] = finditem(item);
		}
		
		if (action.equals("drop"))
		{
			for(i=0;i<10;i++)
			{
				if(backpack[i].name.equals(item))
				{
					temp = backpack[i];
					backpack[i] = backpack[flag-1];
					backpack[flag-1] = temp;
					backpack[flag-1] = null;
					break;
				}
			}
		}
		
		if(action.equals("pick up"))
		{
			return "You picked up " + item;
		}
		else
		{
			return "You dropped " + item;
		}
	}
	
	public void attack()
	{
		
	}
	
	public void exit()
	{
		
	}
	
	public void move()
	{
		
	}
	

}
