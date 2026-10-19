// 2385. Amount of Time for Binary Tree to Be Infected
// Link -> https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/
// Level -> Medium
// Approach -> DFS
// Code ->
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans = 0;
    private int solve(TreeNode root, int start){
        if(root == null) return 0;
        int lf = solve(root.left, start);
        int rf = solve(root.right, start);

        if (root.val == start) {
            ans = Math.max(ans, Math.max(lf > 0 ? lf : 0, rf > 0 ? rf : 0));
            return -1;
        }
        if (lf < 0) {
            int st = -lf;
            ans = Math.max(ans, st + (rf > 0 ? rf : 0));
            return lf - 1;
        }
        if (rf < 0) {
            int st = -rf;
            ans = Math.max(ans, st + (lf > 0 ? lf : 0));
            return rf - 1;
        }
        return Math.max(lf, rf)+1;
    }
    public int amountOfTime(TreeNode root, int start) {
        if(root.left == null && root.right == null) return 0;
        solve(root, start);
        return ans;
    }
}
// Time Complexity -> O(N)
// Space Complexity -> O(N)