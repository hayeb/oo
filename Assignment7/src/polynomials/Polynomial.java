package polynomials;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * A skeleton class for representing Polynomials
 *
 * @author Haye Bohm - s4290402
 * @author Ylja Remmits - s4373510
 * @date 10-03-2015
 */
public class Polynomial {

	/**
	 * A polynomial is a sequence of terms here kept in an List
	 */
	List<Term> terms;

	/**
	 * A constructor for creating the zero Polynomial zero is presented as an
	 * empty list of terms and not as a single term with 0 as a coefficient
	 */
	public Polynomial() {
		terms = new ArrayList<>();
	}

	/**
	 * A Constructor creating a polynomial from the argument string.
	 *
	 * @param s
	 *            a String representing a list of terms which is converted to a
	 *            scanner and passed to scanTerm for reading each individual
	 *            term
	 */
	public Polynomial(String s) {
		terms = new ArrayList<>();
		Scanner scan = new Scanner(s);

		for (Term t = Term.scanTerm(scan); t != null; t = Term.scanTerm(scan)) {
			terms.add(t);
		}
	}

	/**
	 * The copy constructor for making a deep copy
	 *
	 * @param p
	 *            the copied polynomial
	 *
	 */
	public Polynomial(Polynomial p) {
		terms = new ArrayList<>(p.terms.size());
		for (Term t : p.terms) {
			terms.add(new Term(t));
		}
	}

	/**
	 * A straightforward conversion of a Polynomial into a string based on the
	 * toString for terms
	 *
	 * @return a readable string representation of this
	 */
	@Override
	public String toString() {
		sortOnExp();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < terms.size(); i++) {
			if (i == 0) {
				sb.append(terms.get(i).toString());
			} else if (terms.get(i).getCoef() < 0) {
				sb.append(" " + terms.get(i).toString());
			} else {
				sb.append(" + " + terms.get(i).toString());
			}
		}
		return sb.toString();
	}

	/**
	 * Sorts the terms list in this object according to their exponents, from
	 * high to low.
	 */
	public void sortOnExp() {
		Collections.sort(terms, new Comparator<Term>() {
			@Override
			public int compare(Term pol1, Term pol2) {

				return pol2.getExp() - (pol1.getExp());
			}
		});
	}

	/**
	 * Adds polynomial p to this polynomial, and stores the result in this
	 * object. We use a enhanced for-loop for this uses iterators in its
	 * underneath structure.
	 * 
	 * @param p
	 */
	public void plus(Polynomial p) {
		for (Term a : terms) {
			for (Term b : p.terms) {
				if (a.getExp() == b.getExp()) {
					a.plus(b);
					b.setCoefficient(0);
				}
			}
		}
		for (Term c : p.terms) {
			if (c.getCoef() != 0) {
				terms.add(c);
			}
		}
		cleanZero();
	}

	/**
	 * Cleans the terms list: removes terms with a coefficient of 0.
	 */
	public void cleanZero() {
		ArrayList<Term> remove = new ArrayList<Term>();
		// Check for terms which shouldn't be there
		for (Term t : terms) {
			if (t.getCoef() == 0) {
				remove.add(t);
			}
		}
		terms.removeAll(remove);
	}

	/**
	 * Cleans the terms list: adds terms with the same exponent.
	 */
	public void cleanSameExponent() {
		for (int i = 0; i < terms.size(); i++) {
			for (int j = i + 1; j < terms.size(); j++) {
				if (terms.get(i).getExp() == terms.get(j).getExp()) {
					terms.get(i).plus(terms.get(j));
					terms.set(j, new Term(0, 0));
				}
			}
		}
	}

	/**
	 * Saves the outcome of multiplying polynomial p with this polynomial. We
	 * use a enhanced for-loop for this uses iterators in its underneath
	 * structure.
	 * 
	 * @param p
	 *            A polynomial p.
	 */
	public void times(Polynomial p) {
		ArrayList<Term> newterms = new ArrayList<Term>();
		for (Term a : terms) {
			for (Term b : p.terms) {
				Term c = new Term(a);
				c.times(b);
				newterms.add(c);
			}
		}
		terms.clear();
		terms.addAll(newterms);
		cleanSameExponent();
		cleanZero();
	}

	/**
	 * Substracts polynomial p from this polynomial.
	 * 
	 * @param p
	 */
	public void minus(Polynomial p) {
		for (Term t : p.terms) {
			t.setCoefficient(-1 * t.getCoef());
		}
		plus(p);
	}

	/**
	 * Applies this polynomial to the input x, and returns the result.
	 * 
	 * @param x
	 *            The input variable.
	 * @return The result of the polynomial with input variable x.
	 */
	public int apply(int x) {
		int result = 0;
		for (Term s : terms) {
			result += s.getCoef() * Math.pow(x, s.getExp());
		}
		return result;
	}

	@Override
	public boolean equals(Object other_poly) {
		return false;
	}

}
