// 958. Check Completeness of a Binary Tree
// Link -> https://leetcode.com/problems/check-completeness-of-a-binary-tree/
// Level -> Medium
// Approach -> Level Order Traversal [BFS]
// Code ->
class Solution {
    
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> q = new LinkedList<>();         
        q.offer(root);
        boolean seenNull = false;
        while (!q.isEmpty()) {
            int s = q.size();
            int i = 0; 
            while (i < s) {
                TreeNode temp = q.poll();

                if (temp.left != null) {
                    if (seenNull) return false;
                    q.offer(temp.left);
                } else seenNull = true;

                if (temp.right != null) {
                    if (seenNull) return false;
                    q.offer(temp.right);
                }else seenNull = true;
            
                i++;
            }
        }
        return true;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)