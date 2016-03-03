/*
 * questions source : coding bat
 */

package com.algorithms.misc;

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
