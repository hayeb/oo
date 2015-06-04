package OO14route66;

/**
 * Het werkt aardig, maar zoals je ziet gaan er nog een apar dingen fout (auto's blijven niet in dezelfde volgorde, etc).
 * 
 * @author hbohm
 *
 */
public class Driver implements Runnable {

	private Car car;
	private Model m;
	private Car closest;
	private boolean reversed = false;

	public Driver(Model model, Car car) {
		this.car = car;
		this.m = model;

	}

	@Override
	public void run() {
		while (true) {
			// Bepaal de eerste keer welke auto er voor je zit
			
				getClosestCar(car);
			

			// System.out.println("Closest location: " + closest.getLocation());
			// System.out.println("Car location: " + car.getLocation() +
			// "\n\n");

			// Bij de voorste auto zit er geen auto voor.
			if (reversed) {
				if (closest.getLocation() - car.getLocation() - Car.CARLENGTH < 0) {
					car.setFree(true);
				}
			} else {
				if (closest.getLocation() - car.getLocation() - Car.CARLENGTH < Car.MINCARSPACE) {
					car.setFree(false);
				} else {
					car.setFree(true);
				}

			}

		}
	}

	/**
	 * Return the car which is the closest to car c, facing the same direction
	 * and in front of car c.
	 * 
	 * @param c
	 */
	private synchronized void getClosestCar(Car c) {
		closest = null;
		int distance = 10000;
		if (c.getNumber() == 2 || c.getNumber() == 3) {
			System.out.println("searching for car" + c.getNumber());
		}
		for (int i = 0; i < Model.NUMBEROFCARS; i++) {
			Direction d = c.getDirection();
			Direction d1 = m.getCar(i).getDirection();
			if (d == d1) {
				if (c.getLocation() < m.getCar(i).getLocation()) {
					int dist = m.getCar(i).getLocation() - c.getLocation();
					if (dist < distance) {
						distance = dist;
						closest = m.getCar(i);
						reversed = false;
					}

				}
			}
		}
		if (closest == null ) {
			getClosestCarReversed(c);
		}
		//System.out.println("Found car " + closest.getNumber()
		//		+ "as closest for car" + c.getNumber() + "\n"); 
	}

	private synchronized void getClosestCarReversed(Car c) {
		int distance = Integer.MIN_VALUE;
		for (int i = 0; i < Model.NUMBEROFCARS; i++) {
			if (c.getDirection() == m.getCar(i).getDirection()) {
				if (c.getLocation() > m.getCar(i).getLocation()) {
					int dist = c.getLocation() - m.getCar(i).getLocation();
					if (dist > distance) {
						distance = dist;
						closest = m.getCar(i);
						reversed = true;
					}
				}
			}
		}

	}

}
