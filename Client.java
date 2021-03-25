import java.util.Arrays;

public class Client {
	
	private String name;
	private String dni;
	private long creditCard;
	private int license;
	private boolean frequent;
	private request[] request;
	private int numberRequest;

	public String getDni() {
		return dni;
	}

	public long getCreditCard() {
		return creditCard;
	}

	public String getName() {
		return name;
	}

	public int getLicense() {
		return license;
	}

	public boolean isFrequent() {
		return frequent;
	}

	public int getNumberRequest() {
		return numberRequest;
	}
	
	public Client(String name, String dni, long creditCard, int license, boolean frequent, request[] request, int numberRequest) {
		this.name = name;
		this.dni = dni;
		this.creditCard = creditCard;
		this.license = license;
		this.frequent = frequent;
		this.request = request;
		this.numberRequest = numberRequest;
	}

	public String showAllInformationRequest(Vehicle hireVehicle) {
		String cadena = " ";
		for (int i = 0; i < numberRequest; i++) {
			if (request[i].is_Automatic(hireVehicle)) {
				cadena = cadena + request[i].toString();
			}
		}
		return cadena;
	}
	
	public void addRequest(Vehicle vehicle, Client client, int hireTime) {
		request[numberRequest] = new request(hireTime, client.getDni(), vehicle);
		numberRequest++;
	}

	//not sure if we will need to introduce the array of request and the number of request in the toString
	public String toString() {
		return "Client [name=" + name + ", dni=" + dni + ", creditCard=" + creditCard + ", license=" + license
				+ ", frequent=" + frequent;
	}
	
}
