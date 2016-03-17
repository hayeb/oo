package assignment4;

/**
 * 
 * @author Haye Bohm - s4290402
 * @author Ylja Remmits - s4373510
 */
public class Loipe implements InfoLoipe {
	private int width, height;
	private int x_max, y_max, x_min, y_min;
	private int stepnumber = 0;
	private Fragment loipe[][];
	private Punt route[];

	private Punt current_position;
	private Punt starting_position;

	/**
	 * Constructs a path representation according to the letters in the string
	 * path. Letters can be 'l', 'r', or 's'.
	 * 
	 * @param path
	 *            A string containing only s, l of r.
	 */
	public Loipe(String path) {
		calculateSizeParcour(path);
		loipe = new Fragment[width][height];
		route = new Punt[path.length()];
		constructFragments(path);
	}

	/**
	 * Calculates the maximum width and height of a path. Width and height are
	 * defined as the difference between their minimum and maximum value.
	 * 
	 * @param path
	 *            A string containing only s, l of r.
	 */
	private void calculateSizeParcour(String path) {
		Orientation o = Orientation.N;
		current_position = new Punt(0, 0);
		for (int i = 0; i < path.length(); i++) {
			char c = path.charAt(i);
			switch (c) {
			case 'r':
				o = o.turnRight();
				break;
			case 'l':
				o = o.turnLeft();
				break;
			}
			move(o);
			updateSize();
		}
		calculateSize();
		setStartPosition();
	}

	/**
	 * Constructs the path and places the corresponding Fragments (according to
	 * orientation and direction) in a 2-dimensional array. TODO: Change this so
	 * that we can use an enumeration instead of this switch, just like with
	 * Orientation.
	 * 
	 * @param path
	 *            A string containing only s, l of r.
	 */
	private void constructFragments(String path) {
		Orientation o = Orientation.N;
		current_position = new Punt(starting_position.getX(),
				starting_position.getY());
		for (int i = 0; i < path.length(); i++) {
			char c = path.charAt(i);
			if (loipe[current_position.getX()][current_position.getY()] != null) {
				this.loipe[current_position.getX()][current_position.getY()] = Fragment.KR;
			} else {
				switch (c) {
				case 'r':
					switch (o) {
					case E:
						this.loipe[current_position.getX()][current_position
								.getY()] = Fragment.ZW;
						break;
					case N:
						this.loipe[current_position.getX()][current_position
								.getY()] = Fragment.ZO;
						break;
					case Z:
						this.loipe[current_position.getX()][current_position
								.getY()] = Fragment.NW;
						break;
					case W:
						this.loipe[current_position.getX()][current_position
								.getY()] = Fragment.NO;
						break;
					}
					o = o.turnRight();
					break;
				case 'l':
					switch (o) {
					case E:
						this.loipe[current_position.getX()][current_position
								.getY()] = Fragment.NW;
						break;
					case N:
						this.loipe[current_position.getX()][current_position
								.getY()] = Fragment.ZW;
						break;
					case Z:
						this.loipe[current_position.getX()][current_position
								.getY()] = Fragment.NO;
						break;
					case W:
						this.loipe[current_position.getX()][current_position
								.getY()] = Fragment.ZO;
						break;
					}
					o = o.turnLeft();
					break;

				case 's':
					switch (o) {
					case E:
					case W:
						this.loipe[current_position.getX()][current_position
								.getY()] = Fragment.OW;
						break;
					case N:
					case Z:
						this.loipe[current_position.getX()][current_position
								.getY()] = Fragment.NZ;
						break;
					default:
						break;

					}
				}
			}
			// Put this step in the list of steps
			route[i] = new Punt(current_position.getX(),
					current_position.getY());
			move(o);
		}
	}

	/**
	 * Sets the width and height to the difference between the maximum and
	 * minimum values of x and y. Adds one because the number of steps in a
	 * direction is 1 less than the number of loipe Fragments in that direction.
	 */
	private void calculateSize() {
		this.height = y_max - y_min + 1;
		this.width = x_max - x_min + 1;
	}

	/**
	 * Intermediate function to update the minimum and maximum values for x and
	 * y.
	 */
	private void updateSize() {
		if (current_position.getX() < x_min) {
			this.x_min = current_position.getX();
		} else if (current_position.getX() > x_max) {
			this.x_max = current_position.getX();
		}

		if (current_position.getY() < y_min) {
			this.y_min = current_position.getY();
		} else if (current_position.getY() > y_max) {
			this.y_max = current_position.getY();
		}
	}

	/**
	 * Returns the surface area of the loipe.
	 * 
	 * @return surface area of the loipe.
	 */
	public int getSize() {
		return this.width * this.height;
	}

	/**
	 * Sets the starting position to the minimum values of x and y, so that we
	 * can correctly access the array of Fragments later on.
	 */
	private void setStartPosition() {
		starting_position = new Punt(-x_min, -y_min);
	}

	/**
	 * Updates the current Position object according to the orientation.
	 * 
	 * @param o
	 */
	private void move(Orientation o) {
		current_position.setPunt(current_position.getX() + o.dx,
				current_position.getY() + o.dy);
	}

	/**
	 * Returns the starting position.
	 */
	@Override
	public Punt start() {
		int x = -x_min;
		int y = -y_min;
		Punt start = new Punt(x, y);
		return start;
	}

	/**
	 * Returns the next step in the route.
	 */
	@Override
	public Punt stap() {
		Punt p = route[stepnumber];
		stepnumber++;
		return p;
	}

	public int getStepNumber() {
		return stepnumber;
	}

	
	public int getX() {
		return this.width;
	}

	
	public int getY() {
		return this.height;
	}

	@Override
	public Fragment getFragment(int x, int y) {
		return loipe[x][y];
	}

}
