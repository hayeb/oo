/**
 * 
 */
package assignment10;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Haye Böhm - 4290402
 * @author Ylja Remmits - 4373510
 *
 */
public class RefreshActionListener implements ActionListener {

    private WeatherAppModel model;
    private WeatherAppGUI gui;

    public RefreshActionListener(WeatherAppModel model, WeatherAppGUI gui) {
	this.model = model;
	this.gui = gui;
	// TODO Auto-generated constructor stub
    }

    /*
     * Saves the currently selected weather station, refreshes the model list
     * form the url saved in the model and selects the old selected weather
     * station.
     * 
     * (non-Javadoc)
     * 
     * @see
     * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
	String name = model.getSelected().getName();
	model.clearWeatherStationsList();
	WeatherDataReader xmlparser = new WeatherDataReader();
	model.addWeatherStations(xmlparser.read(model.getURL()));
	model.setSelected(name);
	gui.update(model.getSelected());
    }

}
