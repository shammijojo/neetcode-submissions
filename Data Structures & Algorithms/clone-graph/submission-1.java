/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Map<Node,Node> map = new HashMap<>();
        Node copyNode = new Node(node.val,new ArrayList<>());
        map.put(node,copyNode);
        dfs(node,map);
        return map.get(node);
    }

    private void dfs(Node node, Map<Node,Node> map) {
        List<Node> neighbors = node.neighbors;
        for(int i = 0; i < neighbors.size(); i++) {
            Node neighbor = neighbors.get(i);
            Node copyNode;
            if(!map.containsKey(neighbor)) {
                copyNode = new Node(neighbor.val,new ArrayList<>());
                map.put(neighbor,copyNode);
                map.get(node).neighbors.add(copyNode);
                dfs(neighbor,map);
            } else {
                copyNode = map.get(neighbor);
                map.get(node).neighbors.add(copyNode);
            }
        }
    }



}