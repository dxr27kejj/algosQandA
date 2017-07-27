/** Given a binary tree, convert it into a binary search tree 
 * which has the exaclty same shape as the original binary tree
 */
 // IXL
import java.util.Collections;
import java.util.LinkedList;

public class Solution {
	class TreeNode{
		TreeNode left;
		TreeNode right;
		int val;
		public TreeNode(int data) {
			this.val = data;
		}
	}
	static TreeNode btToBst(TreeNode root) {
		if (root == null) return null;
		LinkedList<Integer> list = new LinkedList<>();
		fillTheList(list, root);
		Collections.sort(list);
		changeValues(list, root);
		return root;
	}
	static void fillTheList(LinkedList<Integer> list, TreeNode root) {
		if (root.left != null) fillTheList(list, root.left);
		list.add(root.val);
		if (root.right != null) fillTheList(list, root.right);
	}
	static void changeValues(LinkedList<Integer> list, TreeNode root) {
		if (root.left != null) changeValues(list, root.left);
		root.val = list.removeFirst();
		if (root.right != null) changeValues(list, root.right);
	}
	static void printTheTree(TreeNode root) {
		System.out.print("root is: " + root.val);
		if (root.left != null) System.out.print(" left child is: " + root.left.val);
		if (root.right != null) System.out.print(" right child is: " + root.right.val);
		System.out.println();
		if (root.left != null) printTheTree(root.left);
		if (root.right != null) printTheTree(root.right);
	}
	public static void main(String[] args) {
		//example 1
	    TreeNode a = new Solution().new TreeNode(10);
	    TreeNode b = new Solution().new TreeNode(2);
	    TreeNode c = new Solution().new TreeNode(7);
	    TreeNode d = new Solution().new TreeNode(8);
	    TreeNode e = new Solution().new TreeNode(4);
	    a.left = b;
	    a.right = c;
	    b.left = d;
	    b.right = e;
	    printTheTree(a);
	    System.out.println();
	    btToBst(a);
	    printTheTree(a);
	    System.out.println();
	    //example 2
	    a = new Solution().new TreeNode(10);
	    b = new Solution().new TreeNode(30);
	    c = new Solution().new TreeNode(15);
	    d = new Solution().new TreeNode(20);
	    e = new Solution().new TreeNode(5);
	    e.val = 5;
	    a.left = b;
	    a.right = c;
	    b.left = d;
	    c.right = e;
	    printTheTree(a);
	    System.out.println();
	    btToBst(a);
	    printTheTree(a);
	}
} 
