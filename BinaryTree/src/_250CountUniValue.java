public class _250CountUniValue {
    private int count;

    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) return 0;

        isUni(root);
        return count;
    }

    private boolean isUni(TreeNode root){
        if (root.left == null && root.right == null){
            count++;
            return true;
        }

        boolean isUniValue = true;

        if (root.left != null)
            isUniValue = isUni(root.left) && isUniValue && (root.val == root.left.val);

        if (root.right != null)
            isUniValue = isUni(root.right) && isUniValue && (root.val == root.right.val);

        if (!isUniValue)
            return false;

        count++;
        return true;
    }
}
