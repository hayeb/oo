package fractals;

/**
 *
 * @author Sjaak Smetsers
 ** @version 1.0, 13-03-2013
 */

/**
 * A skeleton class illustrating the use of the grid interface
 * 
 */
public class GridFiller {
	private Grid grid; // the grid to be filled
	private ColorTable colorTable; // a table for converting indexes to
									// rgb values
	private double scale_min_x, scale_max_x, scale_min_y, scale_max_y,
			defaultSize;

	/**
	 * The constructor
	 * 
	 * @param grid
	 *            to be filled
	 */
	public GridFiller(Grid grid, double ds) {
		defaultSize = ds;
		scale_max_x = ds;
		scale_min_x = -ds;
		scale_max_y = ds;
		scale_min_y = -ds;
		colorTable = new ColorTable(100);
		this.grid = grid;
	}

	private int calcMandelbrot(double a, double b) {
		if (Math.sqrt((a * a + b * b)) > 2) {
			return 0;
		}
		double xlast = a;
		double ylast = b;
		for (int i = 0; i < 100; i++) {
			double xcurr = xlast * xlast - ylast * ylast + a;
			double ycurr = 2 * xlast * ylast + b;
			xlast = xcurr;
			ylast = ycurr;
			if (Math.sqrt(xlast * xlast + ylast * ylast) > 2) {
				return i;
			}
		}
		return Integer.MAX_VALUE;
	}

	private double scale(double width, double i, double min, double max) {
		double percentage = i / width;
		return percentage * (max - min) + min;
	}

	/**
	 * Fill the grid according to the mandelbrot number of each pixel.
	 */
	public void fill() {
		int grid_w = grid.getWidth(), grid_h = grid.getHeight();
		for (int i = 0; i < grid_w; i++) {
			for (int j = 0; j < grid_h; j++) {
				double x = scale(grid.getWidth(), i, scale_min_x, scale_max_x);
				double y = scale(grid.getHeight(), j, scale_min_y, scale_max_y);
				int mandelbrot = calcMandelbrot(x, y);
				grid.setPixel(i, j, colorTable.getColor(mandelbrot));
				
				
				
//				if (mandelbrot == Integer.MAX_VALUE || mandelbrot % 2 == 0) {
//					int[] array = { 0, 0, 0 };
//					grid.setPixel(i, j, array);
//				} else {
//					int[] array = { 255, 255, 255 };
//					grid.setPixel(i, j, array);
//				}
			}
		}
	}

	public void setCenter(double x, double y) {
		double cent_x_dist = (grid.getWidth()/2) - x;
		double cent_y_dist = (grid.getHeight()/2) - y;
		double cent_x_dist_scaled = cent_x_dist / grid.getWidth() * (scale_max_x-scale_min_x);
		double cent_y_dist_scaled = cent_y_dist / grid.getHeight() * (scale_max_y-scale_min_y);
		scale_min_x -= cent_x_dist_scaled;
		scale_min_y -= cent_y_dist_scaled;
		scale_max_x -= cent_x_dist_scaled;
		scale_max_y -= cent_y_dist_scaled;

	}
	
	public void setScale(double scale) {
		scale_min_x = scale_min_x / scale;
		scale_max_x = scale_max_x/ scale;
		scale_min_y = scale_min_y/ scale;
		scale_max_y = scale_max_y / scale;
	}

	public void setScaleMouse(double scale) {
		double x_dist = Math.abs(scale_max_x - scale_min_x);
		double y_dist = Math.abs(scale_max_y - scale_min_y);
		
		
		scale_min_x += 0.5 * x_dist / scale;
		scale_max_x -= 0.5 * x_dist / scale;
		scale_min_y += 0.5 * y_dist / scale;
		scale_max_y -= 0.5 * y_dist / scale;
	}

	public void resetScale() {
		scale_max_x = 2.5;
		scale_max_y = 2.5;
		scale_min_x = -2.5;
		scale_min_y = -2.5;
	}
	
	public double getCurrentScale() {
		return scale_max_x - scale_min_x;
	}

}
