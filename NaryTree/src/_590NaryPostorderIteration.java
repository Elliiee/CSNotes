import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class _590NaryPostorderIteration {
    public List<Integer> postorder(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) return result;
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            result.addFirst(node.val);
            for (Node item : node.children)
                if (item != null)
                    stack.add(item);
        }
        return result;
    }
}
