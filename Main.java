import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
	//Selection sort using MilesPerGallonSort class
	public static void sortByMilesPerGallon(LinkedList<Vehicle> vehicles) {
		//Instantiate comparator class
		MilesPerGallonSort milesPerGallonSort = new MilesPerGallonSort();

		int size = vehicles.size();
		int smallIndex;

		for(int i = 0; i < size - 1; i++) {
			//Find index of smallest element in unsorted array
			smallIndex = i;

			for(int j = i + 1; j < size; j++) {

				if(milesPerGallonSort.compare(vehicles.get(j), vehicles.get(smallIndex)) < 0) {
					smallIndex = j;
				}
			}

			//Swap the element at i and determined smallIndex
			Vehicle newSelect = vehicles.get(smallIndex);
			vehicles.set(smallIndex, vehicles.get(i));
			vehicles.set(i, newSelect);
		}
	}

	//Print method leveraging toString() from Vehicle class
	public static void outputVehicles(LinkedList<Vehicle> vehicles) {
		ListIterator<Vehicle> itr = vehicles.listIterator();
		while (itr.hasNext()) {
			Vehicle next = (Vehicle)itr.next();
			System.out.println(next.toString());
		}
	}

	//Output to .txt file print method
	public static void printText(LinkedList<Vehicle> vehicles) throws IOException {
		//Try to open file
		//Error handling if location doesn't exist
		try (FileOutputStream outFile = new FileOutputStream("C:\\Temp\\vehicles-by-mpg.txt")) {
			PrintWriter prtWriter = new PrintWriter(outFile, true);

			ListIterator<Vehicle> itr = vehicles.listIterator();
			while (itr.hasNext()) {
				Vehicle next = (Vehicle)itr.next();
				prtWriter.println(next.toString());
			}

			//Close PrintWriter
			prtWriter.close();
		}
	}

	//Method to validate MPG is a positive double. If invalid, require new input
	//without forcing user to restart from beginning of do-while loop
	public static boolean validateMilesPerGallon(String milesPerGallon) {
		try {
			//Check if input is positive
			if (Double.parseDouble(milesPerGallon) > 0) {
				//if positive, check if it's a valid double
				Double.parseDouble(milesPerGallon);
				return true;
			}
			//if input is negative, invalidate and throw error
			else {
				System.out.println("Enter a positive double");
				return false;
			}
		}

		//Error handling if invalid double
		catch (NumberFormatException e) {
			System.out.println("Enter a valid double");
			return false;
		}
	}

	//Main method
	public static void main(String[] args) {
		LinkedList<Vehicle> vehicles = new LinkedList<Vehicle>();
		Scanner scnr = new Scanner(System.in);
		int numVehicles;
		char userCmmd = '-';

		do {
			try {
				System.out.println("How many vehicles will you be entering?" +
						"\nUp to 10 entries available.");
				numVehicles = scnr.nextInt();
				String blankCatch = scnr.nextLine();

				if (numVehicles <= 0 || numVehicles >= 11) {
					throw new Exception("Enter integer between 1 and 10");
				}

				System.out.println();
				for (int i = 0; i < numVehicles; i++) {
					//Retrieve make
					System.out.print("Vehicle " + (i + 1) + " Make: ");
					String make = scnr.nextLine();

					//Retrieve model
					System.out.print("Vehicle " + (i + 1) + " Model: ");
					String model = scnr.nextLine();

					//Retrieve MPG
					System.out.print("Vehicle " + (i + 1) + " MPG: ");
					String mpgInput = scnr.nextLine();
					//Validate MPG input
					while (!validateMilesPerGallon(mpgInput)) {
						System.out.print("Vehicle " + (i + 1) + " MPG: ");
						mpgInput = scnr.nextLine();
					}
					double milesPerGallon = Double.parseDouble(mpgInput);

					//Create new vehicle object and add to LinkedList
					Vehicle newVehicle = new Vehicle(make, model, milesPerGallon);
					vehicles.add(newVehicle);
					System.out.println();
				}

				//Error handling just in case fewer than desired vehicles is input
				if (vehicles.size() < numVehicles) {
					System.out.print("\nYou did not successfully enter " + numVehicles +  " vehicles."
							+ "\nEnter 'x' to exit program or \nanything else to continue "
							+ "entering vehicles: ");
					userCmmd = scnr.next().charAt(0);
					System.out.println();

					if (userCmmd == 'x') {
						System.out.println("\nGoodbye.");
						System.exit(0);
					}
				}

				else {
					System.out.print("Enter 'p' to print sorted vehicles and exit program.\n"
							+ "Enter anything else re-enter vehicles: ");
					userCmmd = scnr.next().charAt(0);
					blankCatch = scnr.nextLine();
					System.out.println();

					if (userCmmd != 'p') {
						//Delete all elements of ArrayList
						vehicles.clear();
					}
				}

			}

			catch (InputMismatchException e) {
				System.out.println("Invalid input. Try again");
				String blankCatch = scnr.nextLine();
				System.out.println();
			}

			catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println();
			}

		}

		while(userCmmd != 'p');

		//Print unsorted LinkedList
		System.out.println("You entered the following vehicles:\n");
		outputVehicles(vehicles);

		//Sort LinkedList using comparator class and selection sort method
		sortByMilesPerGallon(vehicles);
		//Display newly sorted output
		System.out.println("\nSorted by MPG:\n");
		outputVehicles(vehicles);

		System.out.println("\nPrinting sorted vehicles to 'C:\\Temp\\vehicles-by-mpg.txt'...");
		//Output to vehicles.txt file
		try {
			printText(vehicles);
			System.out.println("Successfully printed vehicles!");
		}
		catch (Exception e) {
			System.out.println("\n" + e.getMessage());
			System.out.println("\tUnable to print vehicles\n\t"
					+ "Please create folder location 'C:\\Temp\\' and try again");
		}

		System.out.println("\nGoodbye");

	}

}
