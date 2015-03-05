package assignment5;

/**
 * @author Haye Bohm - s4290402
 * @author Ylja Remmits - s4373510
 *
 */
public class QuizGame {
	private QuizView quizobserver;
	private QuizModel quizmodel;
	private QuizController quizcontroller;
	
	/**
	 * Empty constructor for QuizGame
	 */
	public QuizGame() {

	}

	/**
	 * Configures the game: Creates a model, a view and a game controller.
	 */
	public void setup() {
		quizobserver = new QuizObserver();
		quizmodel = new Quiz();
		quizcontroller = new QuizController() ;
		quizcontroller.register(quizobserver, quizmodel);
		quizcontroller.setup();
	}
	
	public void run() {
		quizcontroller.run() ;
	}

}
