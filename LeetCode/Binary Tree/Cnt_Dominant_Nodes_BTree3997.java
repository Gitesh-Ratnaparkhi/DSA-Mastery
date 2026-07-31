// 3997. Count Dominant Nodes in a Binary Tree

// Link -> https://leetcode.com/problems/count-dominant-nodes-in-a-binary-tree/description/

// Approach -> Preorder Traversal
// The problem is solved using a recursive postorder traversal of the binary tree. For each node, the algorithm recursively computes the maximum value in its left and right subtrees. If the current node's value is greater than or equal to the maximum values of both subtrees, the node is counted as a dominant node. The function then returns the maximum value present in the current subtree, which is the maximum of the current node's value and the maxima of its left and right subtrees. After traversing the entire tree, the total count of dominant nodes is returned.

// Code ->
class Solution {

    int ans = 0;

    private int pre(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        if (root.left == null && root.right == null) {
            ans++;
            return root.val;
        }

        int leftMax = pre(root.left);
        int rightMax = pre(root.right);

        if (root.val >= leftMax && root.val >= rightMax) {
            ans++;
        }

        return Math.max(root.val, Math.max(leftMax, rightMax));
    }

    public int countDominantNodes(TreeNode root) {
        pre(root);
        return ans;
    }
}

// Time Complexity: O(N)
// Space Complexity: O(H)