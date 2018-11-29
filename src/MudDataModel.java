import java.util.Observable;
import javax.swing.JOptionPane;

public class MudDataModel extends Observable {
	
	private Player thisPlayer;
	private Dungeon thisDungeon;

	public boolean shouldChangeBackground;
	
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
			setChanged();
			notifyObservers();
		} else {
			JOptionPane.showMessageDialog(null, "Hey! You did nothing!", "Attack Error", JOptionPane.ERROR_MESSAGE);
		}

	}
	
	public void move()
	{
		thisPlayer.move(thisDungeon);
		JOptionPane.showMessageDialog(null, "Moved to new room successfully!", "New Room", JOptionPane.INFORMATION_MESSAGE);
		shouldChangeBackground = true;
		setChanged();
        notifyObservers();
	}
	
	public void heal()
	{
		if (thisDungeon.room().potionInRoom().thisPower() != 0) {
			JOptionPane.showMessageDialog(null, "You healed up to " + thisDungeon.room().UsePotion() + " health points!", "Heal Successful", JOptionPane.INFORMATION_MESSAGE);
			setChanged();
			notifyObservers();
		} else {
			JOptionPane.showMessageDialog(null, "You already used the heal potion!", "Heal Error", JOptionPane.ERROR_MESSAGE);
		}

	}
	public void equip()
	{
		thisPlayer.equip(thisDungeon.room().getLoot());
		JOptionPane.showMessageDialog(null, "You equipped a/an " + thisDungeon.room().getLoot().name() + "!", "Equip Successful", JOptionPane.INFORMATION_MESSAGE);
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
		if (thisPlayer.health() <= 0) {
			thisPlayer.die();
		}
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

	public Dungeon getThisDungeon() {
		return thisDungeon;
	}
	
	
	// Constructor
	public MudDataModel(Player player,Dungeon dungeon) {
		thisPlayer = player;
		thisDungeon = dungeon;
		shouldChangeBackground = false;
	}
}
