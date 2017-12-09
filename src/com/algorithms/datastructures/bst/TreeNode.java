package com.algorithms.datastructures.bst;

public class TreeNode {
	
	int data;
	TreeNode left;
	TreeNode right;
	
	/*
	 * parent might/might-not be null based on the implementation
	 */
	TreeNode parent;

	public TreeNode(int data) {
		this.data = data;
	}
	
}
