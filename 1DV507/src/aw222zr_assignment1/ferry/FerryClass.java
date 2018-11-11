package aw222zr_assignment1.ferry;

import java.util.ArrayList;
import java.util.Iterator;

public class FerryClass implements Ferry {

	final protected int maximumPassengers = 200;
	final protected int maximumSlots = 200;
	public int currentPassengers;
	private int currentSlotsTaken;
	private int numberOfVehiclesTotal;
	protected ArrayList<Vehicle> vehicleArray = new ArrayList<Vehicle>();
	private int[] alreadyEmbarked = new int[200];

	// Cars and passengers which are embarking.
	protected int numberOfCars;
	protected int numberOfBusses;
	protected int numberOfLorries;
	protected int numberOfBicycles;
	protected int carPassengers;
	protected int busPassengers;
	protected int lorryPassengers;
	protected int bicyclePassengers;
	protected int noVehiclePassengers;
	protected int bicycleCount;

	public int countPassengers() {
		return currentPassengers;
	}

	public int countVehicleSpace() {
		int vehicleSpaceUsed = (int) ((numberOfCars * 5) + (numberOfBusses * 20) + (numberOfLorries * 40)
				+ (numberOfBicycles * 1));
		return vehicleSpaceUsed;
	}

	public int countMoney() {
		// Adds all vehicles, vehicle passengers, and passengers together. Then
		// calculates the total sum they payed.

		int carSum = numberOfCars * 100;
		int busSum = numberOfBusses * 200;
		int lorrySum = numberOfLorries * 300;
		int bicycleSum = numberOfBicycles * 40;
		int carPassengerSum = carPassengers * 15;
		int busPassengerSum = busPassengers * 10;
		int lorryPassengerSum = lorryPassengers * 15;
		int noVehiclePassengersSum = noVehiclePassengers * 20;

		int totalSum = carSum + busSum + lorrySum + bicycleSum + carPassengerSum + busPassengerSum + lorryPassengerSum
				+ noVehiclePassengersSum;

		return totalSum;
	}

	public Iterator<Vehicle> iterator() {

		Iterator<Vehicle> test = vehicleArray.iterator();

		return test;
	}

	public void embark(Vehicle vehicleType) {
		// Embarks the various vehicles.
		if (hasSpaceFor(vehicleType) == false) {
			System.out.println("Not enough space for current vehicle wanting to embark. Vehicle returned to void.\n");
			return;
		}

		int vehicleSignature = System.identityHashCode(vehicleType);
		System.out.println("This vehicles signature: " + vehicleSignature);

		for (int i = 0; i < alreadyEmbarked.length; i++) {
			if (alreadyEmbarked[i] == vehicleSignature) {
				System.out.println(
						"Vehicle has already embarked. Create new instance of every vehicle you want to embark.");
				return;
			}
		}

		alreadyEmbarked[numberOfVehiclesTotal] = vehicleSignature;

		int passengersOfVehicle = vehicleType.getPassengers();

		// If checks what kind of vehicle is embarking. Adds the passengers and vehicles
		// to total amount of respective sum.
		// The passengers are also added to the total sum of passengers embarking with
		// respective kind of vehicle.
		// Also adds the vehicle to an array, to be iterated over.
		if (vehicleType instanceof VehicleCar && countVehicleSpace() < maximumSlots - 5) {
			int checkPassengers = passengersOfVehicle + currentPassengers;
			System.out.println("Securitycheck so that passengers are not too many: " + checkPassengers
					+ " passengers on ferry if car passengers embarks.");
			if (checkPassengers <= maximumPassengers) {
				System.out.println("Not too many passengers. Embark.\n");
				carPassengers += passengersOfVehicle;
				currentPassengers += passengersOfVehicle;
				vehicleArray.add(vehicleType);
				numberOfVehiclesTotal++;
				numberOfCars++;
				currentSlotsTaken += 5;
			} else {
				System.out.println("Too many passengers in car. Wait for next ferry.\n");
			}
		} else if (vehicleType instanceof VehicleBus && countVehicleSpace() < maximumSlots - 20) {
			int checkPassengers = passengersOfVehicle + currentPassengers;
			System.out.println("Securitycheck so that passengers are not too many: " + checkPassengers
					+ " passengers on ferry if bus passengers embarks.");
			if (checkPassengers <= maximumPassengers) {
				System.out.println("Not too many passengers. Embark.\n");
				busPassengers += passengersOfVehicle;
				currentPassengers += passengersOfVehicle;
				vehicleArray.add(vehicleType);
				numberOfVehiclesTotal++;
				numberOfBusses++;
				currentSlotsTaken += 20;
			} else {
				System.out.println("Too many passengers in bus. Wait for next ferry.\n");
			}
		} else if (vehicleType instanceof VehicleLorry && countVehicleSpace() < maximumSlots - 40) {
			int checkPassengers = passengersOfVehicle + currentPassengers;
			System.out.println("Securitycheck so that passengers are not too many: " + checkPassengers
					+ " passengers on ferry if lorry passengers embarks.");
			if (checkPassengers <= maximumPassengers) {
				System.out.println("Not too many passengers. Embark.\n");
				lorryPassengers += passengersOfVehicle;
				currentPassengers += passengersOfVehicle;
				vehicleArray.add(vehicleType);
				numberOfVehiclesTotal++;
				numberOfLorries++;
				currentSlotsTaken += 40;
			} else {
				System.out.println("Too many passengers in lorry. Wait for next ferry.\n");
			}
		} else if (vehicleType instanceof VehicleBicycle && countVehicleSpace() < maximumSlots) {
			int checkPassengers = passengersOfVehicle + currentPassengers;
			System.out.println("Securitycheck so that passengers are not too many: " + checkPassengers
					+ " passengers on ferry if bicycle passenger embarks.");
			if (checkPassengers <= maximumPassengers) {
				System.out.println("Not too many passengers. Embark.\n");
				bicyclePassengers += passengersOfVehicle;
				currentPassengers += passengersOfVehicle;
				vehicleArray.add(vehicleType);
				numberOfVehiclesTotal++;
				numberOfBicycles++;
				bicycleCount++;
				currentSlotsTaken += 1;
			} else {
				System.out.println("Too many passengers if more bicycle passengers embarks. Wait for next ferry.\n");
			}
		} else {
			System.out.println("No enough space for this vehicle.\n");
		}
	}

