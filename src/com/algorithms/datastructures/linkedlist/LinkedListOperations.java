package com.algorithms.datastructures.linkedlist;

public class LinkedListOperations {


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
	public void reverse(SingleLinkedList list) {
		
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
	
	/*
	 * TODO : untested. Don't have the doublyLinkedList code complete
	 */
	public boolean isPalindrome(DoublyLinkedList dlist) {
		
		Node p = dlist.head;
		Node q = dlist.tail;
		
		boolean is_palin = true;
		while (p != q) {
			if (p.x != q.x) {
				is_palin = false;
				break;
			} else {
				p = p.next;
				q = q.prev;
			}
		}
		return is_palin;
		
	}
	
	public void initializeList(SingleLinkedList list) {
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
		SingleLinkedList list = new SingleLinkedList();
		LinkedListOperations listOperations = new LinkedListOperations();
		listOperations.initializeList(list);
		list.displayList("initial list");
		listOperations.reverse(list);
		list.displayList("reversed list");
	}

}
