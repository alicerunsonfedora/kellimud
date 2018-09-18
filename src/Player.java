import java.util.Scanner;
public class Player {
    Scanner in = new Scanner(System.in);
	private String name,playerclass;
	private int lvl,health,attack,defense,exp;
	private Item hand,armor;
	private Item[] backpack = new Item[10];
	private int flag;
	/*
	 * flag is a pointer that shows the last position of the backpack that is empty
	 * 
	 */
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
		/*
		 * finditem takes a name and returns the Item with the specific name
		 */
		if (action.equals("pick up"))
		{
//			backpack[flag] = finditem(item);
		}
		
		if (action.equals("drop"))
		{
			/*
			 * this for loop finds the item in the backpack and switches it with the last item and then sets last item to null
			 */
			for(i=0;i<10;i++)
			{
				if(backpack[i].name().equalsIgnoreCase(item))
				{
					temp = backpack[i];
					backpack[i] = backpack[flag-1];
					backpack[flag-1] = temp;
					backpack[flag-1] = null;
					break;
				}
			}
		}
		/*
		 * returns correct answer picked up or dropped
		 */
		if(action.equals("pick up"))
		{
			return "You picked up " + item;
		}
		else
		{
			return "You dropped " + item;
		}
	}
	
	public String attack()
	{
		return "You attacked!";
	}
	
	public boolean exit()
	{
		System.out.println("Are you sure you want to close the game?");
		
		while(true)
		{
			String input = in.nextLine();
			if(input.equals("yes"))
			{
				System.out.println("Game is closing");
				return true;
			}
			else if(input.equals("no"))
			{
				System.out.println("DECIDE DUDEEE,wanna play or not?");
				System.out.println("I mean... Game resuming");
				return false;
			}
			else
			{
				System.out.println("yes or no?");
			}
		}
	}
	
	public String move()
	{
		return "Great, you moved in an arbitrary direction.";
	}
	
	public String equip( Item item)
	{
		if(item.type().equals("Sword"))
		{
			hand = item;
		}
		else
		{
			armor = item;
		}
		
		return "You just equiped" + item.name();
	}
	
	public String hand()
	{
		return hand.name();
	}
	
	public String armor()
	{
		return armor.name();
	}
	
	public int exp()
	{
		return exp;
	}
	
	public int health()
	{
		return health;
	}
	
	public int defense()
	{
		return defense;
	}
	
	public int level()
	{
		return lvl;
	}
	
	public String name()
	{
		return name;
	}
	
	public String playerclass()
	{
		return playerclass;
	}

}
