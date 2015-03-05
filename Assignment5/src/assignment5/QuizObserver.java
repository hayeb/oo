package assignment5;

public class QuizObserver implements QuizView {

	public QuizObserver() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void updateView() {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Prints out the question q.
	 */
	@Override
	public void update(Question q) {
		
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
	
	@Override
	public void showEnd() {
		System.out.println("There are no more questions!");
	}
}
