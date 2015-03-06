package assignment5;

/**
 * Represents an open question.
 * 
 * @author Haye Bohm - s4290402
 * @author Ylja Remmits - s4373510
 */
public class OpenQuestion extends Question {

	/**
	 * Initializes an open question with a specified weight.
	 * 
	 * @param weight
	 */
	public OpenQuestion(int weight) {
		super(weight);
	}

	/**
	 * Initializes an open question with a specified question, answer and
	 * weight.
	 * 
	 * @param question
	 * @param answer
	 * @param weight
	 *            The weight between 1-5.
	 */
	public OpenQuestion(String question, String answer, int weight) {
		super(weight);
		this.answer = answer;
		this.question = question;
	}

	/**
	 * Initializes an open question with a specified question and answer, but
	 * with the default weight.
	 * 
	 * @param question
	 * @param answer
	 */
	public OpenQuestion(String question, String answer) {
		super();
		this.question = question;
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "Open vraag: " + question + "\n";
	}

	/**
	 * Returns a copy of this object
	 */
	public Question duplicate() {
		return this;
	}

}
