import java.util.Arrays;
import java.util.Scanner;

public class HireCompany implements IConstants {
	static Scanner keyboard = new Scanner(System.in);
	private String name;
	private String address;
	private Vehicle[] listOfVehicles;
	private Client[] listOfClients;
	private int contador = 10;

	public HireCompany(String name, String address, Vehicle[] listOfVehicles, Client[] listOfClients) {
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

	public int getContador() {
		return contador;
	}

	public int carsHired() {
		int numOfHired = 0;
		for (int i = 0; i < listOfVehicles.length; i++) {
			if (listOfClients[i].getNumberRequest() > 0) {
				numOfHired += listOfClients[i].getNumberRequest();
			}
		}
		return numOfHired;
	}

	public double calculatePriceOfCleaning(CleaningCompany cleaning) {
		double price = 0.0;
		price += carsHired() * cleaning.getPrice();
		return price;
	}

	public String showAllInfoVehicles() {
		String cadena = " ";
		for (int i = 0; i < listOfVehicles.length; i++) {
			cadena += listOfVehicles[i].toString();
		}
		return cadena;
	}

	public String showAllTheInfoVehiclesForHire() {
		String cadena = " ";
		for (int i = 0; i < listOfVehicles.length; i++) {
			if (listOfVehicles[i].isState() == true) {
				cadena += listOfVehicles[i].getcRegis();
			}
		}
		return cadena;
	}

	public String showAllInformationRequestOfAClient(String iD, int posicion) {
		String cadena = " ";
				cadena += listOfClients[posicion].toStringRequest();
		return cadena;
	}

	public void addClient(Client client) {
		listOfClients[contador] = client;
		contador++;
	}

	public int searchClient(String dni) {
		int found = -1;
		for (int i = 0; i < contador; i++) {
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

	public int typeDiscounts(String DNI) {
		int discount = 0;
		for (int i = 0; i < contador; i++) {
			if (listOfClients[i].getDni().equals(DNI)) {
				if (listOfClients[i].getLicense() >= 10 && listOfClients[i].isFrequent() == true) {
					discount = 3;
				} else if (listOfClients[i].getLicense() >= 10) {
					discount = 1;
				} else if (listOfClients[i].isFrequent() == true) {
					discount = 2;
				}
			}
		}
		return discount;
	}

	public String toString() {
		return "HireCompany [name=" + name + ", address=" + address + ", listOfVehicles="
				+ Arrays.toString(listOfVehicles) + ", listOfClients=" + Arrays.toString(listOfClients) + "]";
	}
}