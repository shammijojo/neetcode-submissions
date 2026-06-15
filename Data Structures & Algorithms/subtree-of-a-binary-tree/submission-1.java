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
       if(root == null) return false;

       return (checkForSubTree(root,subRoot)) ||  isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }


    private boolean checkForSubTree(TreeNode node, TreeNode subNode) {
        if(node == null && subNode == null) {
            return true;
        } else if(node == null || subNode == null) {
            return false;
        }

        return node.val == subNode.val &&
               checkForSubTree(node.left,subNode.left) &&
               checkForSubTree(node.right,subNode.right);


    }


}
