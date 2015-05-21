package assignment13a;

import java.util.Random;

public class Dice {
	private int pips;
	private final Random rand;
	public static final int MAX_PIPS = 6;
	
	public Dice() {
		rand = new Random();
	}
	
	public void throwDice() {
		pips = rand.nextInt(MAX_PIPS) + 1;
	}
	
	public int getPips() {
		return pips;
	}
	
	public synchronized int throwAndGet (){
	        this.throwDice();
	        return this.getPips();
	}
}
