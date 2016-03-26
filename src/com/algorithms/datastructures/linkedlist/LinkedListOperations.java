package com.algorithms.datastructures.linkedlist;

public class LinkedListOperations {

	SingleLinkedList list;
	
	public LinkedListOperations(SingleLinkedList list) {
		this.list = list;
	}

	/**
	 * Brief:
	 * keep track of the list using 2 pointers(or references :)):
	 * p and q :
	 * 
	 * |a|-->|b|-->|c|-->|d|
	 * 
	 * p points to a
	 * q points to b.
	 * 
	 * At each step, 2 operations are done:
	 * - b is made to point to a(i.e, b.next = a)
	 * - a and b are both advanced by 1
	 * 
	 * So, in short, q is made to point to p
	 *  
	 */
	public void reverse() {
		
		Node p = list.head;
		Node q = p.next;
		
		list.head.next = null;
		list.tail = p;
		
		while (q != null) {
			Node t = q;
			q = q.next;
			t.next = p;
			p = t;
		}
		
		list.head = p;
		
	}
	

	public void initializeList() {
		list.insert(10);
		list.insert(20);
		list.insert(30);
		list.insert(40);
		list.insert(50);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedListOperations listOperations = new LinkedListOperations(new SingleLinkedList());
		listOperations.initializeList();
		listOperations.list.displayList("initial list");
		listOperations.reverse();
		listOperations.list.displayList("reversed list");
	}

}
