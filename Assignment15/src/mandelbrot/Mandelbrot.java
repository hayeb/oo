/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mandelbrot;

import java.beans.PropertyChangeEvent;

import javax.swing.JProgressBar;
import javax.swing.SwingConstants;


/*
This class creates an applet for generating Mandelbrot sets. The applet is
meant to be embedded in an HTML page and has hooks to interact with the page.
Functions are provided to allow the user to zoom in and out and to move around
on the surface of the figure. The user can also select from a set of color
schemes.
*/

public class Mandelbrot 
{
    public static void main(String args[]) {
        
        GridView grid = new GridView();
        JProgressBar jbar = new JProgressBar(SwingConstants.HORIZONTAL);
        MainWindow mandel = new MainWindow ( grid, jbar );
        
        Area area = new Area ( -2.5, 2.5, 5, 5 );
        GridFiller filler = new GridFiller ( grid, area );
        filler.addPropertyChangeListener((PropertyChangeEvent pce) -> {
			if (pce.getPropertyName().equals("progress")) {
				int newvalue = (Integer) pce.getNewValue();
				jbar.setValue(newvalue);
			}
		});
        AreaController controller = new AreaController ( filler, grid, jbar );
        AreaSelector selector = new AreaSelector ( grid, controller);
        filler.fill();
    }

}