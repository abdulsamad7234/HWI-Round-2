/*
// Definition for a Node.
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
    static Map<Node, Node> map;
    public Node cloneGraph(Node node) {
        map = new HashMap<>();
        if(node == null){
            return null;
        }
        Node clone = new Node(node.val);
        map.put(node, clone);
        DFS(node, clone);
        return clone;
    }

    public void DFS(Node node, Node clone){
        for(Node adjNode : node.neighbors){
            if(!map.containsKey(adjNode)){
                Node newClone = new Node(adjNode.val);
                map.put(adjNode, newClone);
                clone.neighbors.add(newClone);
                DFS(adjNode, newClone);
            }else{
                clone.neighbors.add(map.get(adjNode));
            }
        }
    }
}