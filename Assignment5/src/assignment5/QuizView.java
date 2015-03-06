package assignment5;

public interface QuizView {

	public void showQuestion(Question q) ;
	public void congratulate() ;
	public void punish() ;
	public void showCorrectAnswer(String s);
	public void showEnd(int round1, int round2);
}
