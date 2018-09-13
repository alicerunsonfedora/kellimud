import java.util.Random;

/**
 * Area for player to enter and grab loot or defeat a monster
 * @author Marquis Kurt
 */
public class Room {
	private int ID;
	private int[] loot;
	private Boolean monsterInRoom;
	private Boolean[] doors = new Boolean[4];

	/**
	 * Instantiate the object
	 */
	public Room(int RoomNumber, int MobLevel) {
		ID = RoomNumber;
	}

	/**
	 * Inserts a mob into the room
	 */
	public String insertMob()
	{
		return "The mobs are here.";
	}

	/**
	 * Removes a mob from the room
	 */
	public String removeMob()
	{
		return "Mob be gone!";
	}

}
