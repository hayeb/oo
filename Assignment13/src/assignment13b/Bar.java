package assignment13b;

import java.util.ArrayList;
import java.util.List;

/**
 * A class which represents a bar. It has a tap, a list of glasses and a list of
 * customers. It is able to handle multiple threads without conflict.
 * 
 * @author Haye Bohm - s4290402
 * @author Ylja Remmits - s5373510
 *
 */
public class Bar {
	private final Tap tap;
	private final List<Glass> glasses;
	private final List<ParchedMan> drinkers;

	public Bar(int numberOfGlasses) {
		tap = new Tap();
		glasses = new ArrayList<Glass>();
		for (int i = 0; i < numberOfGlasses; i++) {
			glasses.add(new Glass());
		}
		drinkers = new ArrayList<ParchedMan>();
	}

	public void letInGuests(int number) {
		for (int i = 0; i < number; i += 1) {
			drinkers.add(new ParchedMan(i, this, tap));
		}
	}

	public void startDrinking() {
		for (ParchedMan man : drinkers) {
			Thread t = new Thread(man);
			t.start();
		}
	}

	public synchronized Glass checkAndGetGlass() {
		if (glasses.size() > 0) {
			return glasses.remove(0);
		}
		return null;
	}

	public boolean areThereGlasses() {
		return glasses.size() > 0;
	}

	public Glass getGlass() {
		return glasses.remove(0);
	}

	public void putGlass(Glass glass) {
		glasses.add(glass);
	}

	public static void main(String[] args) {
		Bar bar = new Bar(1);
		bar.letInGuests(7);
		bar.startDrinking();
	}
}
