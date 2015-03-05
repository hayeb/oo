package assignment4;

import java.util.Scanner;

/**
 * Controls the Loipe model and user input.
 * 
 * @author Haye Bohm - s4290402
 * @author Ylja Remmits - s4373510
 */
public class LoipeControl implements LoipeController {
	private LoipeViewer loipeview;
	private Scanner in;
	private InfoLoipe loipe;
	private AsciiArt ascii;
	private int pathlength;

	public LoipeControl() {
		in = new Scanner(System.in);
	}
	/**
	 * Adds a class implementing the LoipeView interface
	 */
	public void addView(LoipeView l) {
		this.loipeview = l;
	}

	/**
	 * Sets up the Loipe model according to a string input by the user, and
	 * draws ASCII art or images to the screen depending on user input.
	 */
	public void startLoipe() {
		loipeview.askInput();
		String path = getPathString();
		loipe = new Loipe(path);
		pathlength = path.length();
		ascii = new AsciiArt(loipe);
		draw(ascii);
		loipeview.askStepsQuery();
		getSteps();
	}

	/**
	 * Continues to show ASCII, show interactive ASCII art or show layout of the
	 * Loipe in images depending on user input.
	 */
	private void getSteps() {
		boolean done = false;
		int i = 0;
		while (!done) {
			String input = in.nextLine();
			if (input.equalsIgnoreCase("y")) {
				if (i < pathlength) {
					showStep();
					loipeview.askNextStep();
				} else {
					draw(new LoipePlaatje(loipe));
				}
			} else if (input.equalsIgnoreCase("n")) {
				draw(new LoipePlaatje(loipe));
			} else {
				loipeview.askStepsQuery();
			}

		}
	}

	/**
	 * Show the next step of the Loipe, advancing from the previous step
	 */
	private void showStep() {
		Punt p = loipe.start();
		p = loipe.stap();
		ascii.setPosition(p);

	}

	/**
	 * Returns the path input by the user.
	 * 
	 * @return a string containing s, l or r.
	 */
	private String getPathString() {
		return in.nextLine();
	}

	/**
	 * Draw a visualisation of the Loipe
	 * 
	 * @param drawapp
	 *            A class which implements interface TekenLoipe
	 */
	private void draw(TekenLoipe drawapp) {
		drawapp.teken();
	}
}
