package com.algorithms.strings;

/*
 * TODO : move out swap to Utils
 */
public class StringOperations {
	
	public char[] reverseString(char[] s) {
		int i = 0;
		int j = s.length - 1;
		while (i < j) {
			char temp = s[i];
			s[i] = s[j];
			s[j] = temp;
			i++;
			j--;
		}
		return s;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = new String("abcd");
		StringOperations so = new StringOperations();
		
		char[] rev_string = so.reverseString(s.toCharArray());
		for (char c : rev_string) {
			System.out.println(c);
		}
	}

}
