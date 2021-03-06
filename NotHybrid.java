public class NotHybrid extends Vehicle {
	private boolean automatic;

	public NotHybrid(char type, String cRegis, int milages, double pricePerDay, String model, boolean automatic) {
		super(type, cRegis, milages, pricePerDay, model);
		this.automatic = automatic;
	}

	public boolean isAutomatic() {
		return automatic;
	}

	public String toString() {
		return "NotHybrid" + super.toString() + "automatic: " + automatic + "\n";
	}

}