/**
 * 
 */
package de.inpiraten.votecalculator;

/**
 * @author Andi Popp
 *
 */
public class BinaryBallotResult extends BallotResult{

	
	
	/**
	 * The number of votes for every candidate
	 */
	public final double[] numberOfVotes;

	/**
	 * Full parameter constructor
	 * @param candidates
	 * @param numberOfVotes
	 * @param winners
	 */
	public BinaryBallotResult(String[] candidates, double[] numberOfVotes,
			String[] winners) {
		super();
		this.candidates = candidates;
		this.numberOfVotes = numberOfVotes;
		this.winners = winners;
	}

	
}
