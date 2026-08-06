// 968. Binary Tree Cameras


// Link -> https://leetcode.com/problems/binary-tree-cameras/description/

// Approach -> DFS + Postorder Traversal
// We can solve this problem using a depth-first search (DFS) approach with postorder traversal. The idea is to traverse the tree and determine the state of each node based on its children. We can define three states for each node:
// 0 -> The node is not covered by a camera and does not have a camera.
// 1 -> The node is covered by a camera but does not have a camera itself.
// 2 -> The node has a camera.

// Code ->
class Solution {
    int ans = 0;
    private int post(TreeNode root){
        if(root == null ) return 2;
        int val = post(root.left);
        int val2 = post(root.right);
        if(val == 0 || val2 == 0){
            ans++;
            return 1;
        }
        if(val == 1 || val2 == 1)return 2;
        
        return 0;
    }
    public int minCameraCover(TreeNode root) {
        if(post(root) == 0)ans++;
        return ans;
    }
}


// Time Complexity -> O(n) where n is the number of nodes in the tree
// Space Complexity -> O(h) where h is the height of the tree for the recursion stack