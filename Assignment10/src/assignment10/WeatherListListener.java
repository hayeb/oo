package assignment10;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Implementation of the ItemListener for the dropdown list in the gui.
 * 
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
	if (e.getStateChange() == ItemEvent.SELECTED) {
	    WeatherStation ws = (WeatherStation) e.getItem();
	    model.setSelected(ws);
	    gui.update(ws);
	}

    }

}
