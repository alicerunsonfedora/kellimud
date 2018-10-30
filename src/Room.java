import java.util.Random;

/**
 * Area for player to enter and grab loot or defeat a monster
 * @author Marquis Kurt
 */
public class Room {
	private Item loot;
	private Boolean monsterInRoom;
	private Boolean[] doors = new Boolean[4];
	private Mob mob;
	Random rand = new Random();
	/**
	 * Instantiate the object
	 */
	public Room(Player player, int MobLevel) {
		monsterInRoom = true;
		mob = new Mob(MobLevel);
		int  n = rand.nextInt(2) + 1;
		if(n==1)
		{
			loot = new Sword(player.level() + 1);
		}
		else
		{
			loot = new Armor(player.level() + 1);
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
	
	public Boolean MobAlive()
	{
		if(mob.dead())
		{
			monsterInRoom = false;
		}
		return this.monsterInRoom;
	}
	
	public Mob mob()
	{
		return mob;
	}
}
