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
     * @throws HeadlessException
     */
    public WeatherAppGUI() throws HeadlessException {
	
    }

    /**
     * @param gc
     */
    public WeatherAppGUI(GraphicsConfiguration gc) {
	super(gc);
	
    }

    /**
     * @param title
     * @throws HeadlessException
     */
    public WeatherAppGUI(String title,
	    ArrayList<WeatherStation> weatherStations, WeatherAppModel model)
	    throws HeadlessException {
	super(title);
	setSize(675, 400);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLayout(new GridBagLayout());
	getContentPane().setBackground(Color.GRAY);
	dropoutMenu(weatherStations, model);
	textArea();
	refresh();
	panel();
    }

    /* Create the Combo Box to choose a weather station */
    public void dropoutMenu(ArrayList<WeatherStation> weatherStations,
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
    public void textArea() {
	textarea = new JTextArea();
	textarea.setText("Hello there! Please select a weather station from the dropdown list.\n");
	textarea.setBackground(Color.WHITE);
	textarea.setPreferredSize(new Dimension(550, 300));
	GridBagConstraints gbc = new GridBagConstraints();
	gbc.anchor = GridBagConstraints.CENTER;
	gbc.gridx = 0;
	gbc.gridy = 1;
	gbc.gridwidth = 2;
	gbc.insets = new Insets(0, 0, 0, 0);
	add(textarea, gbc);
    }

    /* Create the button to refresh all information */
    public void refresh() {
	JButton refreshbutton = new JButton("Refresh");
	refreshbutton.addActionListener(new RefreshActionListener());
	GridBagConstraints gbc = new GridBagConstraints();
	gbc.anchor = GridBagConstraints.CENTER;
	gbc.gridx = 1;
	gbc.gridy = 0;
	gbc.gridwidth = 1;
	add(refreshbutton, gbc);
    }

    /* Create the panel to display the image. */
    public void panel() {
	imagepanel = new ImagePanel(new ImageIcon());
	imagepanel.setPreferredSize(new Dimension(40, 40));
	GridBagConstraints gbc = new GridBagConstraints();
	gbc.anchor = GridBagConstraints.NORTHWEST;
	gbc.gridx = 2;
	gbc.gridy = 1;
	gbc.insets = new Insets(0, 10, 10, 10);
	add(imagepanel, gbc);
    }

    public void update(WeatherStation weatherstation) {
	textarea.setText("Name: " + weatherstation.getName()
		+ "\nTemperature (c): " + weatherstation.getTemp()
		+ "\nWind Direction: " + weatherstation.getWindDirection()
		+ "\nWind Speed: " + weatherstation.getWindspeed());
	ImageIcon im = weatherstation.getImage();
	imagepanel.setImage(im);
	imagepanel.repaint();
    }

    public JComboBox<WeatherStation> getWeatherComboBox() {
	return weathercombobox;
    }

    /**
     * @param title
     * @param gc
     */
    public WeatherAppGUI(String title, GraphicsConfiguration gc) {
	super(title, gc);
	
    }

}
