/**	MakeLattice.java
 *
 *	@date 2019-03-19
 *	@author Jamie Huddlestone
 */

import sheffield.*;
import java.util.*;

public class MakeRandomLatticeFile {
	
	public static void main(String[] args) {
		
		// Sets up file handling
		String filename = args.length > 0 ? args[0] : "lattice.txt";
		String bigrams = args.length > 1 ? args[1] : "bigrams.txt";
		EasyReader input = new EasyReader(bigrams);
		EasyWriter output = new EasyWriter(filename);
		
		// Sets up vocab array
		String[] vocab = input.readString().split(",");
		int vocabSize = vocab.length;
		
		// Selects words from vocab, giving plausible random time and cost values
		for (int i=0; i < vocabSize*2; i++) {
			int word = (int) Math.floor(Math.random() * vocabSize);
			int startTime = (int) Math.floor(Math.random() * vocabSize) * 10;
			int endTime = (int) Math.floor(Math.random() * vocabSize) * 10 + startTime + 10;
			int cost = (int) Math.floor(Math.random() * vocabSize) * 10;
			output.println(vocab[word]);
			output.println(startTime);
			output.println(endTime);
			output.println(cost);
		}
		
		// Mark end of lattice
		output.println("done");
	}
}