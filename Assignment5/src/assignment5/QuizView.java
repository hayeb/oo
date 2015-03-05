package assignment5;

public interface QuizView {
	public void updateView() ;
	public void update(Question q) ;
	public void congratulate() ;
	public void punish() ;
	public void showCorrectAnswer(String s);
	public void showEnd();
}
