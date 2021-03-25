import java.io.*;
import java.util.*;

public class read {

	public static void main(String[] args) throws FileNotFoundException {
		readVehicles("C:\\Vehiculos.txt");
		System.out.println(" ");
		readClients("C:\\Clientes.txt");
	}

	public static void readVehicles(String VehicleFile) throws FileNotFoundException {
		Scanner fileScanner = new Scanner(new File(VehicleFile));
		while (fileScanner.hasNext()) {
			char type = fileScanner.next().charAt(0);
			String cRegis = fileScanner.next();
			int mileages = fileScanner.nextInt();
			double price = fileScanner.nextDouble();
			String model = fileScanner.next();
			System.out.print(type + " " + cRegis + " " + mileages + " " + price + " " + price + " " + model + " ");
			if (type == 'h') {
				int autonomy = fileScanner.nextInt();
				System.out.println(autonomy);
			} else {
				boolean automatic = fileScanner.nextBoolean();
				System.out.println(automatic);
			}
		}
		fileScanner.close();
	}

	public static void readClients(String VehicleFile) throws FileNotFoundException {
		Scanner fileScanner = new Scanner(new File(VehicleFile));
		while (fileScanner.hasNext()) {
			String name = fileScanner.next();
			String dni = fileScanner.next();
			long creditCard = fileScanner.nextLong();
			int license = fileScanner.nextInt();
			boolean frequent = fileScanner.nextBoolean();
			System.out.print(name + " " + dni + " " + creditCard + " " + license + " " + frequent + " ");
			if (frequent == true) {
				int frequentNum = fileScanner.nextInt();
				System.out.println(frequentNum);
			}else {
				System.out.println();
			}
		}
		fileScanner.close();
	}
}
