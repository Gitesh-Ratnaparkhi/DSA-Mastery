// 865. Smallest Subtree with all the Deepest Nodes

// Link: https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/
// Similar Problem: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

// Approach: DFS
// First we find the depth of the tree using a pre-order traversal. Then we perform a DFS to find the smallest subtree that contains all the deepest nodes. If both left and right children are at the deepest level, we return the current node as it is the common ancestor. If only one child is at the deepest level, we return that child.

// Code -> 
class Solution {

    private int pre(TreeNode root) {
        if (root == null)
            return 0;

        int l = pre(root.left);
        int r = pre(root.right);

        return 1 + Math.max(l, r);
    }

    private TreeNode dfs(TreeNode root, int level, int depth) {
        if (root == null)
            return null;
        if (level == depth - 1)
            return root;
        TreeNode left = dfs(root.left, level + 1, depth);
        TreeNode right = dfs(root.right, level + 1, depth);
        if (left != null && right != null)
            return root;
        return left != null ? left : right;
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null)
            return null;

        int depth = pre(root);

        return dfs(root, 0, depth);
    }
}

// Time Complexity: O(n) where n is the number of nodes in the tree. We traverse each node twice, once for finding the depth and once for finding the subtree.
// Space Complexity: O(h) where h is the height of the tree. The space is used by the recursion stack during DFS traversal.
