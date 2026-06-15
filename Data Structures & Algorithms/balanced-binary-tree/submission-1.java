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
    public boolean isBalanced(TreeNode root) {
        int[] balanced = new int[1];
        isBalanced(root,balanced);
        return balanced[0] == 0;
    }

    private int isBalanced(TreeNode root, int[] balanced) {
        if(root == null) {
            return 0;
        }

        if(balanced[0] == 1) return 0;

        int l = isBalanced(root.left,balanced);
        int r = isBalanced(root.right,balanced);

        if(Math.abs(l-r) > 1) {
            balanced[0] = 1;
        }

        return Math.max(l,r)+1;
    }
}
