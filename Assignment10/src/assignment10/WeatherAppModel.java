/**
 * 
 */
package assignment10;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * A model for the weather app which contains a lsit of weather stations and a
 * reference to the currently selected weather station. Also remembers the URL
 * for the data source.
 * 
 * @author Haye Bohm - 4290402
 * @author Ylja Remmits - 4373510
 *
 */
public class WeatherAppModel {
    private ArrayList<WeatherStation> weatherstations;
    private String url;
    private WeatherStation selected;

    public WeatherAppModel() {
	weatherstations = new ArrayList<WeatherStation>();
    }

    public void setURL(String url) {
	this.url = url;
    }

    public String getURL() {
	return this.url;
    }

    public ArrayList<WeatherStation> getWeatherStations() {
	return weatherstations;
    }

    public void addWeatherStations(ArrayList<WeatherStation> weatherstations) {
	this.weatherstations.addAll(weatherstations);

    }

    /**
     * Deletes all weatherstations in the list.
     */
    public void clearWeatherStationsList() {
	weatherstations.clear();
    }

    /**
     * Sets a weather station as selected.
     * 
     * @param ws
     */
    public void setSelected(WeatherStation ws) {
	this.selected = ws;
    }

    /**
     * returns the selecred weather station.
     * 
     * @return
     */
    public WeatherStation getSelected() {
	return selected;
    }

    /**
     * Set a weatherstation as selected according to its name.
     * 
     * @param name
     */
    public void setSelected(String name) {
	for (WeatherStation ws : weatherstations) {
	    if (ws.getName().equals(name)) {
		setSelected(ws);
		return;
	    }
	}
    }

}
