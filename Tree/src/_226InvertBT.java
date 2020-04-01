public class _226InvertBT {
    public TreeNode invertTree(TreeNode root){
        if (root == null) return null;

        TreeNode left = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(left);

        return root;
    }
}
