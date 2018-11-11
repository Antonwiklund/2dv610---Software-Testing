package aw222zr_assignment1.ferry;

public class VehicleCar extends Vehicle {

	public VehicleCar(int passengers) throws Exception {
		if (passengers <= 0) {
			throw new Exception("Can't have 0, or less, passengers in car. Enter new integer, and try again.");
		}
		passengersInVehicle = passengers;
	}

	// Add passenger to car.
	public void addPassengerToCar() throws Exception {
		if (passengersInVehicle >= 4) {
			throw new Exception("Car is already full.");
		}
		passengersInVehicle++;
	}

}
