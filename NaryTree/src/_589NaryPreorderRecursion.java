import java.util.LinkedList;
import java.util.List;

public class _589NaryPreorderRecursion {
    public List<Integer> preorder(Node root) {
        LinkedList<Integer> output = new LinkedList<>();
        helper(root, output);
        return output;
    }

    public void helper(Node root, List<Integer> output){
        if (root != null){
            output.add(root.val);
            for (Node n : root.children)
                helper(n, output);

        }
    }

}
