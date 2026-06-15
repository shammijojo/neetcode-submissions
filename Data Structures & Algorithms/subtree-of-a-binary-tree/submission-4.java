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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        //if(subRoot == null) return true;
        if(root == null) return false;
        return checkForSubTree(root, subRoot) ||
        isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean checkForSubTree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) {
            return true;
        } else if(root == null || subRoot == null) {
            return false;
        }

        return root.val == subRoot.val && checkForSubTree(root.left, subRoot.left)
        && checkForSubTree(root.right, subRoot.right);
    }
}
