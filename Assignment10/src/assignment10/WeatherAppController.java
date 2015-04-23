/**
 * 
 */
package assignment10;

/**
 * @author haye
 *
 */
public class WeatherAppController {

    private WeatherAppGUI gui;
    private WeatherAppModel model;
    /**
     * 
     */
    public WeatherAppController() {
	// TODO Auto-generated constructor stub
    }
    
    public void register(WeatherAppGUI gui, WeatherAppModel model ) {
	this.gui = gui;
	this.model = model;
    }

}
