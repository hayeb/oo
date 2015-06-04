package mandelbrot;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;



import javax.swing.JProgressBar;

/**
 *
 * @author Sjaak Smetsers
 */
public class AreaController {
	private GridFiller filler;
	private Grid grid;
	private JProgressBar jbar;
	
	public AreaController(GridFiller filler, Grid grid, JProgressBar jbar) {
		this.filler = filler;
		this.grid = grid;
		this.jbar = jbar;
	}

	public void setArea(AreaSelector selector, int x, int y, int w, int h) {
		// Get the current area, zoom in and save it to the filler.
		Area area = filler.getArea().zoom(x, y, w, h, grid.getWidth(),
				grid.getHeight());
		filler = new GridFiller(grid, area);
		
		// SPlit the area into four sub-areas.
//		Area area1 = new Area(area.getX(), area.getY(), area.getWidth(), area.getHeight()/2);
//		Area area2 = new Area(area.getX(), area.getY() + area.getHeight(), area.getWidth(), area.getHeight()/2);
//		
//		GridFiller filler1 = new GridFiller(grid, area1);
//		GridFiller filler2 = new GridFiller(grid, area2);
//		
		filler.addPropertyChangeListener((PropertyChangeEvent pce) -> {
			if (pce.getPropertyName().equals("progress")) {
				//System.out.println("Setting progress");
				int newvalue = (Integer) pce.getNewValue();
				jbar.setValue(newvalue);
			}
		});
		try {
			filler.execute();
//			filler2.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
