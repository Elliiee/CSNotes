import java.util.LinkedList;
import java.util.List;

public class _590NaryPostorder {
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> output = new LinkedList<>();
        helper(root, output);
        return output;
    }

    public void helper(Node root, List<Integer> output){
        if (root != null){
            for (Node n : root.children)
                helper(n, output);
            output.add(root.val);
        }
    }
}
