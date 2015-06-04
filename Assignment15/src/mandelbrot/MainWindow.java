package mandelbrot;



import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

/**
 * 
 * @author Sjaak Smetsers
 * @version 1.0, 14-03-2013
 */

/**
 * creates a window to which a GridView panel is added
 * 
 */
public class MainWindow  {
    
    public MainWindow ( GridView grid, JProgressBar pbar ) {
    	JFrame mainFrame = new JFrame ("Mandelbrot");
        
    	mainFrame.setLocationRelativeTo(null);
    	mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	mainFrame.setResizable(false);
    	mainFrame.setVisible(true);
    	mainFrame.setLayout(new GridBagLayout());
    	GridBagConstraints gbc = new GridBagConstraints();
    	gbc.gridx = 0;
    	gbc.gridy = 0 ;
    	
        mainFrame.add(grid, gbc);
        gbc.gridy = 1;
        mainFrame.add(pbar, gbc);
        mainFrame.pack();
    }
        
}
