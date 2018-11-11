package aw222zr_assignment1.ferry;

public class VehicleBus extends Vehicle {

	public VehicleBus(int passengers) throws Exception {
		if (passengers <= 0) {
			throw new Exception("Can't have 0, or less, passengers in bus. Enter new integer, and try again.");
		}
		passengersInVehicle = passengers;
	}

	// Add passenger to car.
	public void addPassengerToBus() throws Exception {
		if (passengersInVehicle >= 20) {
			throw new Exception("Bus is already full.");
		}
		passengersInVehicle++;
	}

}
