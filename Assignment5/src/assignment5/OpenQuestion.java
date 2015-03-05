package assignment5;

/**
 * @author Haye Bohm - s4290402
 * @author Ylja Remmits - s4373510
 */
public class OpenQuestion extends Question {
	
	public OpenQuestion(int weight) {
		super(weight);
	}

	public OpenQuestion (String question,String answer, int weight) {
		super(weight) ;
		this.answer = answer;
		this.question = question ;
	}
	
	public OpenQuestion(String question, String answer) {
		super() ;
		this.question = question;
		this.answer = answer; 
	}
	
	@Override
	public String toString() {
		return "Open vraag: " + question + "\n" ;
	}
	
	public Question duplicate() {
		return this;
	}

}
