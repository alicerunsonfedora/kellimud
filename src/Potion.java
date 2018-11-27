public class Potion extends Item {
	
	private int power;
	
	public int healPatient(Player player) {
		player.healHealth(power);
		int x = power;
		power = 0;
		return x;
	}

	public int thisPower() {
		return power;
	}
	
	public Potion(int effect, Player patient) {
		super("Heal Potion", "Potion", effect);
		power = effect;
	}
	
}
