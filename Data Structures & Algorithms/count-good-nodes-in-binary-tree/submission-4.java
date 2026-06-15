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
    private class GoodNode {
        int count = 0;
        GoodNode(){}
    }

    public int goodNodes(TreeNode root) {
        GoodNode g = new GoodNode();
        goodNodes(root,g,root.val);
        return g.count;
    }

    private void goodNodes(TreeNode node, GoodNode g, int max) {
        if(node == null) {
            return;
        }

        if(node.val >= max) {
            g.count++;
        }

        max = Math.max(max,node.val);
        goodNodes(node.left,g,max);
        goodNodes(node.right,g,max);
    }
}
