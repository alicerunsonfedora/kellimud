import java.util.Random;

/**
 * The base area for creating a set of rooms in a grid.
 * Dungeon size is a 3x3 grid.
 * @author Marquis Kurt
 */
public class Dungeon {
	private Room[] rooms = new Room[9];
	private int playerLocation;
	private int[] mobLocations;
	private Random chrysalisSE;
	/**
	 * Instantiate the object
	 */
	public Dungeon(Room[] RoomArray) 
	{
		rooms = RoomArray;
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
		Item x = rooms[playerLocation].getItem();
		if(x.name().equalsIgnoreCase(item))
		{
			rooms[playerLocation].removeItem();
			return x;
		}
		return null;
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

	public String getRoomInfo()
	{	
		String lootLevel = Integer.toString(rooms[playerLocation].getItem().getLevel());
		return rooms[playerLocation].getItem().name() + " (Level " + lootLevel + ")";
	}

}
