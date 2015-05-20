package tests;
/**
 * runs test for assignment 12.
 * @author Haye Bohm - 4290402
 * @author Ylja Remmits - 4373510
 *
 */
public class RunTests {

	public RunTests() {
		
	}
	
	/**
	 * Runs tests for this assignment. Due to threading, uncomment the desired test.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		//FileFinderTest fft = new FileFinderTest();
		//FibonacciConcurrent2ThreadTest fct = new FibonacciConcurrent2ThreadTest();
		new ParFibTest();
	}

}
