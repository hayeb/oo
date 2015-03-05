package assignment5;

import java.util.Random;

public class MultipleChoiceQuestion extends Question {
	private String[] answers;
	private int answer_multiple;

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
		this.answer_multiple = correct;
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
		this.answer_multiple = correct;
		this.answers = answers;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Question: " + question + "\n");
		for (int i = 0; i < answers.length; i++) {
			sb.append("[" + (i+1) + "] " + answers[i] + "\n");
		}
		return sb.toString();
	}
	
	public Question duplicate() {
		Random random = new Random();
		int shift = random.nextInt(answers.length);
		String list[] = new String[answers.length];
		int answer_shifted = (answer_multiple + shift) % answers.length;
		System.out.println(answer_shifted);
		for (int i = 0; i < answers.length; i++) {
			list[i] = answers[(i + shift) % (answers.length)];
		}
		return new MultipleChoiceQuestion(question, list,
				answer_shifted, weight);
	}
	
	@Override
	public boolean isCorrect(String antwoord) {
		if (antwoord.equalsIgnoreCase(Integer.toString(answer_multiple))) {
			return true;
		}
		return false;
	}
	
	@Override
	public String isRight() {
		return "The answer is: " + answer_multiple + "\n";
	}
}
