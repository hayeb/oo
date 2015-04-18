package assignment9;

public class WebWinkel {

	public static void main(String[] args) {
		WebShopModel ws = new WebShopModel();
		TextUserInterface ui = new TextUserInterface();
		Controller c = new Controller(ws, ui);
		c.run();
	}

}
