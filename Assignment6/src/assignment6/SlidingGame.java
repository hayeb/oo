package assignment6;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Pieter Koopman, Sjaak Smetsers
 * @version 1.2
 * @date 28-02-2015 A template implementation of a sliding game also
 *       implementing the Graph interface
 * @author Haye Bohm - s4290402
 * @author Ylja Remmits - s4373510
 */
public class SlidingGame implements Configuration {
	public static final int N = 3, SIZE = N * N, HOLE = SIZE;
	/*
	 * The board is represented by a 2-dimensional array; the position of the
	 * hole is kept in 2 variables holeX and holeY
	 */
	private int[][] board;
	private int holeX, holeY;
	private int manhattandistance;

	private Direction[] directions = { Direction.NORTH, Direction.SOUTH,
			Direction.EAST, Direction.WEST };

	/*
	 * A constructor that initializes the board with the specified array
	 * 
	 * @param start: a one dimensional array containing the initial board. The
	 * elements of start are stored row-wise.
	 */
	public SlidingGame(int[] start) {
		board = new int[N][N];

		assert start.length == N * N : "Length of specified board incorrect";

		for (int p = 0; p < start.length; p++) {
			board[p % N][p / N] = start[p];
			if (start[p] == HOLE) {
				holeX = p % N;
				holeY = p / N;
			}
		}
		calcManhattan();

	}

	/*
	 * Converts a board into a printable representation. The hole is displayed
	 * as a space
	 * 
	 * @return the string representation
	 */
	@Override
	public String toString() {
		StringBuilder buf = new StringBuilder();
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				int puzzel = board[col][row];
				buf.append(puzzel == HOLE ? "  " : puzzel + " ");
			}
			buf.append("\n");
		}
		return buf.toString();
	}

	/*
	 * a standard implementation of equals checking whether 2 boards are filled
	 * in exactly the same way
	 * 
	 * @return a boolean indicating equality
	 */
	@Override
	public boolean equals(Object o) {
		if (o == null || o.getClass() != getClass()) {
			return false;
		} else {
			SlidingGame other_puzzle = (SlidingGame) o;
			for (int row = 0; row < N; row++) {
				for (int col = 0; col < N; col++) {
					if (board[col][row] != other_puzzle.board[col][row]) {
						return false;
					}
				}
			}
			return true;
		}
	}

	/**
	 * Returns if a configuration is a solution.
	 * 
	 */
	@Override
	public boolean isSolution() {
		int teller = 1;
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				if (board[col][row] == teller) {
					teller++;
				} else if (col == N - 1 && row == N - 1
						&& board[col][row] == HOLE) {
					return true;
				} else
					return false;
			}
		}
		return true;

	}

	/**
	 * Returns a list of legal successors of the current board layout.
	 */
	@Override
	public Collection<Configuration> successors() {
		ArrayList<Configuration> successors = new ArrayList<Configuration>();
		for (Direction d : directions) {
			int dx = d.GetDX();
			int dy = d.GetDY();
			if (isLegal(dx, dy)) {
				int temp = board[holeX + dx][holeY + dy];
				int[][] newboard = copyArray(board);
				newboard[holeX][holeY] = temp;
				newboard[holeX + dx][holeY + dy] = HOLE;

				successors.add(new SlidingGame(flatten(newboard)));
			}
		}
		return successors;
	}

	/**
	 * Returns if the position of the hole is legal after a certain slide.
	 * 
	 * @param dx
	 * @param dy
	 * @return true if the position is legal.
	 */
	private boolean isLegal(int dx, int dy) {
		if (holeX + dx > N - 1 || holeX + dx < 0 || holeY + dy > N - 1
				|| holeY + dy < 0) {
			return false;
		}
		return true;
	}

	/**
	 * Copies the contents of array into a new array and returns the new array.
	 * 
	 * @param array
	 *            The array to copy.
	 * @return A new array with the contents of the input array.
	 */
	private int[][] copyArray(int[][] array) {
		int[][] new_array = new int[array.length][array[0].length];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				new_array[i][j] = array[i][j];
			}
		}
		return new_array;

	}

	/**
	 * Flattens a 2 dimensional array. Returns a 1 dimensional representation of
	 * the input array.
	 * 
	 * @param array
	 *            A 2 dimensional array to flatten.
	 * @return A new
	 */
	private int[] flatten(int[][] array) {
		int[] new_array = new int[array.length * array.length];
		for (int i = 0; i < array.length * array.length; i++) {
			new_array[i] = array[i % N][i / N];
		}
		return new_array;
	}

	/**
	 * Calculates the manhattan distance for each piece of the puzzle to their
	 * desired position. It stores the result in a class variable
	 * manhattandistance.
	 */
	public void calcManhattan() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				int value = board[i][j];
				manhattandistance += (Math.abs((N % value) - i) + Math.abs(N
						/ value - j));
			}
		}
	}

	@Override
	public int compareTo(Configuration g) {
		if (!(g instanceof SlidingGame)) {
			return -1;
		}
		SlidingGame gs = (SlidingGame) g;
		return getManhattanDistance() - gs.getManhattanDistance();
	}

	@Override
	public int hashCode() {
		int value = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				value += board[i][j] * ((int) Math.pow(31, i + j * N));
			}
		}

		return value;
	}

	/**
	 * Returns the Manhattan Distance, calculated by calcManhattan.
	 * @return manhattan distance
	 */
	public int getManhattanDistance() {
		return manhattandistance;
	}
}
