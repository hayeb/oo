package assignment4;

/**
 * @author Ylja Remmits - s4373510
 * @author Haye Bohm - s4290402
 *
 */
public enum Orientation {
	N(0, -1), Z(0, 1), E(1, 0), W(-1, 0);

	public final int dx, dy;

	private Orientation(int dx, int dy) {
		this.dx = dx;
		this.dy = dy;
	}
	
	/**
	 * Returns an orientation depending on the current value of the enum. Turning left.
	 * @return
	 */
	public Orientation turnLeft() {
		switch (this) {
		case N:
			return Orientation.W;
		case E:
			return Orientation.N;
		case Z:
			return Orientation.E;
		case W:
			return Orientation.Z;
		default:
			return null;
		}
	}
	
	/**
	 * Returns an orientation depending on the current value of the enum. Turning left.
	 * @return
	 */
	public Orientation turnRight() {
		switch (this) {
		case N:
			return Orientation.E;
		case E:
			return Orientation.Z;
		case Z:
			return Orientation.W;
		case W:
			return Orientation.N;
		default:
			return null;
		}
	}
}
