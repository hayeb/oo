package assignment10;


/**
 * 
 */

/**
 * @author haye
 *
 */
public class Main {

    /**
     * @param args
     * 
     */
    public static void main(String[] args) {
	WeatherAppController wac = new WeatherAppController() ;	
	WeatherAppModel model = new WeatherAppModel();
	WeatherDataReader xmlreader = new WeatherDataReader();
	model.addWeatherStations(xmlreader.read("http://xml.buienradar.nl/"));
	WeatherAppGUI gui = new WeatherAppGUI("WeatherApp: Weer een weer app", model.getWeatherStations(), model);
	gui.setVisible(true);
	wac.register(gui, model);
    }

}
