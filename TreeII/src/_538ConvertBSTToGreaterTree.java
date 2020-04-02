public class _538ConvertBSTToGreaterTree {
    private int sum;

    public TreeNode convertBST(TreeNode root){
        if (root == null) return null;

        traverse(root);
        return root;
    }

    private void traverse(TreeNode node){
        if (node == null) return;

        traverse(node.right);
        sum += node.val;
        node.val = sum;
        traverse(node.left);
    }
}
/*
Given a Binary Search Tree (BST),
convert it to a Greater Tree
such that every key of the original BST is changed to
the original key plus sum of all keys greater than the original key in BST.
 */