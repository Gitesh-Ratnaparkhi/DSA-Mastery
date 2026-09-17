// 2196. Create Binary Tree From Descriptions
// Link: https://leetcode.com/problems/create-binary-tree-from-descriptions/
// Approach: HashMap + Set
// Code:
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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, int[]> mp = new HashMap<>();
        Set<Integer> child = new HashSet<>();

        for(int i = 0; i < descriptions.length; i++) {
            int parent = descriptions[i][0];
            int ch = descriptions[i][1];
            int lorr = descriptions[i][2];

            child.add(ch);

            if(!mp.containsKey(parent)) {
                int[] arr = new int[2];
                if(lorr == 1) arr[0] = ch;
                else arr[1] = ch;
                mp.put(parent, arr);
            }
            else {
                int[] arr = mp.get(parent);
                if(lorr == 1) arr[0] = ch;
                else arr[1] = ch;
            }
        }

        int rootVal = 0;
        for(int parent : mp.keySet()) {
            if(!child.contains(parent)) {
                rootVal = parent;
                break;
            }
        }

        Map<Integer, TreeNode> nodes = new HashMap<>();
        for(int val : mp.keySet()) {
            nodes.putIfAbsent(val, new TreeNode(val));
            int[] arr = mp.get(val);
            if(arr[0] != 0) {
                nodes.putIfAbsent(arr[0], new TreeNode(arr[0]));
                nodes.get(val).left = nodes.get(arr[0]);
            }
            if(arr[1] != 0) {
                nodes.putIfAbsent(arr[1], new TreeNode(arr[1]));
                nodes.get(val).right = nodes.get(arr[1]);
            }
        }
        return nodes.get(rootVal);
    }
}


// Time Complexity: O(n), where n is the number of descriptions. We iterate through the descriptions to build the map and set, and then we iterate through the map to create the tree nodes.
// Space Complexity: O(n), where n is the number of unique nodes in the tree.