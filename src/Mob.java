import java.util.Random;

public class Mob {

	private int lvl,health,attack,defense;

	public Mob(int level) 
	{
		lvl = level;
		health = 10*lvl;
		attack = lvl;
		defense = lvl;
	}
	
	public int attack(Player player, Dungeon dungeon)
	{
		Random damagePoint = new Random();
		int attackLevel = damagePoint.nextInt(attack);
		player.takeDamage(attackLevel,dungeon);
		this.takeDamage(player.attackValue(),player,dungeon);
		return attackLevel;
	}
	
	public int takeDamage(int amount,Player player,Dungeon dungeon)
	{
		this.health -= amount;
		if (this.health <= 0)
		{
			this.die(player,dungeon);
			return 0;
		}
		else
		{
			return health;
		}
	}

	public void die(Player player,Dungeon dungeon)
	{
		Scene.playScene(Scene.mobDieScene);
		dungeon.room().MobDied();
		player.increaseExp(5);
	}
	
	public String move()
	{
		return "The mob moved in a particular direction.";
	}
	
	public Boolean dead()
	{
		if(this.health <= 0)
		{
			return true;
		}
		return false;
	}

	public int health()
	{
		return health;
	}

	public int level()
	{
		return lvl;
	}
	
	public void setHealth(int amount) {
		health = amount;
	}
}