/**	LatticeState.java
 *	
 *	@date 2019-03-17
 *	@author	Jamie Huddlestone
 */

import java.util.*;

public class LatticeState extends SearchState {
	
	// Instance fields
	private WordH word;

	// Constructor
	public LatticeState(WordH word, int localCost) {
		this.word = word;
		this.localCost = localCost;
	}

	// Accessors
	public String getWord() {
		return word.getWord();
	}
	
	public String toString() {
		return word.toString();
	}
	
	// Instance methods
	public boolean goalP(Search searcher) {
		LatticeSearch lsearcher = (LatticeSearch) searcher;
		return word.getEnd() == lsearcher.getEndTime();
	}
	
	public ArrayList<SearchState> getSuccessors(Search searcher) {
		LatticeSearch lsearcher = (LatticeSearch) searcher;
		ArrayList<WordH> successorWords = lsearcher.wordsAtT(word.getEnd());
		ArrayList<SearchState> successorStates = new ArrayList<>();		
		for (WordH successorWord : successorWords) {
			int cost = lsearcher.getCost(this.getWord(), successorWord.getWord());
			LatticeState successorState = new LatticeState(successorWord, cost);
			successorStates.add(successorState);
		}
		System.out.println("Successors: "+ successorStates);
		return successorStates;
	}
	
	public boolean sameState(SearchState n2) {
		// This works because the string representation of the state is enough to define it!
		return this.toString().equals(n2.toString());
	}
	
	// Test methods
	private static void testSameState(SearchState state1, SearchState state2) {
		boolean isSame = state1.sameState(state2);
		System.out.println(state1 + (isSame ? " == " : " != ") + state2);
	}
	
	// Test harness
	public static void main(String[] args) {
		
		LatticeState z = new LatticeState(new WordH("zero",0,0,0),0);
		LatticeState a = new LatticeState(new WordH("one ",0,0,0),0);
		LatticeState b = new LatticeState(new WordH("zero",1,0,0),0);
		LatticeState c = new LatticeState(new WordH("zero",0,1,0),0);
		LatticeState d = new LatticeState(new WordH("zero",0,0,1),0);
		LatticeState e = new LatticeState(new WordH("zero",0,0,0),1);
	
		System.out.println("----------------------------------------");
		testSameState(z, z);
		System.out.println("----------------------------------------");
		testSameState(z, a);
		testSameState(z, b);
		testSameState(z, c);
		testSameState(z, d);
		testSameState(z, e);
		System.out.println("----------------------------------------");
		testSameState(a, z);
		testSameState(b, z);
		testSameState(c, z);
		testSameState(d, z);
		testSameState(e, z);
		System.out.println("----------------------------------------");
	}
}