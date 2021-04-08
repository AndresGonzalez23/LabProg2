import java.util.Arrays;

public class HireCompany {
	
	private String name; 
	private String address; 
	private Vehicle[] listOfVehicles;
	private Client[] listOfClients;
	private int counterOfClients; 	
	
	
	public HireCompany(String name, String address, Vehicle[] listOfVehicles, Client[] listOfClients) {
		super();
		this.name = name;
		this.address = address;
		this.listOfVehicles = listOfVehicles;
		this.listOfClients = listOfClients;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Vehicle[] getListOfVehicles() {
		return listOfVehicles;
	}
	
	public void setListOfVehicles(Vehicle[] listOfVehicles) {
		this.listOfVehicles = listOfVehicles;
	}
	
	public Client[] getListOfClients() {
		return listOfClients;
	}
	
	public void setListOfClients(Client[] listOfClients) {
		this.listOfClients = listOfClients;
	}
	
	public int carsHired(Vehicle vehicle) {
		int numOfHired = 0;
		for (int i = 0; i<listOfVehicles.length; i++) {
			numOfHired++;
		}
		return numOfHired;
	}
	public double calculatePriceOfCleaning(int numOfHired, CleaningCompany cleaning) {
		double price = 0.0; 
			price = numOfHired*cleaning.getPrice();
		return price; 
	}

	public String toString() {
		return "HireCompany [name=" + name + ", address=" + address + ", listOfVehicles=" + Arrays.toString(listOfVehicles) + ", listOfClients=" + Arrays.toString(listOfClients) + "]";
	}
}
