package assignment10;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 * 
 */

/**
 * @author Haye Böhm - 4290402
 * @author Ylja Remmits - 4373510
 *
 */
public class WeatherAppGUI extends JFrame {

    private JComboBox<WeatherStation> weathercombobox;
    private JTextArea textarea;
    private ImagePanel imagepanel;

    /**
     * Creates a new window for the weather app.
     * @param title
     * @throws HeadlessException
     */
    public WeatherAppGUI(String title,
	    ArrayList<WeatherStation> weatherStations, WeatherAppModel model)
	    throws HeadlessException {
	super(title);
	setSize(550, 200);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLayout(new GridBagLayout());
	getContentPane().setBackground(Color.GRAY);
	createDropdownList(weatherStations, model);
	createTextArea();
	createrRefreshButton(model);
	createImagePanel();
    }

    /**
     * Creates the dropdown list to display the possible weather stations.
     * @param weatherStations
     * @param model
     */
    public void createDropdownList(ArrayList<WeatherStation> weatherStations,
	    WeatherAppModel model) {
	weathercombobox = new JComboBox<WeatherStation>();
	
	for (WeatherStation ws : weatherStations) {
	    weathercombobox.addItem(ws);
	    
	}
	weathercombobox.setSelectedItem(weatherStations.get(0));
	weathercombobox.addItemListener(new WeatherListListener(model, this));
	
	GridBagConstraints gbc = new GridBagConstraints();
	gbc.anchor = GridBagConstraints.CENTER;
	gbc.gridx = 0;
	gbc.gridy = 0;
	gbc.insets = new Insets(10, 10, 10, 10);
	add(weathercombobox, gbc);
    }

    /*
     * Create the Text area to display the weather station information. Also set
     * some initial text.
     */
    public void createTextArea() {
	textarea = new JTextArea();
	textarea.setText("Hello there! Please select a weather station from the dropdown list.\n");
	textarea.setBackground(Color.WHITE);
	textarea.setPreferredSize(new Dimension(450, 65));
	GridBagConstraints gbc = new GridBagConstraints();
	gbc.anchor = GridBagConstraints.CENTER;
	gbc.gridx = 0;
	gbc.gridy = 1;
	gbc.gridwidth = 2;
	gbc.insets = new Insets(0, 0, 0, 0);
	add(textarea, gbc);
    }

    /**
     * Adds the refresh button to the interface.
     */
    public void createrRefreshButton(WeatherAppModel model) {
	JButton refreshbutton = new JButton("Refresh");
	refreshbutton.addActionListener(new RefreshActionListener(model, this));
	GridBagConstraints gbc = new GridBagConstraints();
	gbc.anchor = GridBagConstraints.CENTER;
	gbc.gridx = 1;
	gbc.gridy = 0;
	gbc.gridwidth = 1;
	add(refreshbutton, gbc);
    }

    /**
     * Creates the panel to hold the image of a weather station. 
     */
    public void createImagePanel() {
	imagepanel = new ImagePanel(new ImageIcon());
	imagepanel.setPreferredSize(new Dimension(37, 37));
	GridBagConstraints gbc = new GridBagConstraints();
	gbc.anchor = GridBagConstraints.NORTHWEST;
	gbc.gridx = 2;
	gbc.gridy = 1;
	gbc.insets = new Insets(0, 10, 10, 10);
	add(imagepanel, gbc);
    }

    /**
     * Updates the textfield and image panel to represent the currently selected weather station. 
     * @param weatherstation
     */
    public void update(WeatherStation weatherstation) {
	textarea.setText(" Name: " + weatherstation.getName()
		+ "\n Temperature (c): " + weatherstation.getTemp()
		+ "\n Wind Direction: " + weatherstation.getWindDirection()
		+ "\n Wind Speed: " + weatherstation.getWindspeed());
	ImageIcon im = weatherstation.getImage();
	imagepanel.setImage(im);
	repaint();
    }
}
