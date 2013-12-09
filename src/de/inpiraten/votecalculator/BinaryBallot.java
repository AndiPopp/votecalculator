/**
 * 
 */
package de.inpiraten.votecalculator;

/**
 * @author Andi Popp
 *
 */
public class BinaryBallot extends Ballot{


	
	/**
	 * The array of the votes for the candidates in the same order as in {@link #candidates}
	 */
	final boolean[] votes;

	/**
	 * Full parameter constructor
	 * @param candidates
	 * @param votes
	 * @throws IllegalArgumentException 
	 */
	public BinaryBallot(String[] candidates, boolean[] votes) throws IllegalArgumentException {
		if (candidates.length != votes.length) throw new IllegalArgumentException("Array sizes do not match");
		
		this.candidates = candidates;
		this.votes = votes;
		this.weight = 1.0;
	}
	
	
}
