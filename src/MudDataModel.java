import java.util.Observable;

public class MudDataModel extends Observable {
	
	private Player thisPlayer;
	private Dungeon thisDungeon;
	
	/*
	 * GET/SET for PLAYER 
	 */
	
	public int getPlayerHealth() {
		return thisPlayer.health();
	}
	
	public int getPlayerLevel() {
		return thisPlayer.level();
	}
	
	public int getPlayerExperience() {
		return thisPlayer.exp();
	}
	
	public void attack()
	{
		int damage[] = new int[2];
		if(thisDungeon.room().MobAlive())
		{
		damage = thisPlayer.attack(thisDungeon);
		}
        notifyObservers();
	}
	
	public void heal()
	{
		thisDungeon.UsePotion();
        notifyObservers();
	}
	public void equip()
	{
		thisPlayer.manage_inventory("pick up", thisDungeon.room().getItem().name(),thisDungeon);
		thisPlayer.equip(thisDungeon.room().getItem().name());
        notifyObservers();
	}

	
	public void healPlayerHealth(int amount) {
		thisPlayer.healHealth(amount);
		notifyObservers();
	}
	
	public void upgradePlayerExperience(int amount) {
		thisPlayer.increaseExp(amount);
		notifyObservers();
	}
	
	public void setPlayerHealth(int amount) {
		thisPlayer.setHealth(amount);
		notifyObservers();
	}
	
	public void setPlayerExperience(int amount) {
		thisPlayer.setExperience(amount);
		notifyObservers();
	}
	
	public void setPlayerLevel(int amount) {
		thisPlayer.setLevel(amount);
		notifyObservers();
	}
	
	
	/* 
	 * GET/SET for MOB 
	 */
	
	public int getMobHealth() {
		return 	thisDungeon.room().mob().health();
	}
	
	public int getMobLevel() {
		return 	thisDungeon.room().mob().level();
	}
	
	
	public void setMobHealth(int amount) {
		thisDungeon.room().mob().setHealth(amount);
		notifyObservers();
	}
	
	
	// Constructor
	public MudDataModel(Player player,Dungeon dungeon) {
		thisPlayer = player;
		thisDungeon = dungeon;
	}
}
