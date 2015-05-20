package assignment12b;

/**
 * Class which calculates the nth Fibonacci number using two threads for each of
 * the preceding fibinacci numbers. (This was made in error after
 * mis-interpretation fo the assignment.)
 * 
 * @author Haye Bohm - 4290402
 * @author Ylja Remmits - 4373510
 *
 */
public class FibonacciConcurrent2Thread extends Thread {
	private int number;
	private int result;

	public FibonacciConcurrent2Thread(int number) {
		this.number = number;
	}

	/**
	 * Starts the thread and calculates a Fibonacci number and stores the
	 * result.
	 */
	public void run() {
		calcFibonacci(number);
	}

	/**
	 * Calculates the Fibonacci number for n. Start two new threads for each
	 * preceding number and stores the results in result. Raises an InterruptedException if
	 * the join call on the thread fails, and halts the program when the program
	 * runs out of memory.
	 * 
	 * @param n
	 */
	private void calcFibonacci(int n) {
		if (n < 2 && n > 0) {
			result = 1;
		} else if (n == 0) {
			result = 0;
		} else {
			try {
				FibonacciConcurrent2Thread fibc1 = new FibonacciConcurrent2Thread(
						n - 1);
				FibonacciConcurrent2Thread fibc2 = new FibonacciConcurrent2Thread(
						n - 2);
				fibc1.start();
				fibc2.start();
				fibc1.join();
				fibc2.join();
				result = fibc1.getResult() + fibc2.getResult();
			} catch (InterruptedException e) {
				System.err.println(e);
				System.exit(1);
			} catch (OutOfMemoryError e) {
				System.err.println(e);
				System.exit(2);
			}
		}
	}

	/**
	 * Returns the result.
	 * 
	 * @return
	 */
	public int getResult() {
		return result;
	}

}
