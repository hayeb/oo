package fractals;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;

public class MouseHandler implements MouseListener, MouseMotionListener {

	GridFiller filler;
	JFrame mainFrame;
	FractalGlassPane glasspane;
	private boolean dragging = false;
	private double x1, x2, y1, y2 = 0;

	public MouseHandler(GridFiller filler, JFrame mainFrame,
			FractalGlassPane glasspane) {
		this.filler = filler;
		this.mainFrame = mainFrame;
		this.glasspane = glasspane;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		/*
		 * Draw a rectangle from x1,y1 to x2,y2. This rectangle should be
		 * opague.
		 */
		dragging = true;
		double x, y = 0;
		if (x1 >= e.getX()) {
			x = e.getX();
		} else {
			x = x1;
		}
		if (y1 >= e.getY()) {
			y = e.getY();
		} else {
			y = y1;
		}
		glasspane.setVisible(true);
		Rectangle rect = new Rectangle((int) x, (int) y, (int) Math.abs(e
				.getX() - x1), (int) Math.abs(e.getY() - y1));
		glasspane.setRect(rect);
		glasspane.repaint();

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		if (e.isShiftDown()) {
			filler.setCenter(x, y);
			filler.setScaleMouse(-1);
			filler.fill();
		} else {
			filler.setCenter(x, y);
			filler.setScaleMouse(2.0);
			filler.fill();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		x1 = e.getX();
		y1 = e.getY();

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (dragging) {
			Double newx1 = 0.0, newx2 = 0.0, newy2 = 0.0, newy1 = 0.0;
			x2 = e.getX();
			y2 = e.getY();
			// Transform the square
			int x, y = 0;
			if (x1 >= x2) {
				newx1 = x2;
				newx2 = x1;
			} else {
				newx1 = x1;
				newx2 = x2;
			}
			if (y1 >= y2) {
				newy1 = y2;
				newy2 = y1;
			} else {
				newy1 = y1;
				newy2 = y2;
			}
			System.out.println("Setting center on: " + (newx2 + newx1) / 2
					+ "," + (newy2 + newy1) / 2 + ".");
			filler.setCenter((newx2 + newx1) / 2, (newy2 + newy1) / 2);
			double scalex = (newx2 - newx1) / 500.0;
			double scaley = (newy2 - newy1) / 500.0;
			System.out.println("Scale factors: x=" + scalex + ", y=" + scaley
					+ ".");
			filler.setScaleRect(scalex, scaley);
			filler.fill();

			mainFrame.repaint();
			glasspane.setVisible(false);
			glasspane.setRect(null);
		}
		dragging = false;

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
