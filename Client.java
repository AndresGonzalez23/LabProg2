import java.util.Arrays;

public class Client {
	
	private String name;
	private String dni;
	private long creditCard;
	private int license;
	private boolean frequent;
	private Request[] request;
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
	
	public Client(String name, String dni, long creditCard, int license, boolean frequent, Request[] request, int numberRequest) {
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
		request[numberRequest] = new Request(hireTime, client.getDni(), vehicle);
		numberRequest++;
	}
	
	public double calculateDiscount(int license, boolean frequent) {
		double discount = 0;
		if (license >= 10) {
			discount = 0.05;
			if (frequent == true) {
				discount = discount + 0.2;
			}
		}
		if (license >= 10 && frequent == true) {
			discount = 0.3;
		}
		return discount;
	}

	public int getNumberAutomaticsRequest(Request[] Request, Vehicle hireVehicle) {
		int cont = 0;
		for (int i = 0; i < Request.length; i++) {
			if (request[i].is_Automatic(hireVehicle)) { // esto sera subjetivo de cambios ya que aqui solo comprobamos un vehiculo
				cont++;
			}
		}
		return cont;
	}
	
	public int countAutomatic(Vehicle vehicle) {
		int cont = 0;
		if(vehicle.isAutomatic()) {
			cont++;
		}
		return cont;
	}
	public String toString() {
		return "Client [name=" + name + ", dni=" + dni + ", creditCard=" + creditCard + ", license=" + license
				+ ", frequent=" + frequent + ", request=" + Arrays.toString(request) + ", numberRequest="
				+ numberRequest + "]";
	}
	
}