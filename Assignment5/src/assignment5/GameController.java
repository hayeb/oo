package assignment5;

/**
 * Interface for a game controller.
 * @author Haye Bohm - s4290402
 * @author Ylja Remmits - s4373510
 *
 */
public interface GameController {
	
	public void register(QuizView view, QuizModel model);
	public void run() ;
	public void setup() ;
}
