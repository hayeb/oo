package assignment5;

public interface QuizModel {

	public void createQuestions() ;
	public Question getNextQuestion() ;
	public void addWrongList(Question q);
}
