/**
 * 
 */
package de.inpiraten.votecalculator;

/**
 * @author Andi Popp
 *
 */
public abstract class Ballot {
	
	
	/**
	 * The array of names of the candidates to be voted
	 */
	String[] candidates;
	
	/**
	 * The weight of the ballot. Adjustable for STV voting systems
	 */
	public double weight = 1.0;
	
	/**
	 * Sets the ballot back to full weight
	 */
	public void resetWeight(){
		this.weight = 1.0;
	}
}
