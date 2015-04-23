package assignment10;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * @author Haye Böhm - 4290402
 * @author Ylja Remmits - 4373510
 *
 */
public class WeatherListListener implements ItemListener {

    private WeatherAppModel model;
    private WeatherAppGUI gui;

    /**
     * 
     */
    public WeatherListListener(WeatherAppModel model, WeatherAppGUI gui) {
	this.model = model;
	this.gui = gui;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * java.awt.event.ItemListener#itemStateChanged(java.awt.event.ItemEvent)
     */
    @Override
    public void itemStateChanged(ItemEvent e) {
	// TODO Auto-generated method stub
	if (e.getStateChange() == ItemEvent.SELECTED) {
	    WeatherStation ws = (WeatherStation) e.getItem();
	    gui.update(ws);
	}

    }

}
