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
public class WeatherDataReader {

    /**
     * 
     */
    public WeatherDataReader() {

    }

    public ArrayList<WeatherStation> read(String url) {
	ArrayList<WeatherStation> ws = new ArrayList<WeatherStation>();
	try {
	    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	    DocumentBuilder db = dbf.newDocumentBuilder();
	    Document doc = db.parse(url);
	    doc.getDocumentElement().normalize();
	    NodeList nl = doc.getElementsByTagName("weerstation");
	    for (int i = 0; i < nl.getLength(); i++) {
		WeatherStation weatherstation = new WeatherStation();
		Node n = nl.item(i);
		NodeList nodemap = n.getChildNodes();
		for (int j = 0; j < nodemap.getLength(); j++) {
		    Node attribute = nodemap.item(j);		    
		    if (attribute.getNodeName().equals("stationnaam")){
			weatherstation.setName(attribute.getTextContent());
		    } else if (attribute.getNodeName().equals("temperatuurGC")) {
			weatherstation.setTemp(attribute
				.getTextContent());
		    } else if (attribute.getNodeName().equals("icoonactueel")) {
			weatherstation.setIcon(attribute.getTextContent());
		    } else if (attribute.getNodeName().equals("windsnelheidMS")) {
			weatherstation.setWindspeed(attribute.getTextContent());
		    } else if (attribute.getNodeName().equals("windrichting")) {
			weatherstation.setWindDirection(attribute
				.getTextContent());
		    }
		}
		ws.add(weatherstation);
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return ws;
    }

}
