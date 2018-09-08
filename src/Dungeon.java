import java.util.ArrayList;
import java.util.Random;

/**
 * The base area for creating a set of rooms in a grid.
 * Dungeon size is a 3x3 grid.
 * @author Marquis Kurt
 */
public class Dungeon {
	private int[] rooms = new int[9];
	private int playerLocation;
	private int[] mobLocations;
	private Random chrysalisSE;
	/**
	 * Instantiate the object
	 */
	public Dungeon() {

	}

	/**
	 * Track and get the player's location
	 * @return Player's location
	 */
	public int trackPlayer()
	{
		return playerLocation;
	}

	/**
	 * Spawns the player into a random location.
	 */
	public void spawnPlayer()
	{
		playerLocation = 0;
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
	public void spawnMobs()
	{
		mobLocations[0] = chrysalisSE.nextInt(9);
	}

}
