package com.algorithms.datastructures.stack;

import java.util.Stack;

import com.algorithms.misc.StringUtils;


/*
 * Use 2 stacks S1 and S2:
 * - insertion always happens in S1
 * - deletion always from S2
 *   - in case S2 has some element, pop from S2
 *   - in case S2 is empty, pop elements from S1 and push to S2 so that the first element of S1
 *     becomes the last or top element of S2 which is the element which was added first and needs
 *     to dequed. Hence, S2 is from 0 to n-1 where S2[0] was the element inserted last and S2.top
 *     is the element which was pushed first.
 *     
 *     Hence the order of elements based on the when they were inserted is:
 *     S2[top], S2[top-1]....S2[0] then S1[0], S1[1]....S1[top]
 *     
 *     Hence, the elements are dequed based on which element was inserted first
 */
public class QueueUsingStacks {
	
	Stack<Integer> S1 = new Stack<Integer>();
	Stack<Integer> S2 = new Stack<Integer>();
	
	public void push(int x) {
		S1.push(x);
	}
	
	public int pop() {
		if (S2.isEmpty()) {
			copyS1toS2();
		}
		return S2.pop();
	}

	/*
	 * Pop elements from S1
	 * and push to S2
	 */
	private void copyS1toS2() {
		while (!S1.isEmpty()) {
			S2.push(S1.pop());
		}
	}

	public static void main(String[] args) {
		QueueUsingStacks qs = new QueueUsingStacks();
		qs.push(1);
		qs.push(2);
		qs.push(3);
		qs.push(4);
		
		StringUtils.displayArray(qs.S1, "S1 : ");
		System.out.printf("Element popped : %d\n", qs.pop());
		StringUtils.displayArray(qs.S1, "S1 : ");
		StringUtils.displayArray(qs.S2, "S2 : ");
	}

}
