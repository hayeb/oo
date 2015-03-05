package Assignment3;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class to find a closed or open Knights Tour on a square chessboard.
 * @author Haye Bohm - 4290402
 * @author Ylja Remmits - 4373510
 *
 */
public class KnightsTourTUI {
	Scanner in = new Scanner(System.in);

	public KnightsTourTUI() {
		run();
	}

	/**
	 * TUI for finding a Knights Tour, open or closed.
	 */
	private void run() {
		boolean correct = false;
		while (!correct) {
			int size = getInputBoardSize();
			Chessboard chessboard = new Chessboard(size);
			String input = getInputPathType();
			if (input.equals("y")) {
				Position start = new Position(0, 0);
				searchClosed(start, chessboard);
				System.out.print(chessboard.getPath() + "\n"); // print the path to
														// console

			} else {
				Position start = new Position(0, 0);
				chessboard.addVisited(start);
				searchOpen(start, chessboard);
				System.out.print(chessboard.getPath() + "\n"); // print the path to
														// console

			}
		}
	}

	/**
	 * recursively searches through the chessboard cb, until a
	 * "Open Knights tour" is found.
	 * 
	 * @param p
	 *            = The starting position (works best for corners)
	 * @param cb
	 *            = The chessboard
	 * @return True if a knights tour is found.
	 */
	private boolean searchOpen(Position p, Chessboard cb) {
		ArrayList<Position> successors = cb.generateSuccessors(p);
		successors = cb.sortPositions(successors);
		// base case: There are no successors and the path is not complete
		if (successors.isEmpty() && !cb.isCompletePath()) {
			return false;
		} else if (successors.isEmpty() && cb.isCompletePath()) {
			System.out.println("Path found!");
			return true;
		} else {
			for (Position ps : successors) {
				cb.addVisited(ps);
				if (searchOpen(ps, cb)) {
					return true;
				} else {
					cb.removeVisited();
				}
			}
		}
		return false;
	}

	/**
	 * recursively searches through the chessboard cb, until a
	 * "Closed Knights tour" is found.
	 * 
	 * @param p
	 *            = The starting position (works best for corners)
	 * @param cb
	 *            = The chessboard
	 * @return True if a knights tour is found.
	 */
	private boolean searchClosed(Position p, Chessboard cb) {
		ArrayList<Position> successors = cb.generateSuccessors(p);
		successors = cb.sortPositions(successors);
		// base case: There are no successors and the path is not complete
		if (successors.isEmpty() && !cb.isCompletePath()) {
			return false;
		} else if (successors.isEmpty() && cb.isCompletePath()
				&& (p.getPositionX() == 0 && p.getPositionY() == 0)) {
			System.out.println("Path found!");
			return true;
		} else {
			for (Position ps : successors) {
				cb.addVisited(ps);
				if (searchClosed(ps, cb)) {
					return true;
				} else {
					cb.removeVisited();
				}
			}
		}
		return false;

	}

	/*
	 * Asks user if the path should be closed or open.
	 */
	private String getInputPathType() {
		boolean done = false;
		String input = "";
		while (!done) {
			System.out.println("Would you like a closed path? [y/n]");
			input = in.nextLine();
			if (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("n")) {
				done = true;
			}
		}
		return input;
	}

	private int getInputBoardSize() {
		boolean done = false;
		int size = 0;
		while (!done) {
			System.out
					.println("Please enter the size of the chessboard: (even int >= 6):");
			size = in.nextInt();
			in.nextLine();
			if (size >= 6 && size % 2 == 0) {
				done = true;
			}
		}
		return size;
	}
}
