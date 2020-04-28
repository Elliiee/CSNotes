import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class _145BinaryTreePostorderIteration {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (node == null) continue;
            result.add(node.val);
            stack.add(node.left);
            stack.add(node.right);
        }
        Collections.reverse(result);
        return result;
    }
}
