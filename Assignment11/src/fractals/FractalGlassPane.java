package fractals;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;

public class FractalGlassPane extends JComponent {
	private Rectangle rect;
	
	public FractalGlassPane() {
		
	}
	
	public void setRect(Rectangle rect) {
		this.rect = rect;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		if (rect != null) {
			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(new Color(255, 128, 128, 128));
			g2d.setXORMode(Color.BLACK);
			g2d.fill(rect);
			g2d.draw(rect);
			
			
		}
	}

}
