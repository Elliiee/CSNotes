public class _98ValidateBST {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode node, Integer low, Integer high){
        if (node == null)
            return true;

        if(low != null && node.val <= low)
            return false;
        if (high != null && node.val >= high)
            return false;

        if (!helper(node.left, low, node.val))
            return false;
        if (!helper(node.right, node.val, high))
            return false;

        return true;
    }
}
