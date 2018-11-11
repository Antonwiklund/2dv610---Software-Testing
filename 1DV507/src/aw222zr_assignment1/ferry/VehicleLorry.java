package aw222zr_assignment1.ferry;

public class VehicleLorry extends Vehicle {

	public VehicleLorry(int passengers) throws Exception {
		if (passengers <= 0) {
			throw new Exception("Can't have 0, or less, passengers in lorry. Enter new integer, and try again.");
		}
		passengersInVehicle = passengers;
	}

	// Add passenger to car.
	public void addPassengerToLorry() throws Exception {
		if (passengersInVehicle >= 2) {
			throw new Exception("Lorry is already full.");
		}
		passengersInVehicle++;
	}

}
