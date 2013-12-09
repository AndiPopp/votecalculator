/**
 * 
 */
package de.inpiraten.votecalculator;

/**
 * @author Andi Popp
 *
 */
public class RangeBallot extends BinaryBallot {
	
	final RangeBallotConfig config;
	
	final int[] rangeVotes;

	/**
	 * Full parameter constructor
	 * @param config
	 * @param approvalVotes
	 * @param rangeVotes
	 * @throws IllegalArgumentException 
	 */
	public RangeBallot(RangeBallotConfig config, String[] candidates, boolean[] votes,
			int[] rangeVotes) throws IllegalArgumentException {
		super(candidates, votes);
		this.config = config;
		
		if (votes.length != rangeVotes.length) 
			throw new IllegalArgumentException("Lengths of array does not match");
		this.rangeVotes = rangeVotes;
	}
	
	
}
