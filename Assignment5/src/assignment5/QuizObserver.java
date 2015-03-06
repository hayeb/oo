package assignment5;

/**
 * A view class for usage in a Quiz game.
 * 
 * @author Haye Bohm - s4290402
 * @author Ylja Remmits - s4373510
 *
 */
public class QuizObserver implements QuizView {

	/**
	 * Prints out the question q.
	 */
	@Override
	public void showQuestion(Question q) {

		System.out.print(q);
	}

	@Override
	public void congratulate() {
		System.out.println("Correct! Congratulations!");
	}

	@Override
	public void punish() {
		System.out.println("You need to do better next time!");
	}

	@Override
	public void showCorrectAnswer(String s) {
		System.out.println(s);
	}

	/**
	 * Shows ending message and number of points scored.
	 */
	@Override
	public void showEnd(int round1, int round2) {
		System.out.println("There are no more questions!");
		System.out.print("Your points are:\nRound 1: " + round1 + "\nRound 2: "
				+ round2 + "\n");
	}
}
