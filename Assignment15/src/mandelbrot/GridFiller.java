/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mandelbrot;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

/**
 *
 * @author Sjaak
 */
public class GridFiller extends SwingWorker<Object, int[]> {

	private Area area;
	private Grid grid;
	private int corner;
	public static final int MAX_ITERATIONS = 100;
	private static final RGBColors rgbColors = new RGBColors(MAX_ITERATIONS);
	private static final ColorChooser colorChooser = new ColorChooser();


	public GridFiller(Grid grid, Area area) {
		this.grid = grid;
		this.area = area;
	//	this.corner = corner
		colorChooser.setMaxIndex(MAX_ITERATIONS);
	}

	public Area getArea() {
		return area;
	}

	public void fill() {
		setProgress(0);
		int grid_w = grid.getWidth(), grid_h = grid.getHeight();
		double area_w = area.getWidth(), area_h = area.getHeight();
		double dx = area_w / grid_w, dy = area_h / grid_h;
		int currentDepth = 1;

		while (currentDepth != colorChooser.getMaxIndex()) {
			double x = area.getX();
			for (int i = 0; i < grid_w; i++) {
				double y = area.getY();
				for (int j = 0; j < grid_h; j++) {
					int color = colorChooser.getColorIndex(x, y, currentDepth);
					int colors[];
					if (color == -1) {
						colors = rgbColors.BLACK;
					} else {
						colors = rgbColors.getColor(color);
					}
					publish(new int[] { i, j, colors[0], colors[1], colors[2] });
					
					y -= dy;
				}
				x += dx;
				

			}
			Double progress =  ((double) currentDepth / colorChooser.getMaxIndex());
			setProgress((int) (progress * 100.0));
			currentDepth++;
		}
		setProgress(100);
	}

//	/**
//	 * 
//	 * @param i
//	 * @return widhtheight [0] = xmin, widhtheight [1] = xmax, widhtheight [2] = ymin, widhtheight [3] = ym
//	 * 
//	 */
//	
//	public int[] getWidthAndHeight(int i){
//		int widthheight= new int[4]
//		switch(i){
//			case 1:
//				widthheight[0]=0;
//				widthheight[1]= grid.getWidth();
//				widthheight[2]=0;
//				widthheight[3]=grid.getHeight()/2;
//				break;
//			case 2:
//				widthheight[0]= 0
//				widthheight[1]= grid.getWidth();
//				widthheight[2]=grid.getHeight()/2;
//				widthheight[3]=grid.getHeight();
//				break;
////			case 3:
////				break;
////			case 4:
////				break;
//			}
//		return widthheight;
//	}
	
	@Override
	protected void process(List<int[]> list) {
		//System.out.print("Arrived in process");
		for (int[] l : list) {
			int colors[] = { l[2], l[3], l[4] };
			grid.setPixel(l[0], l[1], colors);
		}

	}

	@Override
	protected Object doInBackground() throws Exception {
		setProgress(0);
		fill();
		return null;
	}
}
