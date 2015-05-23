package assignment13a;

/**
 * A class which represents a okayer in a dice game. Implements Runnable
 * interface, and can be run on a seperate thread.
 * 
 * @author Haye Bohm - s4290402
 * @author Ylja Remmits - s5373510
 *
 */
public class Player implements Runnable {
	private final Dice dice;
	private final String name;
	private final int numberOfThrows;

	public Player(String name, Dice dice, int numberOfThrows) {
		this.name = name;
		this.dice = dice;
		this.numberOfThrows = numberOfThrows;
	}

	@Override
	public void run() {
		for (int i = 0; i < numberOfThrows; i += 1) {
			int pips = dice.throwAndGet();
			System.out.println(name + " throws " + pips
					+ " in turn " + i + ".");
		}
	}

}
