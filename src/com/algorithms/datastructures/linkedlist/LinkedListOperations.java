package com.algorithms.datastructures.linkedlist;

public class LinkedListOperations {

	SingleLinkedList list;
	
	public LinkedListOperations(SingleLinkedList list) {
		this.list = list;
	}


	public void reverse() {
		/*
		 * If only 1 element exists, no-op
		 */
		if (list.size() == 1) {
			return;
		}
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
	}

}
