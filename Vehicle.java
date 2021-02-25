/* Blake Barnes
 * CSC372-PP-OPT2
 * Project Purpose: Demonstrate knowledge of comparators, sort method,
 * LinkedLists, user input loops, file output, and error handling
 *
 * Algorithm Used: Created a Vehicle class with make, model, and MPG
 * attributes. Overrode the default toString() method to
 * customize display output for the vehicles. Implemented a comparator
 * class to sort vehicles by ascending MPG
 *
 * Program Inputs: The make, model, and MPG parameters need to
 * be passed in the instantiation of a Vehicle object. The comparator
 * class requires two Vehicle objects to be passed as parameters
 * to effectively order them.
 *
 * Program Outputs: The comparator class compare() method returns
 * one of three potential values to aid in the selection sort process:
 * -1, 0, or 1. -1 indicates the first object is less than the second
 * object based on the desired sorting method (ascending double).
 * 0 indicates they are equivalent. 1 indicates the first object is
 * greater than the second object being compared. The toString()
 * method is used to format the output of all vehicle object attributes.
 *
 * Program Limitations: I believe these classes appropriately manages
 * all relevant procedures
 *
 * Program Errors: None that I'm aware of
 */

import java.util.Comparator;

public class Vehicle {
	//Private fields for vehicle data
	private String make;
	private String model;
	private double milesPerGallon;

	//Parameterized constructor
	public Vehicle(String make, String model, double milesPerGallon) {
		this.make = make;
		this.model = model;
		this.milesPerGallon = milesPerGallon;
	}

	//Getter methods
	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public double getMilesPerGallon() {
		return milesPerGallon;
	}

	//Override toString() method to print vehicles
	@Override
	public String toString() {
		return "- Make: " + getMake() + ", Model: " + getModel() +
				", MPG: " + getMilesPerGallon();
	}
}

//Comparator class used to sort vehicles by MPG
class MilesPerGallonSort implements Comparator<Vehicle> {
	//compare() method implemented to sort by MPG
	public int compare(Vehicle v1, Vehicle v2) {
		return Double.compare(v1.getMilesPerGallon(), v2.getMilesPerGallon());
	}
}
