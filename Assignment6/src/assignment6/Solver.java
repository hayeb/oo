package assignment6;

import java.util.Collection;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * A class that implements a breadth-first search algorithm for finding the
 * Configurations for which the isSolution predicate holds
 * 
 * @author Pieter Koopman, Sjaak Smetsers
 * @version 1.3
 * @date 28-02-2013
 * @author Haye Bohm - s4290402
 * @author Ylja Remmits - s4373510
 */
public class Solver {
	// A queue for maintaining graphs that are not visited yet.
	private Queue<Node<Configuration>> toExamine;
	private Collection<Configuration> visited;

	public Solver(Configuration g) {
		toExamine = new PriorityQueue<Node<Configuration>>();
		toExamine.add(new Node<Configuration>(null, g));
		visited = new HashSet<Configuration>();
		visited.add(g);
	}

	/*
	 * A skeleton implementation of the solver
	 * 
	 * @return a string representation of the solution
	 */
	public String solve() {
		while (!toExamine.isEmpty()) {
			Node<Configuration> next = toExamine.poll();
			Configuration current = next.getItem();
			if (current.isSolution()) {
				System.out.println("Succes!");
				System.out.println("Path length:" + next.length());
				System.out.print(next);
				return "Success!";
			} else {
				for (Configuration succ : current.successors()) {
					if (!visited.contains(succ)) {
						// System.out.println("Node added!");
						visited.add(succ);
						toExamine.add(new Node<Configuration>(next, succ));
					}
				}
			}
		}
		return "Failure!";
	}
}
