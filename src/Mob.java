import java.util.Random;

public class Mob {

	private int lvl,health,attack,defense;

	public Mob(int level) 
	{
		lvl = 1;
		health = 10*lvl;
		attack = lvl;
		defense = lvl;
	}
	
	public int attack(Player player)
	{
		Random damagePoint = new Random();
		int attackLevel = damagePoint.nextInt(2);
		player.takeDamage(attackLevel);
		return attackLevel;
	}
	
	public int takeDamage(int amount)
	{
		this.health -= amount;
		if (this.health <= 0)
		{
			this.die();
			return 0;
		}
		else
		{
			return health;
		}
	}

	public void die()
	{
		Scene.playScene(Scene.mobDieScene);
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
}

/*
 _________________________________________
< Excuse me, what the fuck are you doing? >
 -----------------------------------------
        \   ^__^
         \  (oo)\_______
            (__)\       )\/\
                ||----w |
                ||     ||
 */