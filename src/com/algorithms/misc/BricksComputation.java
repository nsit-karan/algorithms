package com.algorithms.misc;

/*
 * Problem from codingBat:
 * 
 * Need to make a row of bricks that is 'goal' inches long
 * small : no of small bricks of length 1
 * big : no of big bricks of length 5
 * 
 * true/false based on whether row can be constructed or not
 */
public class BricksComputation {
	
	public boolean makeBricks(int small, int big, int goal) {
		  int q = goal / 5;
		  
		  int pending_length = goal;
		  
		  /*
		   * If quotient is > max_big_bricks, then reduce the total length
		   * possible using the big bricks from the goal
		   * 
		   * Else, reduce the total length possible using only 'q' which is the
		   * quotient no of bricks
		   */
		  if (q > big) {
		     pending_length = pending_length - (5 * big);
		  } else {
		     pending_length = pending_length - (5 * q);
		  }
		  
		  /*
		   * Now, if pending_length is < small, then the remaining length
		   * can be covered using small bricks.
		   * 
		   * Else, not possible
		   */
		  if (pending_length <= small) {
		     return true;
		  } else {
		     return false;
		  }
		}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BricksComputation br = new BricksComputation();
		System.out.printf("small = 3, big = 1, goal = 8 : %b\n", br.makeBricks(3, 1, 8));
		System.out.printf("small = 3, big = 1, goal = 9 : %b\n", br.makeBricks(3, 1, 9));
		System.out.printf("small = 3, big = 2, goal = 10 : %b\n", br.makeBricks(3, 2, 10));
	}

}
