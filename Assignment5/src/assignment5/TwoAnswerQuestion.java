package assignment5;

public class TwoAnswerQuestion extends Question {
	private String[] answers;

	/**
	 * Constructor to initialize a TwoAnswerQuestion with a predefined weight.
	 * 
	 * @param question  The question
	 * @param answers An array of size of with answers
	 * @param answer The correct answer
	 * @param weight The weight of the question
	 */
	public TwoAnswerQuestion(String question, String[] answers, String answer,
			int weight) {
		super(weight);
		this.question = question;
		this.answer = answer;
		this.answers = answers;
	}

	/**
	 * Constructor to initialize a TwoAnswerQuestion without a predefined
	 * weight.
	 * 
	 * @param question  The question
	 * @param answers An array of size of with answers
	 * @param answer The correct answer
	 */
	public TwoAnswerQuestion(String question, String[] answers, String answer) {
		super();
		this.question = question;
		this.answer = answer;
		this.answers = answers;
	}

	@Override
	public String toString() {
		return "Question: " + this.question + "\n- " + answers[0] + "\n- " + answers[1] + " \n";
	}
	
	@Override
	public Question duplicate() {
		return this;
	}

}
