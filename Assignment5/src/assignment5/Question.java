package assignment5;

/**
 * Abstract class for all questions
 * 
 * @author Haye Bohm - s4290402
 * @author Ylja Remmits - s4373510
 */
public abstract class Question {
	protected int weight;
	private final int DEFAULT_WEIGHT = 3;
	protected String question;
	protected String answer;

	/**
	 * Initializes a question with a specified weight.
	 * 
	 * @param weight
	 */
	public Question(int weight) {
		if (weight >= 1 && weight <= 5) {
			this.weight = weight;
		} else {
			this.weight = DEFAULT_WEIGHT;
		}
	}

	/**
	 * Initializes a question with a default weight.
	 */
	public Question() {
		this.weight = DEFAULT_WEIGHT;
	}

	@Override
	public String toString() {
		return "Vraag: " + question + "\n";
	}

	/**
	 * Retuns if the answer is correct.
	 * @param answer
	 * @return
	 */
	public boolean isCorrect(String answer) {
		if (answer.equalsIgnoreCase(this.answer)) {
			return true;
		}
		return false;
	}

	/**
	 * Returns the right answer.
	 * @return
	 */
	public String isRight() {
		return "The answer is: " + this.answer + "\n";
	}

	/**
	 * Returns of two object of class Question are equal.
	 */
	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (o == this) {
			return true;
		}
		if (!(o instanceof Question)) {
			return false;
		}

		Question que = (Question) o;
		if (this.answer == que.answer && this.question == que.question
				&& this.weight == que.weight) {
			return true;
		}
		return false;
	}

	public abstract Question duplicate();

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
}
