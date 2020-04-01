public class _110BalancedBT {
    private boolean balanced = true;

    public boolean isBalanced(TreeNode root){
        maxDepth(root);
        return balanced;
    }

    public int maxDepth(TreeNode root){
        if (root == null) return 0;

        int l = maxDepth(root.left);
        int r = maxDepth(root.right);

        if (Math.abs(l - r) > 1)
            balanced = false;

        return Math.max(l, r) + 1;
    }
}
