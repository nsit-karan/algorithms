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
public class ListNode {
	public int x;
	public ListNode next;
	public ListNode prev;
	
	public ListNode(int x) {
		this.x = x;
	}

	public ListNode() {
	}	
	
}
