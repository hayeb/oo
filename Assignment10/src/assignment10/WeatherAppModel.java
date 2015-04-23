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
 * @author haye
 *
 */
public class WeatherAppModel {
    ArrayList<WeatherStation> weatherstations;

    /**
     * 
     */
    public WeatherAppModel() {
	weatherstations = new ArrayList<WeatherStation>();
    }
    
    public ArrayList <WeatherStation> getWeatherStations(){
	return weatherstations;
    }
    
    public void addWeatherStations(ArrayList<WeatherStation> weatherstations) {
	this.weatherstations.addAll(weatherstations);
	
    }
    

}
