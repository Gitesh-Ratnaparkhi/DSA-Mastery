// 2265. Count Nodes Equal to Average of Subtree
// Link -> https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/
// Level -> Medium
// Approach -> DFS
// Code
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
    private int[] helper(TreeNode root){
        if(root == null) return new int[] {0, 0};

        int left[] = helper(root.left);
        int right[] = helper(root.right);
        int cnt = left[1] + right[1] + 1;
        int sum = Math.abs(root.val + left[0] + right[0]);
        int temp[] = {sum, cnt};
        if(root.val == Math.abs(sum/cnt)) ans++;
        return temp;
    }

    public int averageOfSubtree(TreeNode root) {
        helper(root);
        return ans;
    }
}
// Time Complexity -> O(n)
// Space Complexity -> O(h) where h is the height of the tree