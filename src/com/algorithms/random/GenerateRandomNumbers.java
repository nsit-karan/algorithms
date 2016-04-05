package com.algorithms.random;

import java.util.Random;

/**
 * Generate k unique random integers where each integer is between 0 and n-1
 * in random order.
 */
public class GenerateRandomNumbers {
	
	public void generate(int n, int k) {
		boolean[] numbers = new boolean[n];
		Random random = new Random();
		
		int count = 0;
		while(count < k) {
			int r_no = random.nextInt(n);
			if (numbers[r_no] == false) {
				numbers[r_no] = true;
				count++;
			}
		}
		logNumbers(numbers);
	}
	
	public void logNumbers(boolean[] numbers) {
		StringBuilder logBuilder = new StringBuilder("Random numbers : ");
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == true) {
				logBuilder.append(i).append(",");
			}
		}
		System.out.println(logBuilder.toString());
		
	}

	public static void main(String[] args) {
		GenerateRandomNumbers gr = new GenerateRandomNumbers();
		gr.generate(10, 5);
		gr.generate(10, 5);
		gr.generate(10, 5);
		gr.generate(10, 5);
	}

}
