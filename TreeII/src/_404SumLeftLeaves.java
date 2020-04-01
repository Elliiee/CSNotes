public class _404SumLeftLeaves {
    public int sumLeftLeaves(TreeNode root){
        if (root == null) return 0;

        if (isLeaf(root.left))
            return root.left.val + sumLeftLeaves(root.right);

        return sumLeftLeaves(root.left) + sumLeftLeaves(root.right);
    }

    private boolean isLeaf(TreeNode node){
        if (node == null) return false;
        return node.left == null && node.right == null;
    }
}
