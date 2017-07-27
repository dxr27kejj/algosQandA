/** Given an array of integers and a target number, determine if an arithmetic expression
 * using these integers can be evaluated to the target number, 
 * you are allowed to use '+', '-', '*', '/'
 */
 // yelp
 
import java.util.ArrayList;
import java.util.List;

public class Solution {
	static List<String> addOperators(String nums, int target){
		List<String> ans = new ArrayList<>();
		if (nums == null || nums.length() == 0) return ans;
		helper(nums, target, ans, "", 0, 0, 0);
		System.out.println(ans);
		return ans;
	}
	
	static void helper(String nums, int target, List<String> ans, String path, int pos, long eval, long multed){
		if (pos == nums.length()) {
			if (eval == target) {
				ans.add(path);
				return;
			}
		}
		for (int i = pos; i < nums.length(); i++) {
			
			// discard any number starts with '0', keep individual 0
			if (i != pos && nums.charAt(pos) == '0') break;
			
			long cur = Long.parseLong(nums.substring(pos, i+1));
			
			// starts from 0+cur
			if (pos == 0) helper(nums, target, ans, path+cur, i+1, cur, cur);
			else {
				helper(nums, target, ans, path+"+"+cur, i+1, eval+cur, cur);
				helper(nums, target, ans, path+"-"+cur, i+1, eval-cur, -cur);
				helper(nums, target, ans, path+"*"+cur, i+1, eval-multed+multed*cur, multed*cur);
                if (cur != 0) helper(nums, target, ans, path+"/"+cur, i+1, eval-multed+multed/cur, multed/cur);
			}
		}
	}
	
	public static void main(String[] args) {
		addOperators("123", 6);
		addOperators("232", 8);
		addOperators("105", 5);
		addOperators("00", 0);
		addOperators("3456237490", 9191);
	}
} 
