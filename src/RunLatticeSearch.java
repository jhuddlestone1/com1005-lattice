 /**
   * RunLatticeSearch.java
   *
   * @author <a href="mailto: "Phil Green</a>, modified by Jamie Huddlestone
   * 2019 version
   *
   * run a word lattice search
   *
 */

import sheffield.*;
import java.util.*;

public class RunLatticeSearch {

  public static void main(String[] args) {

    // get name of lattice file and algorithm from args, use default if not provided
    
    String latticeFile = args.length > 0 ? args[0] : "latt1.txt";
    String algorithm = args.length > 1 ? args[1] : "branchAndBound";

    // create an EasyWriter

    EasyWriter screen = new EasyWriter();

    // create a WordLattice

    WordLattice latt= new WordLattice();

    // download the word lattice data from file

    latt.latticeFromFile(latticeFile);

    // exaample vocabulary for Language Model

    String [] vocab= {"please","lettuce","know","flea","use","throw","freeze","let","useless","us"};

    // example costMatrix for LM

    int [][] costs ={{500,100, 80,120, 20, 40, 60, 20,120, 30},
                     { 50,500,100,120, 90, 60, 90, 70,110,120},
                     { 50, 80,500, 90,100, 80, 70, 80,100, 40},
                     { 60,120,110,500,100, 90, 80, 60,100,100},
                     { 30, 70, 80, 90,500, 50,100, 70, 90, 40},
                     { 50, 60, 90, 80, 80,500,120, 90,100, 40},
                     { 60, 80,120,100,110,100,500, 70,120, 70},
                     { 70, 50, 70, 60, 40, 80, 90,500, 90, 20},
                     {100, 90, 80, 60, 80, 40, 90, 80,500, 90},
                     { 20,100, 60,100, 70, 60, 80, 40, 90,500}};

    // create a bigram language model
    LM bg = new LM(vocab,costs);

    // once you've written LatticeSearch you can create an instance like so
    // a LatticeSearch is defined by the lattice and LM

    LatticeSearch lsearch = new LatticeSearch(latt,bg);

    // once you've written LatticeState you can create an intial state for the search:

    SearchState initState = (SearchState) new LatticeState(new WordH("*start*",0,0,0),0);

    // then you can run the search:

    String res_bb = lsearch.runSearch(initState, algorithm);

    // & print the results
    screen.println(res_bb);
  }


}










