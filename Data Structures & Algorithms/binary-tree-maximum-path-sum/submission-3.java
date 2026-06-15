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
        findMax(root,max);
        return max[0];
    }

    private int findMax(TreeNode root, int[] max) {
        if(root == null) {
            return 0;
        }

        int l = findMax(root.left,max);
        int r = findMax(root.right, max);
        
        max[0] = Math.max(max[0],Math.max(l+root.val,
                    Math.max(r+root.val,Math.max(l+r+root.val,root.val))));

        return Math.max(l+root.val,Math.max(r+root.val,root.val));            



    }
}
