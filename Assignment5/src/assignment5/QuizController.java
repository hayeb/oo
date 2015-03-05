package assignment5;

import java.util.Scanner;

/**
 * 
 * @author Haye Bohm - s4290402
 * @author Ylja Remmits - s4373510
 */
public class QuizController implements GameController {
	private QuizView observer;
	private QuizModel model;
	private Scanner in;

	public QuizController() {
		in = new Scanner(System.in);
	}

	/**
	 * Registers two objects to the QuizController: A QuizView observer and a
	 * QuizModel model.
	 */
	public void register(QuizView observer, QuizModel model) {
		this.observer = observer;
		this.model = model;
	}

	public void setup() {
		model.createQuestions();
	}

	/**
	 * Main game loop
	 */
	public void run() {
		/*
		 * 1. Show question 2. Request the answer from the user 3. Compare
		 * answer and input 4. Repeat until there are no more questions
		 */
		Question q;
		do {
			q = model.getNextQuestion();
			if (q != null) {
				observer.update(q);
				String input = in.nextLine();
				if (q.isCorrect(input)) {
					observer.congratulate();
				} else {
					observer.punish();
					observer.showCorrectAnswer(q.isRight());
					model.addWrongList(q.duplicate());
				}

			} else { // There are no more questions left
				observer.showEnd();
			}

		} while (q != null);

	}
}
