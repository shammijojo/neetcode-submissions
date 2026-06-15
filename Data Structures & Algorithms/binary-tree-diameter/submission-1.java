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
    public static class Diameter {
        int d;
        Diameter() {
            this.d = 0;
        }
    }
    public int diameterOfBinaryTree(TreeNode root) {
        Diameter diameter = new Diameter();
        findDiameter(diameter,root);
        return diameter.d;
    }

    private int findDiameter(Diameter diameter, TreeNode root) {
        if(root == null) {
            return 0;
        } 
        // else if(root.left == null && root.right == null) {
        //     return 0;
        // }

        int l = findDiameter(diameter, root.left);
        int r = findDiameter(diameter, root.right);

        //System.out.println(root.val+" "+l+" "+r);
        diameter.d = Math.max(diameter.d,l+r);

        return Math.max(l,r)+1;
    }
}
