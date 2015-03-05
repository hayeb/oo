package assignment5;

/**
 * 
 * @author Haye Bohm - s4290402
 * @author Ylja Remmits - s4373510
 */
public abstract class Question {
	protected int weight;
	private final int DEFAULT_WEIGHT = 3;
	protected String question;
	protected String answer;

	public Question(int weight) {
		if (weight >= 1 && weight <= 5) {
			this.weight = weight;
		} else {
			this.weight = DEFAULT_WEIGHT;
		}
	}

	public Question() {
		this.weight = DEFAULT_WEIGHT;
	}

	@Override
	public String toString() {
		return "Vraag: " + question + "\n";
	}

	public boolean isCorrect(String antwoord) {
		if (antwoord.equalsIgnoreCase(this.answer)) {
			return true;
		}
		return false;
	}

	public String isRight() {
		return "The answer is: " + this.answer + "\n";
	}
	
	public abstract Question duplicate();
}
