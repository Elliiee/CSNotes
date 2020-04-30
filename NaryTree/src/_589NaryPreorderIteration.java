import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class _589NaryPreorderIteration {
    public List<Integer> preorder(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) return result;
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            result.add(node.val);
            Collections.reverse(node.children);
            for (Node item : node.children)
                stack.add(item);
        }
        return result;
    }
}
