// 1530. Number of Good Leaf Nodes Pairs


// Link -> https://leetcode.com/problems/number-of-good-leaf-nodes-pairs/description/?envType=problem-list-v2&envId=depth-first-search

// Approach: First Approach [Depth First Search]

// Traverse the binary tree using depth-first search (DFS) and for each leaf node, we will keep track of its distance from the root. We will then check all pairs of leaf nodes to see if their combined distance is less than or equal to the given distance. If it is, we will increment our answer. We will return the count of good leaf node pairs at the end.


// Code ->
class Solution {
    int ans = 0;
    private List<Integer> dfs(TreeNode root, int distance) {
        if (root == null) {
            return new ArrayList<>();
        }
        if (root.left == null && root.right == null) {
            List<Integer> list = new ArrayList<>();
            list.add(0);
            return list;
        }
        List<Integer> left = dfs(root.left, distance);
        List<Integer> right = dfs(root.right, distance);
        for (int l : left) {
            for (int r : right) {
                if (l + r + 2 <= distance) {
                    ans++;
                }
            }
        }
        List<Integer> result = new ArrayList<>();

        for (int d : left) {
            if (d + 1 < distance) {
                result.add(d + 1);
            }
        }

        for (int d : right) {
            if (d + 1 < distance) {
                result.add(d + 1);
            }
        }

        return result;
    }

    public int countPairs(TreeNode root, int distance) {
        dfs(root, distance);
        return ans;
    }
}

// Time Complexity: O(n²)
// Space Complexity: O(n)