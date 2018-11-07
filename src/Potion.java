public class Potion extends Item {
	
	private Player myPatient;
	private int power;
	
	public int healPatient() {
		myPatient.healHealth(power);
		int x = power;
		power = 0;
		return x;
	}

	public int thisPower() {
		return power;
	}
	
	public Potion(int effect, Player patient) {
		super("Heal Potion", "Potion", effect);
		myPatient = patient;
		power = effect;
	}
	
}
