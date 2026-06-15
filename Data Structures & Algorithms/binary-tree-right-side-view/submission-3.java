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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverseRightSide(result, root, 0);
        return result;
    }

    private void traverseRightSide(List<Integer> list, TreeNode node, int currentLevel) {
        if(node == null) {
            return;
        }

        if(list.size() == currentLevel) {
            list.add(node.val);
        }

        traverseRightSide(list,node.right,currentLevel+1);
        traverseRightSide(list,node.left,currentLevel+1);


    }



}
