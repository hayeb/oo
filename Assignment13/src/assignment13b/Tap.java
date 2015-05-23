package assignment13b;

/**
 * Represents the tap in a bar: can fill glasses, one at a time.
 * @author Haye Bohm - s4290402
 * @author Ylja Remmits - s5373510
 *
 */
public class Tap {
	private static final int CC_PER_GLASS = 200;
	private static final int DRAW_TIME_PER_CC = 1;
	
	public synchronized Glass fillUp(Glass glass) {
		try {
			Thread.sleep(CC_PER_GLASS * DRAW_TIME_PER_CC);
		} catch (InterruptedException e) {
			
		}
		return glass;
	}
}
