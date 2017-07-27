/** Given a node target and the root of a tree, 
 * please find the closest leaf to target in the tree.
 */

// Databricks
import java.util.ArrayList;
import java.util.List;

public class Solution {
	static int ans;
	class TreeNode{
		TreeNode left;
		TreeNode right;
		char name;
		public TreeNode(char c) {
			this.name = c;
		}
	}
	static int getCloseNode(TreeNode root, TreeNode target) {
		ans = Integer.MAX_VALUE;
		mainMethod(root, target, new ArrayList<TreeNode>());
		System.out.println("Closest distance from a leaf to '" + target.name + "' is " + ans);
		return ans;
	}
	static void mainMethod(TreeNode root, TreeNode target, List<TreeNode> path) {
		
		if (root == null) return;
		if (root.name != target.name) {
			path.add(root);
			mainMethod(root.left, target, path);
			mainMethod(root.right, target, path);
			path.remove(path.size()-1);
		} else {
			ans = getCloseBelow(root);
			int len = path.size();
			for (int i = 0; i < len; i++) {
				int temp = getCloseBelow(path.get(i));
				ans = Math.min(ans, (len - i) + temp);
			}
		}
		
	}
	static void printThePath(List<TreeNode> path) {
		for (TreeNode node: path) {
			System.out.print(node.name + "->");
		}
		System.out.println();
	}
	static int getCloseBelow(TreeNode root) {
		if (root == null) return Integer.MAX_VALUE;
		if (root.left == null && root.right == null) return 0;
		return 1 + Math.min(getCloseBelow(root.left), getCloseBelow(root.right));
	}
	public static void main(String[] args) {
	    TreeNode a = new Solution().new TreeNode('A');
	    TreeNode b = new Solution().new TreeNode('B');
	    TreeNode c = new Solution().new TreeNode('C');
	    TreeNode e = new Solution().new TreeNode('E');
	    TreeNode f = new Solution().new TreeNode('F');
	    TreeNode g = new Solution().new TreeNode('G');
	    TreeNode h = new Solution().new TreeNode('H');
	    TreeNode i = new Solution().new TreeNode('I');
	    TreeNode j = new Solution().new TreeNode('J');
	    TreeNode k = new Solution().new TreeNode('K');
	    
	    a.left = b;
	    a.right = c;
	    
	    c.left = e;
	    c.right = f;
	    
	    e.left = g;
	    f.right = h;
	    
	    g.left = i;
	    g.right = j;
	    
	    h.left = k;
	    getCloseNode(a, a);
	    getCloseNode(a, b);
	    getCloseNode(a, c);
	    getCloseNode(a, e);
	    getCloseNode(a, f);
	    getCloseNode(a, g);
	    getCloseNode(a, h);
	    getCloseNode(a, i);
	    getCloseNode(a, j);
	    getCloseNode(a, k);
	}
} 
