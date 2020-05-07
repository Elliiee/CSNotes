

import java.util.ArrayList;
import java.util.HashMap;

public class _133CloneGraph {
    HashMap<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node){
        if (node == null)
            return null;

        if (visited.containsKey(node)){
            return visited.get(node);
        }

        Node clonedNode = new Node(node.val, new ArrayList<>());
        visited.put(node, clonedNode);

        for (Node n : node.neighbors){
            clonedNode.neighbors.add(cloneGraph(n));
        }

        return clonedNode;
    }
}
