import java.util.Observable;

public class MudDataModel extends Observable {
	
	private Player thisPlayer;
	private Mob thisMob;
	
	
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
		return thisMob.health();
	}
	
	public int getMobLevel() {
		return thisMob.level();
	}
	
	
	public void setMobHealth(int amount) {
		thisMob.setHealth(amount);
		notifyObservers();
	}
	
	
	// Constructor
	public MudDataModel(Player player, Mob mob) {
		thisPlayer = player;
		thisMob = mob;
	}
}
