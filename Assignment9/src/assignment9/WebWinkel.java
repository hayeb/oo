package assignment9;

/**
 * "main" class for our webshop.
 * 
 * @author Haye Bohm - 4290402
 * @author Ylja Remmits - 4373510
 *
 */
public class WebWinkel {

	public static void main(String[] args) {
		WebShopModel ws = new WebShopModel();
		TextUserInterface ui = new TextUserInterface();
		Controller c = new Controller(ws, ui);
		c.run();
	}

}
