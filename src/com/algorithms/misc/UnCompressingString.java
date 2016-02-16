package com.algorithms.misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

/*
 * Iterate over the char array:
 * - in case a char is found
 *    - iterate over the array till the next char is found and go on appending
 *      to the num_string
 *    - finally, update the map with this char and the num_string
 *    
 * Optimize:
 *    - use a normal array instead of map for querying the value
 *    - calculate and store the incremental result in the array/tree
 *      - then search for the smallest value greater than k
 *    - use BigInteger instead of integer to take care of large I/P
 */
public class UnCompressingString {
	
	private Map<Character, Integer> charMap = new TreeMap<>();

	public void processString(String s) {

		char[] characters = s.toCharArray();
		
		StringBuffer num_buffer = new StringBuffer();
		
		int i = 0;
		int j = 0;
		while (i < s.length()) {
			Character current_char = characters[i];
			boolean isAlpha = Character.isAlphabetic(current_char);
			
			if (isAlpha) {
				j = i + 1;
				
				/*
				 * Go on incrementing j till the next alphabet is found
				 *   - along with incrementing, update num_buffer
				 * At that point, update the map with characters[i] with value as num_buffer 
				 */
				while (j < s.length()) {
					
					boolean isDigit = Character.isDigit(characters[j]);
					if (isDigit) {
						num_buffer.append(characters[j]);
						j++;
					} else {
						break;
					}
				}
								
				updateCharMap(current_char, Integer.parseInt(num_buffer.toString()));
				num_buffer.setLength(0);
				i = j;
			}
		}
	}
	
	public void updateCharMap(Character c, Integer new_value) {
		Integer old_value = charMap.get(c);
		if (old_value == null) {
			charMap.put(c, new_value);
		} else {
			charMap.put(c, old_value + new_value);
		}
	}
	
	public Character findKElement(Integer k) {
		Integer sum = k;
		for (Map.Entry<Character, Integer> entry : this.charMap.entrySet()) {
			Character c = entry.getKey();
			Integer value = entry.getValue();
			
			sum = sum - value;
			if (sum <= 0) {
				return c;
			}
		}
		return null;
	}

	/*
	 * I/P:
	 * 
	 * - string in compressed format. For instance : a2b00004c204d00005
	 * - no of queries
	 * - each next line is a query(say k) on the uncompressed sorted string where the element
	 *   at position k needs to be returned
	 */
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = br.readLine();
		String noOfQueries = br.readLine();
		
		UnCompressingString us = new UnCompressingString();
		us.processString(inputStr);
		us.findKElement(6);
		
		int N = Integer.parseInt(noOfQueries);
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			if (n <= 0) {
				System.out.println(-1);
			} else {
				Character kth_element = us.findKElement(n);
				if (kth_element == null) {
					System.out.println(-1);
				} else {
					System.out.println(kth_element);
				}
			}
		}		
	}

}


