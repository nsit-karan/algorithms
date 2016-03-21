package com.algorithms.datastructures.linkedlist;


/**
 * Encapsulates:
 * - x (data)
 * - next
 * - prev (might be null based on whether single or doubly
 *         linked list)
 *         
 * No get/seters used here to keep the logic simple
 */
public class Node {
	public int x;
	public Node next;
	public Node prev;
	
	public Node(int x) {
		this.x = x;
	}
}
