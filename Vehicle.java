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
