package assignment4;
/**
 * 
 * @author Haye Bohm - s4290402
 * @author Ylja Remmits - s4373510
 */
public class LoipeView implements LoipeViewer {
	public LoipeView() {
		
	}
	
	/**
	 * Asks the user for a string containing only s, l or r.
	 */
	public void askInput() {
		System.out.println("Please enter a string. Enter only 's', 'l' or'r':");
	}
	
	/**
	 * Asks the user if the Loipe should be shown step-by-step in ASCII art.
	 */
	public void askStepsQuery() {
		System.out.println("Would you like to show the path step-by-step? [y/n]");
	}
	
	/**
	 * Asks the user if the next step should be shown.
	 */
	public void askNextStep() {
		System.out.println("Would you like the next step or exit to the graphic visualization?[y/n]");
	}
}
