import java.util.Scanner;
import static java.lang.System.out;

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
	
	public String manage_inventory(String action,String item,Dungeon dungeon)
	{
		int i;
		Item temp,actualItem = null;
		
		if (action.equalsIgnoreCase("pick up"))
		{
			actualItem = dungeon.findItem(item);
			if(actualItem.equals(null))
			{
				return "That's not an item you can pick up";
			}
			else
			{
				backpack[flag] = actualItem;
				flag++;
				return "You picked up " + item;
			}
		}
		
		if (action.equalsIgnoreCase("drop"))
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
					flag = flag -1;
					return "You dropped " + item;
				}
			}
		}
		return "Use proper commands";
	}
	
	public int attack(Mob mob)
	{
		mob.takeDamage(this.attack);
		return this.attack;
	}

	public int takeDamage(int amount)
	{
		this.health -= amount;
		if (this.health <= 0)
		{
			this.die();
			return 0;
		}
		else
		{
			return health;
		}
	}

	public int healHealth(int amount)
	{
		this.health += amount;
		if (this.health >= 42)
		{
			this.health = 42;
		}
		return health;
	}
	
	public boolean exit()
	{
		out.println("Are you sure you want to close the game?");
		
		while(true)
		{
			String input = in.nextLine();
			if(input.equalsIgnoreCase("yes"))
			{
				System.out.println("Goodbye.");
				return true;
			}
			else if(input.equalsIgnoreCase("no"))
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
	
	public String move(String direction, Dungeon dungeon)
	{
		Boolean flagMove = false;
		
		if(direction.equalsIgnoreCase("North") && dungeon.room().CanMove(2))
		{
			dungeon.ChangePlayerLocation(2);
			flagMove = true;
		}
		else if(direction.equalsIgnoreCase("East") && dungeon.room().CanMove(1))
		{
			dungeon.ChangePlayerLocation(1);
			flagMove = true;
		}
		else if(direction.equalsIgnoreCase("West") && dungeon.room().CanMove(3))
		{
			dungeon.ChangePlayerLocation(-1);
			flagMove = true;
		}
		else if(dungeon.room().CanMove(0))
		{
			dungeon.ChangePlayerLocation(-2);
			flagMove = true;
		}
		if(flagMove.equals(true))
		{
			return "Great, you moved towards the " + direction;
		}
		else
		{
			return "You can't go that way";
		}
	}
	
	public String equip(String item)
	{
		int i;
		Item temp = null;
		for(i=0;i<10;i++)
		{
			if(backpack[i].name().equalsIgnoreCase(item))
			{
				temp = backpack[i];
				backpack[i] = backpack[flag-1];
				backpack[flag-1] = temp;
				backpack[flag-1] = null;
				flag = flag - 1;
				break;
			}
		}
		if(temp.type().equalsIgnoreCase("Sword"))
		{
			hand = temp;
		}
		else
		{
			armor = temp;
		}
		
		return "You just equipped" + temp.name();
	}
	public String info(Dungeon dungeon)
	{
		return "Health: " + this.health() + "\nRoom: " + dungeon.Playerlocation() + "\nLoot: " + dungeon.getRoomInfo();
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
