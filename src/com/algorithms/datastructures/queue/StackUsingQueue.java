package com.algorithms.datastructures.queue;

import java.util.Queue;

import com.google.common.collect.Queues;

/*
 * Stacks using 2 queues:
 * - insertion is O(1)
 * - deletion is O(n)
 * 
 * - For insertion, insert to the queue which already has elements.
 * - For deletion, transfer all the elements to the queue which is empty.
 *   The last element transferred is the last element which was added.
 *   So, return this element since stack needs to return the last element
 *   which was pushed
 *   Now, the role of Q1 and Q2 is reversed since Q2 has the elements and Q1
 *   is empty
 *   
 *   TODO : provide alternate approach where insertion is O(n) and deletion is O(1)
 */
public class StackUsingQueue {
	
	Queue<Integer> Q1 = Queues.newArrayDeque();
	Queue<Integer> Q2 = Queues.newArrayDeque();

	
	public void push(int x) {
		if (!Q2.isEmpty()) {
			Q2.add(x);
		} else {
			Q1.add(x);
		}
	}
	
	public int pop() {
		if (Q1.isEmpty() && Q2.isEmpty()) {
			throw new RuntimeException("stack empty : no elements to pop");
		}
		Queue<Integer> filledQueue = Q1.isEmpty() ? Q2 : Q1;
		Queue<Integer> emptyQueue = Q1.isEmpty() ? Q1 : Q2;
		
		/*
		 * Go on dequeuing elements from the filledQueue except
		 * for the last element.
		 * 
		 * The last element left in the filledQueue is the one
		 * which was inserted last and is the one to be popped
		 */
		while (filledQueue.size() > 1) {
			emptyQueue.add(filledQueue.remove());
		}
		return filledQueue.remove();
	}
	
	private void displayQueue(Queue<Integer> q, String loggerString) {
		StringBuilder sb = new StringBuilder(loggerString).append(':');
		for (Integer i : q) {
			sb.append(i).append(", ");
		}
		System.out.println(sb.toString());
	}

	/**
	 * O/P:
	 * Q1 :1, 2, 3, 4, 
	 * Element popped : 4
	 * Q1:
	 * Q2:1, 2, 3, 
	 */
	public static void main(String[] args) {
		StackUsingQueue sq = new StackUsingQueue();
		sq.push(1);
		sq.push(2);
		sq.push(3);
		sq.push(4);
		
		sq.displayQueue(sq.Q1, "Q1 ");
		System.out.printf("Element popped : %d\n", sq.pop());

		sq.displayQueue(sq.Q1, "Q1");
		sq.displayQueue(sq.Q2, "Q2");
	}

}
