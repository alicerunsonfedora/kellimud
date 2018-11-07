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
		int x;
		int damage[] = new int[2];
		if(thisDungeon.room().MobAlive())
		{
		damage = thisPlayer.attack(thisDungeon);
		}
		setChanged();
        notifyObservers();
	}
	
	public void move()
	{
		thisPlayer.move(thisDungeon);
		setChanged();
        notifyObservers();
	}
	
	public void heal()
	{
		thisDungeon.UsePotion();
		setChanged();
        notifyObservers();
	}
	public void equip()
	{
		thisPlayer.equip(thisDungeon.room().getLoot());
		setChanged();
        notifyObservers();
	}

	
	public void healPlayerHealth(int amount) {
		thisPlayer.healHealth(amount);
		setChanged();
		notifyObservers();
	}
	
	public void upgradePlayerExperience(int amount) {
		thisPlayer.increaseExp(amount);
		setChanged();
		notifyObservers();
	}
	
	public void setPlayerHealth(int amount) {
		thisPlayer.setHealth(amount);
		setChanged();
		notifyObservers();
	}
	
	public void setPlayerExperience(int amount) {
		thisPlayer.setExperience(amount);
		setChanged();
		notifyObservers();
	}
	
	public void setPlayerLevel(int amount) {
		thisPlayer.setLevel(amount);
		setChanged();
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
