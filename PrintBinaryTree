
//Java program to print top view of Binary tree
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import com.k2view.quiz.PrintBinaryTree.Tree.TreeNode;



public class PrintBinaryTree {
	
	//Class for a Binary Tree
	public static class Tree {
		//Class for a tree node
		public static class TreeNode {
			// Members
			int key;
			TreeNode left, right;

			// Constructor
			public TreeNode(int key)
			{
				this.key = key;
				left = right = null;
			}
		}
		
		TreeNode root;

		// Constructors
		public Tree() { 
			root = null; 
		}
		public Tree(TreeNode n) { 
			root = n; 
		}

		// This method prints nodes in top view of binary tree
		public void printTopView()
		{
			// base case
			if (root == null) {
				return;  
			}

			// Creates an empty hashset
			HashSet<TreeNode> set = new HashSet<>();

			// Create a queue and add root to it
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			queue.add(root); // Horizontal distance of root is 0

			// Standard BFS or level order traversal loop
			while (!queue.isEmpty())
			{
				// Remove the front item and get its details
				TreeNode n = queue.remove();


				// If this is the first node at its horizontal distance,
				// then this node is in top view
				if (!set.contains(n))
				{
					set.add(n);
					System.out.print(n.key + " ");
				}

				// Enqueue left and right children of current node
				if (n.left != null)
					queue.add(n.left);
				if (n.right != null)
					queue.add(n.right);
			}
		}


	}

	public static void main(String[] args)
	{
		/* Create following Binary Tree
      1
    /  \
   2    3
    \
     4
      \
       5
        \
         6*/
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.left.right.right = new TreeNode(5);
		root.left.right.right.right = new TreeNode(6);
		Tree t = new Tree(root);
		System.out.println("Following are nodes in top view of Binary Tree");
		t.printTopView();
	}

}
