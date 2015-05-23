package assignment13b;

/**
 * Represents a glass which can be filled or emptied.
 * @author Haye Bohm - s4290402
 * @author Ylja Remmits - s5373510
 *
 */
public class Glass {
	private int volume = 0;

	public void fill(int cc) {
		volume = cc;
	}

	public void empty() {
		volume = 0;
	}

	public int getVolume() {
		return volume;
	}
}
