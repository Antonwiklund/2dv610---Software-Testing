package aw222zr_assignment1.ferry;

public class VehicleBicycle extends Vehicle {

	public VehicleBicycle(int passengers) throws Exception {
		if (passengers <= 0) {
			throw new Exception("Can't have 0, or less, passengers on bicycle. Enter new integer, and try again.");
		}
		passengersInVehicle = passengers;
	}
}
