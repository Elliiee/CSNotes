public class _530MiniAbsDifferenceBST {
    private int minDiff = Integer.MAX_VALUE;
    private TreeNode preNode = null;

    public int getMinimumDifference(TreeNode root){
        inorder(root);
        return minDiff;
    }

    private void inorder(TreeNode node){
        if (node == null) return;
        inorder(node.left);
        if (preNode != null)
            minDiff = Math.min(minDiff, node.val - preNode.val);
        preNode = node;
        inorder(node.right);
    }
}
/*
Given a binary search tree with non-negative values,
find the minimum absolute difference between values of any two nodes.
 */