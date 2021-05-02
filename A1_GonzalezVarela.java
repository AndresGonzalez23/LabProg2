import java.io.*;
import java.util.*;

public class A1_GonzalezVarela implements IConstants {
	static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) throws FileNotFoundException, IOException {
		boolean continueDo = true;
		System.out.println("Please indicate the route of the vehicles file\nPlease indicate the route of the clients file");
		String vehicleRoute = "";
		String clientRoute = "";
		Vehicle[] listOfVehicles = null;
		Client[] listOfClients = new Client[20];

		try {
			vehicleRoute = keyboard.next();
			clientRoute = keyboard.next();
			listOfVehicles = read.readVehicles(vehicleRoute);
			listOfClients = read.readClients(clientRoute);
		} catch (FileNotFoundException e) {
			System.out.println("The file has not been found on your PC");
		} catch (IOException e) {
			System.out.println(" ");
		}
		CleaningCompany cCompany = new CleaningCompany("The Cleanest One", 35.00);
		HireCompany hCompany = new HireCompany("Carso", "España", listOfVehicles, listOfClients);
		do {
			menu(listOfVehicles, listOfClients, hCompany, cCompany);
		} while (continueDo == true);
	}

	public static void menu(Vehicle[] listOfVehicles, Client[] listOfClients, HireCompany hCompany,
			CleaningCompany cCompany) {
		int option = 0;
		boolean endProgram = true, validNumber = false;
		System.out.println("/////////////////////////////////////");
		System.out.println("WELCOME TO CARSO CAR HIRE SYSTEM");
		System.out.println("/////////////////////////////////////");
		while (endProgram) {
			do {
				System.out.println("Please choose what you want to do: \n0. Exit \n1. Show all the information about the vehicles \n2. Make a request for hire a vehicle \n3. Show all the vehicles hired for a customer \n4. Show all the information relative to a request made by a customer \n5. Show all the information about the automatic cars contracted by a customer \n6. Show the discount available for a customer \n7. Show the cost of cleaning all the hired vehicle");
				try {
					option = keyboard.nextInt();
					validNumber = true;
					if (option < 0 || option > 7)
						throw new OutOfRange("This option is out of the limit");
				} catch (InputMismatchException e) {
					System.out.println("Invalid value");
					keyboard.next(); // necesario para que no se meta en un bucle infinito
				} catch (OutOfRange e) {
					System.out.println(e.getMessage());
				}
			} while (!validNumber);
			switch (option) {
			case 0:
				System.out.println("End of the program");
				System.exit(0);
				break;
			case 1:
				System.out.println(hCompany.showAllInfoVehicles());
				break;
			case 2:
				System.out.println("You selected that you want to make a request. Please indicate if you are a new client (n) or an existent one (e)");
				String a = keyboard.next();
				if (a.equalsIgnoreCase("n")) {
					registerAClient(hCompany);
					makeRequest(listOfClients, listOfVehicles, hCompany);
				} else if (a.equalsIgnoreCase("e")) {
					makeRequest(listOfClients, listOfVehicles, hCompany);
				}
				break;
			case 3:
				System.out.println("Which client requests do you want to ask for? \nPlease introduce it's DNI");
				String DNI = keyboard.next();
				int client = hCompany.searchClient(DNI);
				if (client == -1) {
					System.out.println("This client does not exist ");
					break;
				} else {
					for (int i = 0; i < hCompany.getContador(); i++) {
						if (i == client) {
							System.out.println(listOfClients[i].getNumberRequest());
						}
					}
					break;
				}
			case 4:
				System.out.println("Which client requests do you want to ask for? \nPlease introduce it's DNI");
				String Dni = keyboard.next();
				int client1 = hCompany.searchClient(Dni);
				if (client1 == -1) {
					System.out.println("This client does not exist");
					break;
				} else {
							System.out.println(hCompany.showAllInformationRequestOfAClient(Dni, client1));
				}
				break;
			case 5:
				System.out.println("Which client automatic vehicles do you want to check? \nPlease introduce the DNI");
				String dni1 = keyboard.next();
				int client2 = hCompany.searchClient(dni1);
				if (client2 == -1) {
					System.out.println("This client does not exist");
					break;
				} else {
					for (int i = 0; i < hCompany.getContador() - 1; i++) {
						if (i == client2) {
							if (listOfClients[i].isFrequent() == true) {
								if (listOfClients[i].getRequest().length == 0) {
									System.out.println("This client has no request");
								} else {
									System.out.println(listOfClients[i].showAutomaticRequest());
								}
							} else {
								System.out.println("This client is not frequent\n");
							}
						}
					}
				}
				break;
			case 6:
				System.out.println("Which customers discounts do you to check? \nPlease introduce the DNI");
				String dni = keyboard.next();
				int client3 = hCompany.searchClient(dni);
				if (client3 == -1) {
					System.out.println("This client does not exist\n");
					break;
				} else {
					for (int i = 0; i < hCompany.getContador(); i++) {
						if (i == client3) {
							int discount = hCompany.typeDiscounts(dni);
							if (discount == 1) {
								System.out.println("You have a discount of " + SENIORDISCOUNT);
							} else if (discount == 2) {
								System.out.println("You have a discount of " + FREQUENTDISCOUNT);
							} else if (discount == 3) {
								System.out.println("You have a discount of " + SENIORFREQUENTDISCOUNT);
							}
						}
					}
				}
				break;
			case 7:
				System.out.println(hCompany.calculatePriceOfCleaning(cCompany));
				break;
			}
		}
	}

	public static void registerAClient(HireCompany hCompany) {
		System.out.println("You indicate you are a new client, please fullfill this data");
		System.out.println("Introduce your name");
		System.out.println("Name: ");
		String name = keyboard.next();
		String dni;
		do {
			System.out.println("Introduce 8 digits and a letter for the DNI");
			System.out.println("DNI: ");
			dni = keyboard.next();
		} while (dni.length() != 9);
		System.out.println("Introduce your Credit Car number");
		System.out.println("Credit Card: ");
		long cC = keyboard.nextLong();
		if (cC < 16 || cC > 16) {
			System.out.println("Please introduce a number of 16 digits");
			cC = keyboard.nextLong();
		}
		System.out.println("Introduce the number of years since you got your license");
		System.out.println("Years as driver: ");
		int license = keyboard.nextInt();
		Client newClient = new Client(name, dni, cC, license, false);
		hCompany.addClient(newClient);
	}

	public static void makeRequest(Client[] listOfClients, Vehicle[] listOfVehicles, HireCompany hCompany) {
		Vehicle rented = null;
		Client existentClient = null;
		String dni = " ";
		
		do {
			System.out.println("Introduce the DNI of the client who wants to rent the car");
			dni = keyboard.next();
			int client = hCompany.searchClient(dni);
			if (client==-1) {
				System.out.println("This client does not exist");
			}else {
				for (int i = 0; i < hCompany.getContador(); i++) {
					if (i == client) {
						if (listOfClients[i].getDni().equalsIgnoreCase(dni)) {
							existentClient = listOfClients[i];
							System.out.println(listOfClients[i].toString());
						}
					}
					
				}		
			}
		}while (dni.length() != 9);
		System.out.println("This is the list of vehicles that are available to hire\n");
		System.out.println(hCompany.showAllInfoVehicles());
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
		existentClient.addRequest(rented, days);
		System.out.println("The request for hiring has been hired succesfully");
	}

}

