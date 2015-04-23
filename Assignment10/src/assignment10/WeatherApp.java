/**
 * 
 */
package assignment10;

/**
 * Class which containt the model and gui for the weather app.
 * 
 * @author Haye Bohm - 4290402
 * @author Ylja Remmits - 4373510
 *
 */
public class WeatherApp {

    /**
     * Creates the model and the gui, and uses the buienradar xml file to
     * construct a database of weather stations.
     */
    public WeatherApp() {
	WeatherAppModel model = new WeatherAppModel();
	WeatherDataReader xmlreader = new WeatherDataReader();
	model.addWeatherStations(xmlreader.read("http://xml.buienradar.nl/"));
	model.setURL("http://xml.buienradar.nl/");
	WeatherAppGUI gui = new WeatherAppGUI("WeatherApp: Weer een weer app",
		model.getWeatherStations(), model);
	gui.setVisible(true);
    }
}
