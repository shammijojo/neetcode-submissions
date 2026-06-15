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
        Set<Integer> traversedLevels = new HashSet<>();
        traverseRightSide(result, root, 1, new HashSet<>());
        return result;
    }

    private void traverseRightSide(List<Integer> list, TreeNode node, int currentLevel,
    Set<Integer> traversedLevels) {
        if(node == null) {
            return;
        }

        if(!traversedLevels.contains(currentLevel)) {
            list.add(node.val);
            traversedLevels.add(currentLevel);
        }

        traverseRightSide(list,node.right,currentLevel+1,traversedLevels);
        traverseRightSide(list,node.left,currentLevel+1,traversedLevels);


    }



}
