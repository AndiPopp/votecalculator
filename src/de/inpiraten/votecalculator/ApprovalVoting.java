/**
 * 
 */
package de.inpiraten.votecalculator;

import org.apache.commons.lang3.ArrayUtils;

/**
 * @author Andi Popp
 *
 */
public class ApprovalVoting extends VotingSystem {

	
	public int numberOfWinners;
	
	public byte majority;
	
	public static BinaryBallotResult calculate(BinaryBallot[] ballots, int numberOfWinners, byte majority) throws IllegalBallotException{
		//check majority input
		if (!(majority==VotingSystem.SIMPLE_MAJORITY || majority==VotingSystem.RELATIVE_MAJORITY)) throw new IllegalArgumentException("Majority "+majority+" not supported");
		
		//check if ballots are for the same candidates
		for (int i = 1; i < ballots.length; i++){
			if (!ArrayUtils.isEquals(ballots[0].candidates, ballots[i].candidates))
				throw new IllegalBallotException("Candidate lists for ballots do not match");
		}
		
		String[] candidates = ballots[0].candidates;
		double[] result = new double[candidates.length];
		
		//calculates total votes
		for (int i = 0; i < ballots.length; i++){
			for (int j = 0; j < ballots[i].votes.length; j++){
				if (ballots[i].votes[j]) result[j] += ballots[i].weight;
			}
		}
		
		//calculate the winners
		double[] tempResult = ArrayUtils.clone(result);
		String[] winners = ArrayUtils.EMPTY_STRING_ARRAY;
		int[] placement = ArrayUtils.EMPTY_INT_ARRAY;
		
		while(winners.length < numberOfWinners){
			int[] currentWinnerIndexes = getWinnerIndex(tempResult);
			int currentPlacement = winners.length+1;

			if (majority == VotingSystem.SIMPLE_MAJORITY || !(result[currentWinnerIndexes[0]]/ballots.length > .5)) break;
			
			for (int i = 0; i < currentWinnerIndexes.length; i++){
				ArrayUtils.add(winners, candidates[currentWinnerIndexes[i]]);
				ArrayUtils.add(placement, currentPlacement);
				tempResult[currentWinnerIndexes[i]] = 0.0;
			}
		}
	
		//return results
		return new BinaryBallotResult(candidates, result, winners);
	}
	
	
	private static int[] getWinnerIndex(double[] result){
		int[] output = {0};
		for (int i = 1; i < result.length; i++){
			if (result[i] > result[output[0]]) {
				output = ArrayUtils.EMPTY_INT_ARRAY;
				ArrayUtils.add(output, i);
			}
			else if (result[i] == result[output[0]]){
				ArrayUtils.add(output, i);
			}
			else if (result[i] + 0.0000000001 > result[output[0]]){
				System.out.println("Warning: There was a low difference between candidate index "+output[0]+" and "+i);
			}
		}
		return output;
	}
}
