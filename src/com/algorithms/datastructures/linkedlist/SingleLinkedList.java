package com.algorithms.datastructures.linkedlist;

public class SingleLinkedList {
	
	Node head;
	Node tail;
	
	/*
	 * Inserts an element at the head of the list
	 * 
	 * Special case:
	 * - initiliaze tail to 'u' if tail was uninitialized
	 */
	public void insert(int x) {
		Node new_node = new Node(x);
		new_node.next = head;
		head = new_node;
		
		if (tail == null) {
			tail = new_node;
		}
	}
	
	/*
	 * Delete the head and update head
	 * Boundary conditions:
	 * - list empty
	 * - last element deleted:
	 *    - head = head.next takes care of making head null
	 *    - tail needs to be set to null if head becomes null
	 */
	public int delete() {
		if (head == null) {
			throw new RuntimeException("Empty list");
		}
		
		int x = head.x;
		head = head.next;
		
		if (head == null) {
			tail = null;
		}
		return x;
	}
	
	public void displayList(String loggerString) {
		StringBuilder sb = new StringBuilder(loggerString).append(" : ");
		Node iter = head;
		while (iter != null) {
			sb.append(iter.x).append(" -> ");
			iter = iter.next;
		}
		
		/*
		 * strip off the trailing extra '->'
		 */
		sb.delete(sb.toString().length() - 4, sb.toString().length());
		System.out.println(sb.toString());
	}

	public static void main(String[] args) {
		SingleLinkedList sl = new SingleLinkedList();
		sl.insert(1);
		sl.insert(2);
		sl.insert(3);
		
		sl.displayList("sl");		
		System.out.printf("Element deleted : %d\n", sl.delete());
		sl.displayList("sl");

	}

}
