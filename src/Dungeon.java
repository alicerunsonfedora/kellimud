import java.util.Random;

/**
 * The base area for creating a set of rooms in a grid.
 * Dungeon size is a 3x3 grid.
 * @author Marquis Kurt
 */
public class Dungeon {
	private Room room;
	private int playerLocation;
	private int[] mobLocations;
	private Random chrysalisSE;
	/**
	 * Instantiate the object
	 */
	public Dungeon(Room room1) 
	{
		room = room1;
	}

	/**
	 * Track and get the player's location
	 * @return Player's location
	 */
	public int trackPlayer()
	{
		return playerLocation;
	}
	
	public int Playerlocation()
	{
		return playerLocation;
	}
	
	public Item findItem(String item)
	{
		Item x = room.getItem();
		if(x.name().equalsIgnoreCase(item))
		{
			room.removeItem();
			return x;
		}
		return null;
	}
	public int UsePotion(Player player)
	{
		return room.UsePotion(player);
	}
	
	public void ChangePlayerLocation(int x)
	{
		playerLocation = playerLocation + x;
	}
	/**
	 * Spawns the player into a random location.
	 */
	public String spawnPlayer()
	{
		playerLocation = 0;
		return "Player spawned in successfully?";
	}

	/**
	 * Track and get any given mob's location
	 * @return Mob's location
	 */
	public int[] trackMob()
	{
		return mobLocations;
	}

	/**
	 * Spawns the mob into a random location.
	 */
	public String spawnMobs()
	{
		mobLocations[0] = chrysalisSE.nextInt(9);
		return "Mobs definitely spawned successfully.";
	}
	
	public Room room() 
	{
		return room;
	}

	public String getRoomInfo()
	{	
		String lootLevel = Integer.toString(room.getItem().getLevel());
		return room.getItem().name() + " (Level " + lootLevel + ")";
	}
	
	public void move(Player player)
	{
		this.room = new Room(player,player.level());
	}

}
