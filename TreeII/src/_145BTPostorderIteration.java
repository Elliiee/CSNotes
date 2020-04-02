import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class _145BTPostorderIteration {
    public List<Integer> postOrder(TreeNode root){
        List<Integer> result = new ArrayList<>();

        if (root == null) return result;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (node == null) continue;
            result.add(node.val);
            stack.push(node.left);
            stack.push(node.right);
        }
        Collections.reverse(result);
        return result;
    }
}
