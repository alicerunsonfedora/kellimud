
public class Mob {

	private int lvl,health,attack,defense;
	
	public Mob(int level) 
	{
		lvl = 1;
		health = 10*lvl;
		attack = lvl;
		defense = lvl;
	}
	
	public String attack()
	{
		return "The mob has attacked.";
	}
	
	public String die()
	{
		return "The mob died!";
	}
	
	public String move()
	{
		return "The mob moved in a particular direction.";
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