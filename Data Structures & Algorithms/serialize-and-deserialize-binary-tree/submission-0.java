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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        preorder(root,list);
        return Arrays.toString(list.toArray());
    }

    private void preorder(TreeNode node, List<String> list) {
        if(node == null) {
            list.add("null");
            return;
        }

        list.add(String.valueOf(node.val));
        preorder(node.left,list);
        preorder(node.right, list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String str = data.substring(1,data.length()-1);
        List<String> list = Arrays.asList(str.split(","));
        //System.out.println(list);


        Queue<String> queue = new LinkedList<>();
        for(String s : list) {
            queue.add(s.trim());
        }

        return constructTree(queue);
    }

    private TreeNode constructTree(Queue<String> queue) {
        String value = queue.poll();
        //System.out.println(queue);
        if(value.equals("null")) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(value));
        node.left = constructTree(queue);
        node.right = constructTree(queue);

        return node;
    }



}
