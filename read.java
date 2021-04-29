import java.io.*;
import java.util.*;

public class read {

	public static void main(String[] args) throws FileNotFoundException {
		readVehicles("C:\\Vehiculos.txt");
		System.out.println(" ");
		readClients("C:\\Clientes.txt");
	}

	public static Vehicle[] readVehicles(String VehicleFile) throws FileNotFoundException {
		Scanner fileScanner = new Scanner(new File(VehicleFile));
		Vehicle[] listOfVehicles = new Vehicle[10];
		int i = 0;
		while (fileScanner.hasNext()) {
			char type = fileScanner.next().charAt(0);
			String cRegis = fileScanner.next();
			int mileages = fileScanner.nextInt();
			double price = fileScanner.nextDouble();
			String model = fileScanner.next();
			if (type == 'h') {
				int autonomy = fileScanner.nextInt();
				Hybrid hybridCar = new Hybrid(type, cRegis, mileages, price, model, autonomy);
				listOfVehicles[i] = hybridCar;
				i++;
			} else {
				boolean automatic = fileScanner.nextBoolean();
				NotHybrid automaticCar = new NotHybrid(type, cRegis, mileages, price, model, automatic);
				listOfVehicles[i] = automaticCar;
				i++;
			}
		}
		fileScanner.close();
		return listOfVehicles;
	}

	public static Client[] readClients(String VehicleFile) throws FileNotFoundException {
		Scanner fileScanner = new Scanner(new File(VehicleFile));
		Client[] listOfClients = new Client[10];
		int i = 0;
		while (fileScanner.hasNext()) {
			String name = fileScanner.next();
			String dni = fileScanner.next();
			long creditCard = fileScanner.nextLong();
			int license = fileScanner.nextInt();
			boolean frequent = fileScanner.nextBoolean();
			if (frequent == true) {
				int frequentNum = fileScanner.nextInt();
				frequentClient frequentC = new frequentClient(name, dni, creditCard, license, frequent, frequentNum);
				listOfClients[i] = frequentC;
				i++;
			}else {
				Client client = new Client(name, dni, creditCard, license, frequent);
				listOfClients[i] = client;
				i++;
			}
		}
		fileScanner.close();
		return listOfClients;
	}
}
