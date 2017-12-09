package com.algorithms.datastructures.bst;

public class Traversal {
	
	public TreeNode findMax(TreeNode ptr) {
		TreeNode parent = ptr;
		while (ptr != null) {
			parent = ptr;
			ptr = ptr.right;
		}
		
		return parent;
	}
	
	/*
	 * complexity O(n) where the no of nodes is n
	 */
	public void inorderTreeWalk(TreeNode ptr) {
		if (ptr != null) {
			inorderTreeWalk(ptr.left);
			System.out.println(ptr.data);
			inorderTreeWalk(ptr.right);
		}
		
	}
	
	/*
	 * Using a stack to simulate recursion
	 */
	public void inorderTreeWalkIterative(TreeNode ptr) {
		
	}
	
	public TreeNode search(TreeNode root, int key) {
		if (root == null || root.data == key) {
			return root;
		} else if (key < root.data) {
			return search(root.left, key);
		} else {
			return search(root.right, key);
		}
	}

	public static void main(String[] args) {
		Operations o = new Operations();
		
		BST tree = new BST();
		
		o.insertNode(tree, new TreeNode(100));
		o.insertNode(tree, new TreeNode(150));
		o.insertNode(tree, new TreeNode(50));
		o.insertNode(tree, new TreeNode(30));
		o.insertNode(tree, new TreeNode(5));
		o.insertNode(tree, new TreeNode(200));
		
		Traversal t = new Traversal();
		t.inorderTreeWalk(tree.head);
		
		/*
		 * expected : false
		 */
		System.out.println(new Traversal().search(tree.head, 11) == null);
		
		/*
		 * FindMax : 200
		 */
		System.out.println("max element is " + new Traversal().findMax(tree.head).data);

	}

}
