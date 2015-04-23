/**
 * 
 */
package assignment10;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * @author haye
 *
 */
public class ImagePanel extends JPanel {
    private Image image;

    public ImagePanel(ImageIcon imageicon) {
	image = imageicon.getImage();
    }
    
    public void setImage(ImageIcon imageicon) {
	image = imageicon.getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	g.drawImage(image, 0, 0, null);
    }
}
