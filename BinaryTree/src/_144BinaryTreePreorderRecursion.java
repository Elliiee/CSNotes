import java.util.LinkedList;
import java.util.List;

public class _144BinaryTreePreorderRecursion {
    public List<Integer> preorderTraversal(TreeNode root){
        LinkedList<Integer> output = new LinkedList<>();
        helper(root, output);
        return output;
    }

    public void helper(TreeNode root, List<Integer> output){
        if (root != null){
            output.add(root.val);
            if (root.left != null) helper(root.left, output);
            if (root.right != null) helper(root.right, output);
        }
    }
}
