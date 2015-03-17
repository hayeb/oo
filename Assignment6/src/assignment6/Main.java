package assignment6;

/**
 * Runs code for assignment 6
 * 
 * @author Haye Bohm - s4290402
 * @author Ylja Remmits - s4373510
 */
public class Main {

	public static void main(String[] args) {
		/*
		 * This puzzle is solvable 24 steps. Our current heuristic, Manhattan
		 * Distance, finds a path of 111 steps. When we disable the priority
		 * queue and use breadth first search, the algorithm finds the optimal
		 * path. Conclusion: our heuristic is not very good.
		 */

		int[] game = { 3, 8, 6, 7, 9, 2, 1, 5, 4 };

		SlidingGame s = new SlidingGame(game);
		Solver solver = new Solver(s);
		System.out.println(solver.solve());
	}
}
