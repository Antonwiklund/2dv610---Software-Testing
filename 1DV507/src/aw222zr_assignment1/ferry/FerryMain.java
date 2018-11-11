package aw222zr_assignment1.ferry;

import java.util.Iterator;

public class FerryMain {

	public static void main(String[] args) {

		try {
			// FERRY:
			// Instantiate the ferry.
			FerryClass ferry = new FerryClass();

			// PASSENGER:
			// Create passenger instance, and use the loop to embark the number of
			// passengers you'd like.
			Passenger passenger = new Passenger();

			// Designate to 'passengers', the amount of passengers you'd like.
			// If too many want to embark, they will be told to wait.
			int passengers = 188;
			for (int i = 0; i < passengers; i++) {
				if (ferry.currentPassengers < ferry.maximumPassengers) {
					ferry.embark(passenger);
				} else if (ferry.currentPassengers >= ferry.maximumPassengers) {
					ferry.embark(passenger);
					break;
				}
			}

			Passenger bipolarPassenger = new Passenger();
			ferry.embark(bipolarPassenger);

			// Prints total number of passengers after having embarked:
			System.out.println("Total number of passengers on ferry, after passengers without vehicle's have embarked: "
					+ ferry.currentPassengers + "\n");

			// CAR:
			// Create, manually, new instance of each car you'd like. Enter in parameter the
			// passengers(max 4) of each car.
			VehicleCar car1 = new VehicleCar(3);
			VehicleCar car2 = new VehicleCar(2);
			VehicleCar car3 = new VehicleCar(4);

			// Add one passenger to the first car.
			car1.addPassengerToCar();

			// Let the cars embark.
			ferry.embark(car1);
			ferry.embark(car2);
			ferry.embark(car3);

			// BUS:
			// Create, manually, new instance of each bus you'd like. Enter in parameter the
			// passengers(max 20) of each bus.
			VehicleBus bus1 = new VehicleBus(15);
			VehicleBus bus2 = new VehicleBus(20);

			// Let bus embark.
			ferry.embark(bus1);
			ferry.embark(bus2);

			// LORRY:
			// Create, manually, new instance of each lorry you'd like. Enter in parameter
			// the passengers(max 2) of each lorry.
			VehicleLorry lorry1 = new VehicleLorry(1);
			VehicleLorry lorry2 = new VehicleLorry(2);

			// Let lorry embark.
			ferry.embark(lorry1);
			ferry.embark(lorry2);

			// BICYCLE:
			// Designate to 'bicycles', the amount of bicycles you'd like.
			// If too many want to embark, they will be told to wait.
			int bicycles = 6;
			for (int i = 0; i < bicycles; i++) {
				VehicleBicycle bicycle = new VehicleBicycle(1);
				if (ferry.currentPassengers < ferry.maximumPassengers) {
					ferry.embark(bicycle);
				} else if (ferry.currentPassengers >= ferry.maximumPassengers) {
					ferry.embark(bicycle);
					break;
				}
			}

			// Iterate over all vehicles which have embarked:
			Iterator<Vehicle> vehicleArray = ferry.iterator();

			while (vehicleArray.hasNext()) {
				System.out.println(vehicleArray.next());
			}

			bipolarPassenger.passengerTalksGood();
			bipolarPassenger.passengerTalksBad();

			System.out.println(ferry);
			;

			ferry.disembark();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
