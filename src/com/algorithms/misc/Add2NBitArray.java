package com.algorithms.misc;

/**
 * Here, wheneve 2 integers are being added, assume that the 2 can have only 2 values: 0 and 1
 * ,i.e, are binary.
 * 
 * alternate : could have used a binary array instead/not doing it for this implementation
 * 
 * Approach:
 * - start from the end and add each value in A with corresponding value in B
 * - since A+B will have n+1 elements, A[i] + B[i] will be at i+1th posistion in the
 *   resultant array.
 *   
 *   eg:
 *   0,0,0,0
 *   0.0,0,1
 *   
 *   resultant:
 *   0,0,0,0,1
 *   
 *   last element for the resultant array is at a different position that for A or B
 * 
 * @author karana
 *
 */
public class Add2NBitArray {
	
	public int[] add2Arrays(int A[], int B[]) {
		
		int C[] = new int[A.length + 1];
		int carry = 0;
		for (int i = A.length - 1; i >= 0; i--) {
			C[i + 1] = sumBinIntegersCarry(A[i], B[i], carry);
			carry = carryBinIntegersCarry(A[i], B[i], carry);
		}
		
		/*
		 * first element of the resultant array will be the carry bit
		 */
		C[0] = carry;
		return C;
	}
	
	/**
	 * carry when 2 binary integers are added
	 * carry : x AND y based on truth table and boolean simplification
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public int carryTwoBinIntegers(int x, int y) {
		return x & y;
	}
	
	/**
	 * sum 2 binary integers.
	 * sum = x XOR Y based on the truth table simplification
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public int sumTwoBinIntegers(int x, int y) {
		return x ^ y;
	}
	
	/**
	 * Binary add x, y and the carry c.
	 * Based on the truth table and simplification:
	 * sum = x XOR y XOR c
	 * 
	 * @param x
	 * @param y
	 * @param c
	 * @return sum
	 */
	public int sumBinIntegersCarry(int x, int y, int c) {
		return x ^ y ^ c;
	}
	
	/**
	 * Carry field in case x, y and carry c are added
	 * 
	 * carry = x AND y OR (carry AND (x XOR y))
	 * 
	 * @param x
	 * @param y
	 * @param c
	 * @return
	 */
	public int carryBinIntegersCarry(int x, int y, int c) {
		return x & y | (c & (x ^ y));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Add2NBitArray a = new Add2NBitArray();
		
		/*
		 * validate sum
		 */
		System.out.println("validating sum");
		System.out.println(a.sumTwoBinIntegers(1, 1));
		System.out.println(a.sumTwoBinIntegers(1, 0));
		
		/*
		 * validate carry
		 */
		System.out.println("validating carry");
		System.out.println(a.carryTwoBinIntegers(1, 0));
		System.out.println(a.carryTwoBinIntegers(1, 1));
		
		
		int A[] = new int[]{0,0,0,0};
		int B[] = new int[]{1,1,1,1};
		int C[] = a.add2Arrays(A, B);
		
		StringUtils.displayArray(C, "resultant array after sum");
	}

}
