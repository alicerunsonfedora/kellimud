public class Potion extends Item {
	
	private Player myPatient;
	private int power;
	
	@SuppressWarnings("unused")
	private void healPatient() {
		myPatient.healHealth(power);
	}
	
	public Potion(int effect, Player patient) {
		super("Heal Potion", "Potion", effect);
		myPatient = patient;
		power = effect;
	}
	
}
