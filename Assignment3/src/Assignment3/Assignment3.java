package Assignment3;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Haye Bohm - s4290402
 * @author Ylja Remmits - 4373510
 */
public class Assignment3 {

	public static void main(String[] args) {
		System.out.println("Hello there! Would you like a closed path? [y/n]");
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		boolean correct = false;
		while (!correct) {
			if (input.equals("y")) {
				correct = true;
				correct = true;
				System.out.println("Please enter the size of the chessboard: (int >= 6):");
				int size = scan.nextInt();
				scan.nextLine();
				System.out.println("Okay. Starting search..") ;
				Chessboard chessboard = new Chessboard(size);
				Position start = new Position(0, 0);
				//chessboard.addVisited(start);
				searchClosed(start, chessboard);
				System.out.print(chessboard.getPath());
			} else if (input.equals("n")) {
				correct = true;
				System.out.println("Please enter the size of the chessboard: (int >= 6):");
				int size = scan.nextInt();
				scan.nextLine();
				System.out.println("Okay. Starting search..") ;
				Chessboard chessboard = new Chessboard(size);
				Position start = new Position(0, 0);
				chessboard.addVisited(start);
				searchOpen(start, chessboard);
				System.out.print(chessboard.getPath());

			} else {
				System.out.println("Please enter y or n.");
				input = scan.nextLine();
			}
		}

	}

	/**
	 * recursively searches through the chessboard cb, until a "Open Knights tour" is
	 * found.
	 * 
	 * @param p
	 *            = The starting position (works best for corners)
	 * @param cb
	 *            = The chessboard
	 * @return True if a knights tour is found.
	 */
	public static boolean searchOpen(Position p, Chessboard cb) {
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
	 * recursively searches through the chessboard cb, until a "Closed Knights tour" is
	 * found.
	 * 
	 * @param p
	 *            = The starting position (works best for corners)
	 * @param cb
	 *            = The chessboard
	 * @return True if a knights tour is found.
	 */
	public static boolean searchClosed(Position p, Chessboard cb) {
		ArrayList<Position> successors = cb.generateSuccessors(p);
		successors = cb.sortPositions(successors);
		// base case: There are no successors and the path is not complete
		if (successors.isEmpty() && !cb.isCompletePath()) {
			return false;
		} else if (successors.isEmpty() && cb.isCompletePath() && (p.getPositionX() == 0 && p.getPositionY() == 0)) {
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

}
