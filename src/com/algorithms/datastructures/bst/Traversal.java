package com.algorithms.datastructures.bst;

public class Traversal {
		
	/*
	 * complexity O(n) where the no of nodes is n
	 */
	public void inorderTreeWalk(TreeNode ptr) {
		if (ptr != null) {
			inorderTreeWalk(ptr.left);
			System.out.println(ptr.x);
			inorderTreeWalk(ptr.right);
		}
		
	}
	
	/*
	 * Using a stack to simulate recursion
	 */
	public void inorderTreeWalkIterative(TreeNode ptr) {
		
	}
	
	public TreeNode search(TreeNode root, int key) {
		if (root == null || root.x == key) {
			return root;
		} else if (key < root.x) {
			return search(root.left, key);
		} else {
			return search(root.right, key);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Operations o = new Operations();
		
		BinarySearchTree tree = new BinarySearchTree();
		
		o.insertNode(tree, new TreeNode(100));
		o.insertNode(tree, new TreeNode(150));
		o.insertNode(tree, new TreeNode(50));
		o.insertNode(tree, new TreeNode(30));
		
		Traversal t = new Traversal();
		t.inorderTreeWalk(tree.head);

	}

}
