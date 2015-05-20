package tests;

import assignment12b.FibonacciConcurrent2Thread;

/**
 * Class to the test 2-threads-per-calculation version of Fibonacci.
 * 
 * @author Haye Bohm - 4290402
 * @author Ylja Remmits - 4373510
 *
 */
public class FibonacciConcurrent2ThreadTest {

	public FibonacciConcurrent2ThreadTest() {
		try {
			FibonacciConcurrent2Thread fibc20 = new FibonacciConcurrent2Thread(
					20);
			fibc20.start();
			fibc20.join();
			System.out.print("The 20th fibonacci number is: "
					+ fibc20.getResult() + "\n");

			FibonacciConcurrent2Thread fibc25 = new FibonacciConcurrent2Thread(
					25);
			fibc25.start();
			fibc25.join();
			System.out.print("The 25th fibonacci number is: "
					+ fibc25.getResult() + "\n");

			FibonacciConcurrent2Thread fibc30 = new FibonacciConcurrent2Thread(
					30);
			fibc30.start();
			fibc30.join();
			System.out.print("The 30th fibonacci number is: "
					+ fibc30.getResult() + "\n");
		} catch (InterruptedException e) {
			System.err.println(e);
		}

	}

}
