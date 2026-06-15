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
        rightSideView(root,result,0,new HashSet<>());
        return result;
    }

    private void rightSideView(TreeNode root, List<Integer> result, int currentLevel,
    Set<Integer> traversedLevel) {
        if(root == null) {
            return;
        }

        if(!traversedLevel.contains(currentLevel)) {
            result.add(root.val);
            traversedLevel.add(currentLevel);
        }

       
        rightSideView(root.right,result,currentLevel+1,traversedLevel);
        rightSideView(root.left,result,currentLevel+1,traversedLevel);
        
    }
}
