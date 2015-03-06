package assignment5;

/**
 * Interface for a internel model of a quiz.
 * 
 * @author Haye Bohm - s4290402
 * @author Ylja Remmits - s4373510
 *
 */
public interface QuizModel {

	public void createQuestions();

	public Question getNextQuestion();

	public void addWrongList(Question q);

	public void addPointsRound1(int weight);

	public void addPointsRound2(int weight);

	public boolean isInRound2(Question q);

	public int getPointsRound1();

	public int getPointsRound2();

	public void removeWrongQuestion();
}
