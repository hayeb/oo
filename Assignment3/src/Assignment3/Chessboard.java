package Assignment3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author Haye Bohm - s4290402
 * @author Ylja Remmits - 4373510
 */
public class Chessboard {
	private int size;
	private Position[][] chessboard;
	private ArrayList<Position> visited = new ArrayList<Position>();

	/**
	 * Initialize a chessboard of size "size"*"size". Also creates a position
	 * object for each coordinate.
	 * 
	 * @param size
	 */
	public Chessboard(int size) {
		this.size = size;
		chessboard = new Position[size][size];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				chessboard[i][j] = new Position(i, j);
			}
		}
	}

	/**
	 * Generates all legal successors of position p on the chessboard. Takes
	 * into account if the position is inside the board range and if the
	 * position is already visited.
	 * 
	 * @param p
	 *            = The current position on the board (Class Position)
	 * @return All legal successors
	 */
	public ArrayList<Position> generateSuccessors(Position p) {
		ArrayList<Position> successors = new ArrayList<Position>();
		int x = p.getPositionX();
		int y = p.getPositionY();
		successors.add(new Position(x + 1, y + 2));
		successors.add(new Position(x + 1, y - 2));
		successors.add(new Position(x + 2, y + 1));
		successors.add(new Position(x + 2, y - 1));
		successors.add(new Position(x - 1, y + 2));
		successors.add(new Position(x - 1, y - 2));
		successors.add(new Position(x - 2, y + 1));
		successors.add(new Position(x - 2, y - 1));

		for (int i = 0; i < successors.size(); i++) {
			if (successors.get(i).getPositionX() < 0
					|| successors.get(i).getPositionX() >= this.size
					|| successors.get(i).getPositionY() < 0
					|| successors.get(i).getPositionY() >= this.size
					|| visited.contains(successors.get(i))) {
				successors.remove(i);
				i--;
			}
		}
		return successors;
	}

	/**
	 * Sorts the list of positions according to the number of successors they
	 * have.
	 * 
	 * @param unsorted
	 *            = List of positions
	 * @return Sorted list of positions
	 */
	public ArrayList<Position> sortPositions(ArrayList<Position> unsorted) {
		for (Position p : unsorted) {
			p.setSuccessors(generateSuccessors(p).size());
		}
		Collections.sort(unsorted, new Comparator<Position>() {
			public int compare(Position p1, Position p2) {
				if (p1.getSuccessors() > p2.getSuccessors())
					return -1;
				if (p1.getSuccessors() < p2.getSuccessors())
					return 1;
				return 0;
			}
		});
		return unsorted;
	}

	/**
	 * Returns the string representation of the (x, y) position on the
	 * chessboard.
	 * 
	 * @param x
	 *            = coordinate on the x axis
	 * @param y
	 *            = coordinate on the y axis
	 * @return String representation of the position on (x, y).
	 */
	public String getPosition(int x, int y) {
		return chessboard[x][y].toString();
	}

	/**
	 * Removes last index from list visited
	 */
	public void removeVisited() {
		visited.remove(visited.size() - 1);
	}

	/**
	 * Adds position p to the list of visited positions
	 * 
	 * @param p
	 *            = Position p on the chessboard
	 */
	public void addVisited(Position p) {
		visited.add(p);
	}

	/**
	 * Returns if the current path in the visited list is a completer path (has
	 * visited all squares)
	 * 
	 * @return true is complete path, false else.
	 */
	public boolean isCompletePath() {
		return visited.size() == (size * size);
	}

	/**
	 * Returns the current sequence of positions in the visited list
	 * 
	 * @return the current sequence in visited list.
	 */
	public ArrayList<Position> getPath() {
		return visited;
	}

}
