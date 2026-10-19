// 687. Longest Univalue Path

// Link -> https://leetcode.com/problems/longest-univalue-path/description/?envType=daily-question&envId=2026-07-26
// Difficulty -> Medium
// Approach -> Brute Force [Medium]
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

    int max = 0;
    private int solve(TreeNode root){
        if(root == null) return 0;
        int ll = solve(root.left);
        int rr = solve(root.right);
        int lc = 0;
        int rc = 0;
        if(root.left != null && root.val == root.left.val) lc = ll +  1;
        if(root.right != null && root.val == root.right.val) rc =rr  +  1;
        max = Math.max(max , lc + rc);
        return Math.max(lc, rc);
    }

    public int longestUnivaluePath(TreeNode root) {
        solve(root);
        return max;
    }
}

// Time Complexity -> O(N)
// Space Complexity -> O(N)