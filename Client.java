import java.util.Arrays;

public class Client implements IConstants {

	private String name;
	private String dni;
	private long creditCard;
	private int license;
	private boolean frequent;
	private Request[] request = new Request[10];
	private int numberRequest = 0;

	public Request[] getRequest() {
		return request;
	}

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

	public Client(String name, String dni, long creditCard, int license, boolean frequent) {
		this.name = name;
		this.dni = dni;
		this.creditCard = creditCard;
		this.license = license;
		this.frequent = frequent;
	}

	public void addRequest(Vehicle vehicle, int hireTime) {
		request[numberRequest] = new Request(hireTime, dni, vehicle);
		numberRequest++;
	}

	public double calculateDiscount() {
		double discount = 0;
		if (license >= 10) {
			discount = SENIORDISCOUNT;
			if (frequent == true) {
				discount = discount + FREQUENTDISCOUNT;
			}
		}
		if (license >= 10 && frequent == true) {
			discount = SENIORFREQUENTDISCOUNT;
		}
		return discount;
	}

	public String showAutomaticRequest() {
		String cadena = " ";
		for (int i = 0; i < numberRequest; i++) {
			if (this.request[i].is_Automatic() == true) {
				cadena += request[i].toString();
			}
		}
		return cadena;
	}

	public String toStringRequest() {
		String cadena = " ";
		for (int i = 0; i < numberRequest; i++) {
			cadena += request[i].toString() + "\n";
		}
		return cadena;
	}

	public int countAutomatic(Vehicle vehicle) {
		int cont = 0;
		if (vehicle.isAutomatic()) {
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