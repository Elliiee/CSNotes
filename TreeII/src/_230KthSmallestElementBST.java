public class _230KthSmallestElementBST {
    // inorder DFS
    private int cnt = 0;
    private int val;

    public int kthSmallestIteration(TreeNode root, int k){
        inorder(root, k);
        return val;
    }

    private void inorder(TreeNode node, int k){
        if (node == null) return;

        inorder(node.left, k);
        cnt++;

        if (cnt == k){
            val = node.val;
            return;
        }
        inorder(node.right, k);
    }

    // recursion
    public int kthSmallest(TreeNode root, int k){
        int leftCnt = count(root.left);
        if (leftCnt == k - 1)
            return root.val;
        if (leftCnt > k -1)
            return kthSmallest(root.left, k);

        return kthSmallest(root.right, k - leftCnt - 1);
    }

    private int count(TreeNode node){
        if (node == null) return 0;
        return 1 + count(node.left) + count(node.right);
    }
}
