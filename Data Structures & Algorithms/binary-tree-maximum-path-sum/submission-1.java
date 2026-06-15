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
    public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        getMaxPathSum(root,max);
        return max[0];
    }
       


    private int getMaxPathSum(TreeNode root, int[] max) {
        if(root == null) {
            return 0;
        }

        int left = getMaxPathSum(root.left,max);
        int right = getMaxPathSum(root.right,max);

        max[0] =  Math.max(left+root.val,
            Math.max(right+root.val,
            Math.max(right+left+root.val,
            Math.max(root.val,max[0]))));

        return Math.max(root.val,Math.max(left,right)+root.val);    

        
    }

}
