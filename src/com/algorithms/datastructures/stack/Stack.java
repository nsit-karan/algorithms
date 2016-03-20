package com.algorithms.datastructures.stack;

/**
 * stack rep for max 100 elements.
 * Use arraylist in case the size restrictions needs to be removed
 */
public class Stack {
	
	int S[] = new int[100];
	int top = -1;
	
	public boolean isEmpty() {
		return (top < 0) ? true : false;
	}
	
	public void push(int element) {
		top++;
		S[top] = element;
	}
	
	public int pop() {
		if (this.isEmpty()) {
			throw new RuntimeException("Stack empty : cannot pop");
		}
		return S[top--];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Stack s = new Stack();
		s.push(100);
		s.push(50);
		s.push(20);
		
		System.out.println("is empty : " + s.isEmpty());
		s.push(5);
		System.out.printf("Pushing and popping the same element : %d\n", s.pop());
		
		/*
		 * Empty out the stack
		 */
		while (!s.isEmpty()) {
			s.pop();
		}
		System.out.printf("is empty : %b", s.isEmpty());
	}

}
