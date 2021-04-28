import java.util.Arrays;
import java.util.Scanner;

public class HireCompany implements IConstants {
	static Scanner keyboard = new Scanner(System.in);
	private String name; 
	private String address; 
	private Vehicle[] listOfVehicles;
	private Client[] listOfClients;
	private int counter = listOfClients.length;

	
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
	
	public int carsHired() {
		int numOfHired = 0;
		for (int i = 0; i<listOfClients.length; i++) {
			if(listOfClients[i].getNumberRequest()>0) {
				numOfHired += listOfClients[i].getNumberRequest();
			}
		}
		return numOfHired;
	}
	public double calculatePriceOfCleaning(CleaningCompany cleaning) {
		double price = 0.0; 
			price += carsHired()*cleaning.getPrice();
		return price; 
	}
	
	public String showAllTheInfoVehiclesForHire() {
		String cadena = " ";
		for (int i = 0; i < listOfVehicles.length; i++) {
			if (listOfVehicles[i].isState() == true) {
				cadena += listOfVehicles[i].isState();
			}
		}
		return cadena;
	}
	
	public void addClient(Client client) {
		int cont = 0;
		for (int i = 0; i < listOfClients.length; i++) {
			cont++;
		}
		listOfClients[cont - 1] = client;
	}
	
	public int searchClient(String dni) {
		int found = -1;
		for (int i = 0; i < listOfClients.length; i++) {
			if (listOfClients[i].getDni().equalsIgnoreCase(dni)) {
				found = i;
			}
		}
		return found;
	}
	
	public int searchForAVehicle(String cRegis) {
		int found = -1;
		for (int i = 0; i < listOfVehicles.length; i++) {
			if (listOfVehicles[i].getcRegis().equalsIgnoreCase(cRegis)) {
				found = i;
			}
		}
		return found;	
	}
	
	public void typeDiscounts(String DNI) {
		for (int i = 0; i< listOfClients.length; i++) {
			if (listOfClients[i].getDni().equals(DNI))
				if (listOfClients[i].getLicense()>=10) {
					System.out.println("You have a discount of 5%");
					if (listOfClients[i].isFrequent() == true){
						System.out.println("You have a discount of 20%");
					}
				}
				if (listOfClients[i].getLicense()>=10 && listOfClients[i].isFrequent() == true) {
					System.out.println("You have a discount of 30%");
				}
			}
		}
	
	public void makeHireRequest() {
		System.out.println("You selected that you want to make a request. Please indicate if you are a new client (n) or an existent one (e)");
		String a = keyboard.next();
		if (a.equalsIgnoreCase("n")) {
			System.out.println("You indicate you are a new client, please fullfill this data");
			System.out.println("Introduce your name");
			System.out.println("Name: ");
			String name = keyboard.next();
			String dni;
			do {
				System.out.println("Introduce 8 digits and a letter for the DNI");
				dni = keyboard.next();
			} while (dni.length() != 9);
			System.out.println("DNI: ");
			System.out.println("Introduce your Credit Car number");
			System.out.println("Credit Card: ");
			long cC = keyboard.nextLong();
			System.out.println("Introduce the number of years since you got your license");
			System.out.println("Years as driver: ");
			int license = keyboard.nextInt();
			Client newClient = new Client(name, dni, cC, license, false, null, 0);
			addClient(newClient);
			System.out.println("Please indicate the car registration number of the car you want to hire");
			String cRegisNum = keyboard.next();
			Vehicle rented = null;
			for (int i = 0; i < listOfVehicles.length; i++) {
				if (listOfVehicles[i].getcRegis().equals(cRegisNum)) {
					rented = listOfVehicles[i];
					System.out.println(listOfVehicles[i].toString());
				}
			}
			System.out.println("How much days do you want to hire it?");
			int days = keyboard.nextInt();
			newClient.addRequest(rented, newClient, days);
		} else if (a.equalsIgnoreCase("e")) {
			Vehicle rented = null;
			Client existentClient = null;
			System.out.println("Introduce the name of the client who wants to rent the car");
			String name = keyboard.next();
			for (int i = 0; i < listOfClients.length; i++) {
				if (listOfClients[i].getName().equalsIgnoreCase(name)) {
					existentClient = listOfClients[i];
					System.out.println(listOfClients[i].toString());
				}
			}
			System.out.println("Please indicate the car registration number of the car you want to hire");
			String cRegisNum = keyboard.next();
			for (int i = 0; i < listOfVehicles.length; i++) {
				if (listOfVehicles[i].getcRegis().equals(cRegisNum)) {
					rented = listOfVehicles[i];
					System.out.println(listOfVehicles[i].toString());
				}
			}
			System.out.println("How much days do you want to hire it?");
			int days = keyboard.nextInt();
			existentClient.addRequest(rented, existentClient, days);
		}
	}
	
	public String toString() {
		return "HireCompany [name=" + name + ", address=" + address + ", listOfVehicles=" + Arrays.toString(listOfVehicles) + ", listOfClients=" + Arrays.toString(listOfClients) + "]";
	}
}