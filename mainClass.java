import java.io.*;
import java.util.*;

public class mainClass {
	static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args){
		System.out.println("Please indicate the route of the vehicles file\n Please indicate the route of the clients file");
		String vehicleRoute = "";
		String clientRoute = "";
		Vehicle[] listOfVehicles = null;
		Client[] listOfClients = null;
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
		HireCompany hCompany = new HireCompany("Carso", "Espa�a", listOfVehicles, listOfClients);
		
	}
	
	public static void menu(Vehicle[] listOfVehicles, Client[] listOfClients, HireCompany hCompany) {
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
					if (option < 1 || option > 8); //excepcion para controlar que el numero este dentro de un rango;
				}catch (InputMismatchException e) {
					System.out.println("Introduce a number");
					keyboard.next(); //necesario para que no se meta en un bucle infinito
				}
			}while(!validNumber);
		}
		switch(option) {
		case 0: 
			break;
		case 1:
			System.out.println(hCompany.showAllInfoVehicles());
			break;
			
		}
	}
}