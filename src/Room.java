import java.util.Random;

/**
 * Area for player to enter and grab loot or defeat a monster
 * @author Marquis Kurt
 */
public class Room {
	private int ID;
	private Item loot;
	private Boolean monsterInRoom;
	private Boolean[] doors = new Boolean[4];
	Random rand = new Random();
	/**
	 * Instantiate the object
	 */
	public Room(Player player,int RoomNumber, int MobLevel) {
		ID = RoomNumber;
		Mob mob = new Mob(MobLevel);
		int  n = rand.nextInt(2) + 1;
		if(n==1)
		{
			loot = new Sword(player.level() + 1);
		}
		else
		{
			loot = new Armor(player.level() + 1);
		}
		if(RoomNumber == 0)
		{
			doors[0]=false;
			doors[1]=true;
			doors[2]=false;
			doors[3]=false;
		}
		else if(RoomNumber == 2)
		{
			doors[0]=true;
			doors[1]=false;
			doors[2]=false;
			doors[3]=true;
		}
		else if(RoomNumber == 6)
		{
			doors[0]=true;
			doors[1]=true;
			doors[2]=false;
			doors[3]=false;
		}
		else if(RoomNumber == 1 || RoomNumber == 7 || RoomNumber == 4)
		{
			doors[0]=false;
			doors[1]=true;
			doors[2]=false;
			doors[3]=true;
		}
		else if(RoomNumber == 3)
		{
			doors[0]=true;
			doors[1]=false;
			doors[2]=false;
			doors[3]=true;
		}
		else if(RoomNumber == 5)
		{
			doors[0]=false;
			doors[1]=true;
			doors[2]=true;
			doors[3]=false;
		}
		else 
		{
			doors[0]=false;
			doors[1]=false;
			doors[2]=false;
			doors[3]=true;
		}
		
	}

	/**
	 * Inserts a mob into the room
	 */
	public String insertMob()
	{
		return "The mobs are here.";
	}
	
	public Item getItem()
	{
		return loot;
	}
	
	public void removeItem()
	{
		loot = null;
	}

	/**
	 * Removes a mob from the room
	 */
	public String removeMob()
	{
		return "Mob be gone!";
	}
	
	public Boolean CanMove( int x)
	{
		return this.doors[x];
	}
	
	public Boolean Monster()
	{
		return this.monsterInRoom;
	}
}
