package com.algorithms.datastructures.stack;

import com.algorithms.misc.StringUtils;


/*
 * Assume array index is from 0 to n-1:
 * - start S1 from 0 where push will increment S1.top
 *   - pop decreases S1.top
 * - start S2 from n where push will decrement S2.top
 *   - pop increases S2.top
 *   
 * The array is considered full when (S1.top + 1) == S2.top
 * 
 * Not writing the logic for S1 since its the same as a normal Stack
 * implemented using array
 */
public class TwoStacksSingleArray {
	
	static int n = 4;
	int S[] = new int[n];
	int top1 = -1;
	int top2 = n;
	
	public void pushS2(int x) {
		if (top1 + 1 == top2) {
			throw new RuntimeException("No more insertions possible");
		}
		
		top2--;
		S[top2] = x;
	}
	
	public int popS2() {
		if (top2 == n) {
			throw new RuntimeException("No elements to pop, stack empty");
		}
		
		int x = S[top2++];
		return x;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TwoStacksSingleArray ts = new TwoStacksSingleArray();
		ts.pushS2(1);
		ts.pushS2(2);
		ts.pushS2(3);
		ts.pushS2(4);
		
		StringUtils.displayArray(ts.S, "Current stack contents");
		
		try {
			ts.pushS2(5);
		} catch (RuntimeException e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

}
