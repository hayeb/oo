/**
 * 
 */
package assignment10;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * A panel intended to hold a single image.
 * @author Haye Bohm - 4290402
 * @author Ylja Remmits - 4373510
 *
 */
public class ImagePanel extends JPanel {
    private ImageIcon image;

    /**
     * Initialize this panel with a specific image
     * @param imageicon
     */
    public ImagePanel(ImageIcon imageicon) {
	image = imageicon;
    }

    /**
     * Set the image to a certain image.
     * @param imageicon
     */
    public void setImage(ImageIcon imageicon) {
	image = imageicon;
    }

    @Override
    protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	image.paintIcon(this, g, 0, 0);
    }
}
