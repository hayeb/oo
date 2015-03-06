package assignment5;

import java.util.Random;

/**
 * Represents a multiplechoice question.
 * 
 * @author Haye Bohm - s4290402
 * @author Ylja Remmits - s4373510
 *
 */
public class MultipleChoiceQuestion extends Question {
	private String[] answers;
	private int answer_multiple; // index in array answers

	/**
	 * Constructor to initialize a multiplechoice question with a predefined
	 * weight.
	 * 
	 * @param question
	 * @param answers
	 * @param correct
	 * @param weight
	 */
	public MultipleChoiceQuestion(String question, String[] answers,
			int correct, int weight) {
		super(weight);
		this.question = question;
		this.answer_multiple = correct - 1;
		this.answers = answers;
	}

	/**
	 * Constructor to initialize a multiplechoice question without a predefined
	 * weight.
	 * 
	 * @param question
	 * @param answers
	 * @param correct
	 */
	public MultipleChoiceQuestion(String question, String[] answers, int correct) {
		super();
		this.question = question;
		this.answer_multiple = correct - 1;
		this.answers = answers;
	}

	/**
	 * Returns a string representation of the question and all the answers.
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Question: " + question + "\n");
		for (int i = 0; i < answers.length; i++) {
			sb.append("[" + (i + 1) + "] " + answers[i] + "\n");
		}
		return sb.toString();
	}

	/**
	 * Returns a copy of this object, with the questions shifted according to a
	 * random number
	 */
	public Question duplicate() {
		Random random = new Random();
		int shift = random.nextInt(answers.length);
		String list[] = new String[answers.length];
		int answer_shifted = (answer_multiple + shift) % answers.length;
		System.out.println(answer_shifted);
		for (int i = 0; i < answers.length; i++) {
			int new_index = (i + shift) % (answers.length);
			list[new_index] = answers[i];
		}
		return new MultipleChoiceQuestion(question, list, answer_shifted + 1,
				weight);
	}

	/**
	 * Returns if the String antwoord is the correct answer.
	 */
	@Override
	public boolean isCorrect(String antwoord) {
		if (antwoord.equalsIgnoreCase(Integer.toString(answer_multiple + 1))) {
			return true;
		}
		return false;
	}

	/**
	 * Returns a string representation of the correct answer.
	 */
	@Override
	public String isRight() {
		return "The answer is: " + (answer_multiple + 1) + "\n";
	}
}
