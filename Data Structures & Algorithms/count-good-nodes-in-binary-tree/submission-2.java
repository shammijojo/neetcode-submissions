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
    public int goodNodes(TreeNode root) {
        return findGoodNodes(root,-101);
    }

    private int findGoodNodes(TreeNode node, int max) {
        if(node == null) {
            return 0;
        }

        int left = findGoodNodes(node.left, Math.max(node.val,max));
        int right = findGoodNodes(node.right, Math.max(node.val, max));

        return (node.val >= max)?left+right+1:left+right;
    }





}
