// 655. Print Binary Tree
// Link -> https://leetcode.com/problems/print-binary-tree/
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
    int r;
    int co;

    private void solve(TreeNode root, List<List<String>> ans, int row, int col) {
        if (root == null) return;
        
        ans.get(row).set(col, Integer.toString(root.val));
        
        int offset = (int) (Math.pow(2, r - row - 1));
        solve(root.left, ans, row + 1, col - offset);
        solve(root.right, ans, row + 1, col + offset);
    }

    private int height(TreeNode root) {
        if (root == null) return -1;
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public List<List<String>> printTree(TreeNode root) {
        int h = height(root);
        r = h;
        
        int rows = h + 1;
        int c = (int) (Math.pow(2, h + 1) - 1);
        co = c;
        
        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            List<String> row = new ArrayList<>(Collections.nCopies(c, ""));
            ans.add(row);
        }

        int startCol = (c - 1) / 2;
        solve(root, ans, 0, startCol);
        
        return ans;
    }
}

// Time Complexity -> O(n)
// Space Complexity -> O(n)