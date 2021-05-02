abstract public class Vehicle {

	protected char type;
	protected String cRegis;
	protected int milages;
	protected double pricePerDay;
	protected String model;
	protected boolean state;

	public char getType() {
		return type;
	}

	public String getcRegis() {
		return cRegis;
	}

	public int getMilages() {
		return milages;
	}

	public double getPricePerDay() {
		return pricePerDay;
	}

	public String getModel() {
		return model;
	}

	public boolean isState() {
		return state;
	}

	public Vehicle(char type, String cRegis, int milages, double pricePerDay, String model) {
		this.type = type;
		this.cRegis = cRegis;
		this.milages = milages;
		this.pricePerDay = pricePerDay;
		this.model = model;
		this.state = false;
	}

	abstract public boolean isAutomatic();

	public String toString() {
		return "Vehicle [type=" + type + ", cRegis=" + cRegis + ", milages=" + milages + ", price per day="
				+ pricePerDay + ", model=" + model + ", state=" + state + "]\n";
	}

}
