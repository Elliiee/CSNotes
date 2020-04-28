import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _144BinaryTreePreorderIteration {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (node == null) continue;
            result.add(node.val);
            stack.add(node.right);
            stack.add(node.left);
        }
        return result;
    }
}
