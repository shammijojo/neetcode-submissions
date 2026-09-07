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
    public int rob(TreeNode root) {
        int[] x = func(root);
        return Math.max(x[0],x[1]);
    }

    private int[] func(TreeNode node) {
        if(node == null) {
            return new int[]{0,0};
        }

        int[] l = func(node.left);
        int[] r = func(node.right);

        //without root
        int maxWithoutRoot = Math.max(l[0],l[1])+Math.max(r[0],r[1]);

        //with root
        int maxWithRoot = r[0]+l[0]+node.val;

        return new int[]{maxWithoutRoot,maxWithRoot};

    }
}