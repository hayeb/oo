package assignment5;

/**
 * Interface for a view class in a quiz game.
 * 
 * @author Haye Bohm - s4290402
 * @author Ylja Remmits - s4373510
 *
 */
public interface QuizView {

	public void showQuestion(Question q);

	public void congratulate();

	public void punish();

	public void showCorrectAnswer(String s);

	public void showEnd(int round1, int round2);
}
