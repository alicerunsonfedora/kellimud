import java.util.Observable;

public class MudDataModel extends Observable {
	
	private Player thisPlayer;
	private Mob thisMob;
	
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
	}
	
	public void upgradePlayerExperience(int amount) {
		thisPlayer.increaseExp(amount);
	}
	
	
	
	public int getMobHealth() {
		return thisMob.health();
	}
	
	public int getMobLevel() {
		return thisMob.level();
	}
	
	
	
	public MudDataModel(Player player, Mob mob) {
		thisPlayer = player;
		thisMob = mob;
	}
}
