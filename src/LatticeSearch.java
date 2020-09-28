/**	LatticeSearch.java
 *	
 *	@date 2019-03-17
 *	@author	Jamie Huddlestone
 */

import java.util.*;

public class LatticeSearch extends Search {
	
	// Instance fields
	private WordLattice lattice;
	private LM model;
	
	// Constructor
	public LatticeSearch(WordLattice lattice, LM model) {
		this.lattice = lattice;
		this.model = model;
	}
	
	// Accessors
	public WordLattice getWordLattice() {
		return lattice;
	}
	public int getEndTime() {
		return lattice.getEndTime();
	}
	public ArrayList<WordH> wordsAtT(int t) {
		return lattice.wordsAtT(t);
	}
	public LM getLM() {
		return model;
	}
	public int getCost(String w1, String w2) {
		return model.getCost(w1, w2);
	}
	
	// Test harness
	public static void main(String[] args) {
		
		WordLattice testLattice = new WordLattice();
		testLattice.latticeFromFile("latt1.txt");
	
		System.out.println("----------------------------------------");
		System.out.println(testLattice);
		System.out.println("End time: "+ testLattice.getEndTime());
		System.out.println("Words at time 0: ");
		System.out.println(testLattice.wordsAtT(0));
		System.out.println("----------------------------------------");
	}
}