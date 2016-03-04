/*
 * questions source : coding bat
 */

package com.algorithms.misc;

/*
 * General strategy:
 * - check if a no is k more than a multiple of a m, then:
 *   n mod m should be within the range 0 to k
 * 
 * - check if no is k less than a multiple of m, then:
 *   n + i where i is from 1 to k should be a multiple of m
 *   (n + i) % m should be 0 where i goes from 0 to k
 */
public class ModOperations {
	
	public boolean multiple3_or_5(int n) {
		if ((n % 3 == 0) || (n % 5 == 0)) {
			return true;
		}
		return false;
	}
	
	/*
	 * return true if no is multiple of 11 or 1 more than multiple of 11
	 */
	public boolean special11(int n) {
		if ((n % 11 == 0) || (n % 11 == 1)) {
			return true;
		}
		return false;
	}
	
	/*
	 * return true of n is multiple of 3 or 5 but not both
	 * On other words:
	 * 
	 * (n not multiple of 3 AND 5) and (n multiple of 3 or 5) 
	 */
	public boolean multiple3_5_not_both(int n) {
		if (!((n % 3 == 0) && (n % 5 == 0)) 
				&& 
				(n % 3 == 0 || n % 5 == 0)) {
			return true;
		}
		return false;

	}

	/*
	 * No 1 or 2 more than a multiple of 20
	 */
	public boolean more20(int n) {
		if ((n % 20 == 1) || (n % 20 == 2)) {
			return true;
		}
		return false;
	}

	/*
	 * given no 'n' is 1 or 2 less than a multiple of 20.
	 * This implies that, (n + 1) or (n + 2) need to be multiple of 20.
	 */
	public boolean less20(int n) {
		if ((n + 1) % 20 == 0 || (n + 2) % 20 == 0) {
			return true;
		}
		return false;
	}
	
	/*
	 * return true if the no is withing 2 of a multiple of 10.
	 * imples:
	 * - 2+ and 2- will do.
	 * 
	 */
	public boolean nearTen(int num) {
		  if (num % 10 == 0
				  || num % 10 == 1
				  || num % 10 == 2
				  || (num + 1) % 10 == 0
				  || (num + 2) % 10 == 0) {
		      return true;
		  }
		  return false;
		}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ModOperations m = new ModOperations();
		System.out.printf("15 : %b\n", m.multiple3_or_5(15));
		System.out.printf("14 : %b\n", m.multiple3_or_5(14));
		
		System.out.printf("11/11+1 : 11 : %b\n", m.special11(11));
		System.out.printf("11/11+1 : 12 : %b\n", m.special11(12));
		System.out.printf("11/11+1 : 13 : %b\n", m.special11(13));
		
		System.out.printf("3or5 but not both : 15 : %b\n", m.multiple3_5_not_both(15));
		System.out.printf("3or5 but not both : 5 : %b\n", m.multiple3_5_not_both(5));
		System.out.printf("3or5 but not both : 8 : %b\n", m.multiple3_5_not_both(8));


	}

}
