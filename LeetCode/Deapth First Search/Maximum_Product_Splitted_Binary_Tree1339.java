// 1339. Maximum Product of Splitted Binary Tree


// Link -> https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/description/

// Approach -> Depth First Search
// 1. First, we calculate the total sum of all nodes in the binary tree using a helper function `sumNodes`.
// 2. Then, we perform a depth-first search (DFS) traversal of the tree using the `dfs` function.
// 3. During the DFS traversal, we calculate the sum of the subtree rooted at each node and compute the product of that sum and the sum of the remaining nodes (total - sum).
// 4. We keep track of the maximum product found during the traversal and return it modulo 10^9 + 7.


// Code ->
class Solution {

    long ans = 0;
    static final long MOD = 1000000007;

    private long sumNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return (long) root.val
                + sumNodes(root.left)
                + sumNodes(root.right);
    }

    private long dfs(TreeNode root, long total) {

        if (root == null) {
            return 0;
        }

        long l = dfs(root.left, total);
        long r = dfs(root.right, total);
        long sum = root.val + l + r;
        long p = sum * (total - sum);
        ans = Math.max(ans, p);
        return sum;
    }

    public int maxProduct(TreeNode root) {
        long total = sumNodes(root);
        dfs(root, total);
        return (int)(ans % MOD);
    }
}


// Time Complexity -> O(N)
// Space Complexity -> O(N)