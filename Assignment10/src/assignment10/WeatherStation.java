package assignment10;

/**
 * 
 */
import javax.swing.ImageIcon;

/**
 * Represents a weather station with all the relevant information.
 * 
 * @author Haye Böhm - 4290402
 * @author Ylja Remmits - 4373510
 *
 */
public class WeatherStation {

    private String name;
    private String temp;
    private String windspeed;
    private String winddirection;
    private ImageIcon weathericon;

    /**
     * 
     */
    public WeatherStation(String name, String temp, String windspeed,
	    String winddirection, String imageurl) {
	this.name = name;
	this.temp = temp;
	this.windspeed = windspeed;
	this.winddirection = winddirection;
	this.weathericon = new ImageIcon(imageurl);
    }

    public WeatherStation() {

    }

    public void setName(String name) {
	this.name = name;
    }
    
    public String getName() {
	return name;
    }

    public void setTemp(String temp) {
	this.temp = temp;
    }
    
    public String getTemp() {
	return temp;
    }

    public void setWindspeed(String windspeed) {
	this.windspeed = windspeed;
    }
    
    public String getWindspeed() {
	return windspeed;
    }

    public void setWindDirection(String direction) {
	this.winddirection = direction;
    }
    
    public String getWindDirection() {
	return winddirection;
    }

    public void setIcon(String url) {
	weathericon = new ImageIcon(url);
    }
    
    public ImageIcon getImage() {
	return this.weathericon;
    }

    @Override
    public String toString() {
	return this.name;
    }

}
