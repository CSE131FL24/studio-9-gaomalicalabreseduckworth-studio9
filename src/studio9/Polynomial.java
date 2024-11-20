package studio9;

import java.util.LinkedList;

public class Polynomial {
	
	private LinkedList<Double> list;

	/**
	 * Constructs a Polynomial with no terms yet.
	 */
	public Polynomial() {
		this.list = new LinkedList<>(); // Initialize an empty list of coefficients
	}

	/**
	 * Adds a term to the polynomial by appending its coefficient.
	 * 
	 * @param coeff the coefficient of the new term
	 */
	public void addTerm(double coeff) {
		list.add(coeff); // Add the coefficient to the end of the list
	}

	/**
	 * Returns a String representation of the polynomial in the proper form:
	 * Cx^N + Cx^N-1 + ... + Cx + C
	 * 
	 * @return the polynomial as a String
	 */
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		int degree = list.size() - 1;

		for (int i = 0; i < list.size(); i++) {
			double coeff = list.get(i);

			if (coeff != 0) { // Only include non-zero terms
				// Add "+" or "-" for proper formatting
				if (result.length() > 0 && coeff > 0) {
					result.append(" + ");
				} else if (coeff < 0) {
					result.append(" - ");
					coeff = -coeff; // Make positive for display
				}

				// Add the coefficient and variable
				if (degree == 0) {
					result.append(coeff); // Constant term
				} else if (degree == 1) {
					result.append(coeff + "x"); // Linear term
				} else {
					result.append(coeff + "x^" + degree); // Higher degree terms
				}
			}
			degree--;
		}

		return result.toString();
	}

	/**
	 * Evaluates the polynomial for a given value of x.
	 * 
	 * @param x the value to substitute into the polynomial
	 * @return the result of evaluating the polynomial
	 */
	public double evaluate(double x) {
		double result = 0;
		int degree = list.size() - 1;

		for (int i = 0; i < list.size(); i++) {
			result += list.get(i) * Math.pow(x, degree);
			degree--;
		}

		return result;
	}

	/**
	 * Computes the derivative of the polynomial using the power rule.
	 * 
	 * @return a new Polynomial object representing the derivative
	 */
	public Polynomial derivative() {
		Polynomial derivative = new Polynomial();
		int degree = list.size() - 1;

		for (int i = 0; i < list.size(); i++) {
			double coeff = list.get(i);
			if (degree > 0) {
				derivative.addTerm(coeff * degree); // Apply the power rule
			}
			degree--;
		}

		return derivative;
	}

	/**
	 * Determines whether this polynomial is equal to another object.
	 * 
	 * @param obj the object to compare
	 * @return true if the two polynomials are equal, false otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true; // Same object
		}
		if (obj == null || !(obj instanceof Polynomial)) {
			return false; // Null or not a Polynomial
		}
		Polynomial other = (Polynomial) obj;
		return this.list.equals(other.list); // Compare the coefficient lists
	}
}
