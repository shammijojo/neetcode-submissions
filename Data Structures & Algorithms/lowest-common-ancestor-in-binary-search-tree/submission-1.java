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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;

        TreeNode min = (p.val > q.val)?q:p;
        TreeNode max = (p.val > q.val)?p:q;
        
         if(root.val < min.val && root.val < max.val) {
            return lowestCommonAncestor(root.right,p,q);
        } else if(root.val > min.val && root.val > max.val){
            return lowestCommonAncestor(root.left,p,q);
        }

        return root;
    }
}