	public void embark(Passenger p) {
		// Embarks, if there is space, passengers who don't arrive with a vehicle.

		if (hasRoomFor(p) == false) {
			System.out.println("No more passengers allowed. Ferry full. Wait for next ferry.\n");
		} else if (hasRoomFor(p) == true) {
			currentPassengers++;
			noVehiclePassengers++;
		}
	}

	public void disembark() {
		// Disembarks all vehicles and passengers.

		System.out.println(
				"\nFerry has left origin port.\n\nFerry has arrived at destination port. All vehicles and passengers disembarking.");
		currentPassengers = 0;
		currentSlotsTaken = 0;
		numberOfVehiclesTotal = 0;
		numberOfCars = 0;
		numberOfBusses = 0;
		numberOfLorries = 0;
		numberOfBicycles = 0;
		carPassengers = 0;
		busPassengers = 0;
		lorryPassengers = 0;
		bicyclePassengers = 0;
		noVehiclePassengers = 0;
		bicycleCount = 0;

		System.out.println("\nDisembarkation complete. Now embarking new passengers and vehicles.");
	}

	public boolean hasSpaceFor(Vehicle vehicleType) {
		// Checks, by using 'instanceof', whether there is space for the vehicle to
		// embark.

		if (vehicleType instanceof VehicleCar && currentSlotsTaken <= 195) {
			return true;
		} else if (vehicleType instanceof VehicleBus && currentSlotsTaken <= 180) {
			return true;
		} else if (vehicleType instanceof VehicleLorry && currentSlotsTaken <= 160) {
			return true;
		} else if (vehicleType instanceof VehicleBicycle && currentSlotsTaken <= 199) {
			return true;
		}
		return false;
	}

	public boolean hasRoomFor(Passenger p) {
		// Checks if there is space for passenger to embark.
		if (currentPassengers < 200) {
			return true;
		}
		return false;
	}

	public String toString() {
		return "\nMaximum number of passengers allowed on ferry: " + maximumPassengers
				+ "\nMaximum number of cars allowed on ferry: " + maximumSlots
				+ "\nCurrent number of passengers who have embarked the ferry: " + currentPassengers
				+ "\nCurrent vehicleslots already occupied: " + currentSlotsTaken
				+ "\nTotal number of vehicles which have embarked: " + numberOfVehiclesTotal
				+ "\nTotal number of cars which have embarked: " + numberOfCars
				+ "\nTotal number of busses which have embarked: " + numberOfBusses
				+ "\nTotal number of lorries which have embarked: " + numberOfLorries
				+ "\nTotal number of bicycles which have embarked: " + numberOfBicycles
				+ "\nTotal number of passengers embarked by car: " + carPassengers
				+ "\nTotal number of passengers embarked by bus: " + busPassengers
				+ "\nTotal number of passengers embarked by lorry: " + lorryPassengers
				+ "\nTotal number of passengers embarked by bicycle: " + bicyclePassengers
				+ "\nTotal number of passengers embarked without vehicle: " + noVehiclePassengers
				+ "\nTotal money earned during this embarkation: " + countMoney() + "\n";
	}
}
