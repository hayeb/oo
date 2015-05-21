package assignment13a;

public class Player implements Runnable {
	private final Dice dice;
	private final String name;
	private final int numberOfThrows;
	
	public Player(String name, Dice dice, int numberOfThrows) {
		this.name = name;
		this.dice = dice;
		this.numberOfThrows = numberOfThrows;
	}
	
	@Override
	public void run() {
	        for (int i = 0; i < numberOfThrows; i += 1) {
	                int pips = dice.throwAndGet();
	                System.out.println(name + " throws " + pips + " in turn " + i + ".");
	        }
	}
	
	

}
