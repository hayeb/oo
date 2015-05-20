package assignment12b;

/**
 * Class to calculate the n-th fibonacci number. Exits if an out-of-memory-error
 * occurs. Uses threads: the n-1 number is calculated on the current thread, the
 * n-2 number is calculated on a new thread.
 * 
 * @author Haye Bohm - 4290402
 * @author Ylja Remmits - 4373510
 */
public class ParFib implements Runnable {

	private int number;
	private int result;

	public ParFib(int n) {
		this.number = n;
	}

	@Override
	public void run() {
		calcFib();

	}

	/**
	 * Calculates the Fibonacci number for the current number in the number
	 * class attribute. Uses a new thread for number - 2. Waits for that thread
	 * to end before saving the result.
	 */
	public void calcFib() {
		if (number < 2 && number > 0) {
			result = 1;
		} else if (number == 0) {
			result = 0;
		} else {
			try {
				// Create new thread for the n - 2
				ParFib fib2 = new ParFib(number - 2);
				Thread t2 = new Thread(fib2);
				t2.start();
				ParFib fib1 = new ParFib(number - 1);
				fib1.calcFib();
				t2.join();
				result = fib1.getResult() + fib2.getResult();
			} catch (Exception e) {

			} catch (OutOfMemoryError e) {
				System.err.print("Out of memory. Terminating.\n");
				System.exit(1);
			}

		}
	}

	/**
	 * Returns the result of the calcFib method. Should only be used AFTER
	 * invoking the calcFIb method.
	 * 
	 * @return
	 */
	public int getResult() {
		return this.result;
	}

}
