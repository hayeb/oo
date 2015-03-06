package assignment5;

import java.util.LinkedList;
import java.util.List;

/**
 * Model for the quiz
 * 
 * @author Haye Bohm - s4290402
 * @author Ylja Remmits - s4373510
 */
public class Quiz implements QuizModel {
	private List<Question> questions;
	private List<Question> wrongquestions;
	private int points_round1;
	private int points_round2;

	private void createOpenQuestions() {
		questions.add(new OpenQuestion(
				"Wat is de complexiteit van binair zoeken?", "O(log N)"));
		questions.add(new OpenQuestion(
				"Hoe lees je in Java een integer i uit een scanner s?",
				"i = s.nextInt();", 2));
		questions
				.add(new OpenQuestion(
						"Hoeveel constructoren je minstens maken bij een klasse in Java?",
						"0", 2));
	}

	private void createMultipleChoiceQuestions() {
		questions.add(new MultipleChoiceQuestion(
				"Wat is de complexiteit van slim in situ sorteren?",
				new String[] { "O(N^2)", "O(N log N)", "O(N)", "O(log N)" }, 1,
				4));
		questions.add(new MultipleChoiceQuestion(
				"Hoe print je \"Hello world\" op een regel in Java?",
				new String[] { "System.out.print(\"Hello world\");",
						"System.out.println(\"Hello world\");",
						"cout << \"Hello world\";" }, 1));
		questions.add(new MultipleChoiceQuestion(
				"Hoe lees je in Java een niet leeg woord uit scanner s?",
				new String[] { "s.nextline()", "s.next(\"\\S+\")",
						"s.next(\"\\a*\")", "s.next(\"\\S*\")",
						"s.next(\"\\\\s+\")", "s.next(\"\\s+\")",
						"s.nextString(\"\\s*\")", "s.next(\"\\\\S+\")",
						"s.nextString()" }, 7, 1));
	}

	public void createTwoAnswerQuestions() {
		questions.add(new TwoAnswerQuestion(
				"Is er verschil tussen een interface en een abstracte klasse?",
				new String[] {"Nee", "Ja"}, "Ja", 5));

		questions
				.add(new TwoAnswerQuestion(
						"Is er een maximum aantal constructoren van een klasse in Java?",
						new String[] {"Nee", "Ja"}, "Nee"));
	}

	public Quiz() {
		questions = new LinkedList<Question>();
		wrongquestions = new LinkedList<Question>();
	}

	public void createQuestions() {
		createOpenQuestions();
		createMultipleChoiceQuestions();
		createTwoAnswerQuestions();
	}

	public void addWrongList(Question q) {
		wrongquestions.add(q);
	}

	/**
	 * Returns the next question. If there is no next question, return null.
	 */
	public Question getNextQuestion() {
		if (questions.size() > 0) {
			return questions.remove(0);
		} else if (wrongquestions.size() > 0) {
			return wrongquestions.get(0);
		} else {
			return null;
		}
	}

	public boolean isInRound2(Question q) {
		for (Question que : wrongquestions) {
			if (que.equals(q)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void removeWrongQuestion() {
		wrongquestions.remove(0);
	}
	
	@Override
	public void addPointsRound1(int weight) {
		this.points_round1 += weight ;		
	}
	
	@Override
	public void addPointsRound2(int weight) {
		this.points_round2 += weight ;		
	}
	
	@Override
	public int getPointsRound1() {
		return this.points_round1;
	}
	
	@Override
	public int getPointsRound2() {
		return this.points_round2;
	}
	
	
}
