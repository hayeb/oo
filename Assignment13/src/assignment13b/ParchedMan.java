package assignment13b;

/**
 * A landlubber lookin' for a stiff drink, yarr! Represents a man looking for a
 * drink.
 * 
 * @author Haye Bohm - s4290402
 * @author Ylja Remmits - s5373510
 *
 */
public class ParchedMan implements Runnable {
	private final int id;
	private static final int DRINK_TIME_PER_CC = 5;
	private static final int NUMBER_OF_GLASSES_TO_DRINK = 5;
	private static final int DIGEST_TIME = 10;
	private int numberOfGlassesDrunk = 0;
	private static Bar bar;
	private static Tap tap;

	public ParchedMan(int id, Bar bar, Tap tap) {
		this.id = id;
		this.bar = bar;
		this.tap = tap;
	}

	public void drawAndDrink() {
		while (!satisfied()) {
			Glass g = bar.checkAndGetGlass();
			if (g != null) {
				g = tap.fillUp(g);
				try {
					System.out.println("Man "
							+ id
							+ " drinks a glass of beer");
					Thread.sleep(g.getVolume()
							* DRINK_TIME_PER_CC);
				} catch (InterruptedException e) {
				}
				g.empty();
				numberOfGlassesDrunk++;
				bar.putGlass(g);
			} else {
				System.out.println("Man "
						+ id
						+ " has to wait: There are no empty glasses.");
			}
			try {
				Thread.sleep(DIGEST_TIME);
			} catch (InterruptedException e) {
			}
		}
		System.out.println("Man " + id + " is satisfied");
	}

	private boolean satisfied() {
		return numberOfGlassesDrunk == NUMBER_OF_GLASSES_TO_DRINK;
	}

	@Override
	public void run() {
		drawAndDrink();

	}
}
