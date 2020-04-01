public class _437PathSumIII {
    public int pathSum(TreeNode root, int sum){
        if (root == null) return 0;

        int ret = pathSumFromRoot(root, sum)
                + pathSum(root.left, sum)
                + pathSum(root.right, sum); // move the "root" down

        return ret;
    }

    private int pathSumFromRoot(TreeNode root, int sum){
        if (root == null) return 0;

        int ret = 0;
        if (root.val == sum) ret++;

        ret += pathSumFromRoot(root.left, sum - root.val)
                + pathSumFromRoot(root.right, sum - root.val);

        return ret;
    }
}
/*
You are given a binary tree. Find the number of paths that sum up to the target value.
The path does not need to start or end at the root or a leaf.
But it must go downwards.
 */
