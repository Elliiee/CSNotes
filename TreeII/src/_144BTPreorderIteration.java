import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _144BTPreorderIteration {
    public List<Integer> preorder(TreeNode root){
        List<Integer> result = new ArrayList<>();

        if (root == null) return result;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (node == null) continue;
            result.add(node.val);
            stack.push(node.right);
            stack.push(node.left);
        }
        return result;
    }
}
