package assignment4;

/**
 * 
 * @author Haye Bohm - s4290402
 * @author Ylja Remmits - s4373510
 */
public class LoipeApp {
	
	public LoipeApp() {
		run() ;
	}
	
	/**
	 * Runs the Loipe App.
	 */
	private void run() {
		LoipeControl lc = new LoipeControl();
		LoipeView lv = new LoipeView() ;
		lc.addView(lv);
		lc.startLoipe() ;
	}

}
