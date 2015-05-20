package tests;

import assignment12b.ParFib;
/**
 * Class to test the ParFib class until it throws an OutOfMemoryError.
 * @author Haye Bohm - 4290402
 * @author Ylja Remmits - 4373510
 *
 */
public class ParFibTest {

	public ParFibTest() {		
		for (int i = 3; i < Integer.MAX_VALUE; i++) {
			ParFib pf = new ParFib(i);
			pf.calcFib();
			System.out.println("The " + i + "th fib number: " + pf.getResult());
		}
	}

}
