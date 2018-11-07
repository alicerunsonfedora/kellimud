import java.util.Scanner;
import static java.lang.System.out;

public class Player {
    Scanner in = new Scanner(System.in);
	private String name,playerclass;
	private int lvl,health,attack,defense,exp;
	private Item hand= new NullItem(),armor = new NullItem();
	private Item[] backpack = new Item[10];
	private int flag;
	public boolean isDead;
	/*
	 * flag is a pointer that shows the last position of the backpack that is empty
	 * 
	 */
	public Player(String aname,String aclass) 
	{
		name = aname;
		playerclass = aclass;
		lvl = 1;
		health = 42;
		attack = 1;
		defense = 0;
		exp = 0;
		flag = 1;
		backpack[0] = new Sword(1);

		for (int i=1; i<10; i++)
		{
			backpack[i] = new NullItem();
		}
	}
	
	public String die()
	{
		isDead = true;
		return "Ya die! Ya die! Ya die! Ya die!";
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
	
	public int[] attack(Dungeon dungeon)
	{
		int damage[] = new int[2];
		damage[1] = dungeon.room().mob().attack(this,dungeon);
		damage[0] = this.attack;
		return damage;
	}

	public int takeDamage(int amount, Dungeon dungeon)
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
		out.println(Characters.narrator.say("Are you sure you want to close the game?"));
		
		while(true)
		{
			String input = in.nextLine();
			if(input.equalsIgnoreCase("yes"))
			{
				out.println(Characters.narrator.say("I guess it's goodbye, then."));
				out.println(Characters.narrator.say("Until we meet again..."));
				return true;
			}
			else if(input.equalsIgnoreCase("no"))
			{
				//Scene.playScene(Scene.confirmGameResume);
				return false;
			}
			else
			{
				System.out.println("yes or no?");
			}
		}
	}
	
	public String move(Dungeon dungeon)
	{
		if(!dungeon.room().MobAlive())
		{
				dungeon.move(this);
				return "Great, you moved to a new room";
		}
		else
		{
			return "There is a mob in the room boyyyyy, where do you think you are going?";
		}
	}
	
	public void equip(Item item)
	{
		if(item.name().equalsIgnoreCase("Sword"))
		{
			hand = item;
			this.attack = 1 + item.getLevel();
		}
		else
		{
			armor = item;
			this.defense = item.getLevel();
		}

	}
	public String info(Dungeon dungeon)
	{
		return "Health: " + this.health() + "\nRoom: " + dungeon.Playerlocation() + "\nLoot: " + dungeon.getRoomInfo();
	}
	public Item hand()
	{
		return hand;
	}
	
	public String armor()
	{
		return armor.name();
	}
	
	public int attackValue()
	{
		return attack;
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
	
	public void increaseExp(int x)
	{
		this.exp = this.exp + x;
		if(this.exp + x >= 25)
		{
			this.lvl = this.lvl + 1;
			this.exp = this.exp - 25;
			//Scene.playScene(Scene.levelUpScene);
		}
		
	}
	
	public void setHealth(int amount) {
		health = amount;
	}
	
	public void setExperience(int amount) {
		exp = amount;
	}
	
	public void setLevel(int amount) {
		lvl = amount;
	}

}
