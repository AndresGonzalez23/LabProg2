public class Hybrid extends Vehicle {
	private int autonomy;

	public int getAutonomy() {
		return autonomy;
	}

	public Hybrid(char type, String cRegis, int milages, double pricePerDay, String model, boolean state, int autonomy) {
		super(type, cRegis, milages, pricePerDay, model, state);
		this.autonomy = autonomy;
	}

	public boolean isAutomatic() {
		boolean automatic = true;
		return automatic;
	}

	public String toString() {
		return "Hybrid" + super.toString() + "autonomy: " + autonomy;
	}

}
