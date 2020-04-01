public class _337HouseRobberIII {
    public int rob(TreeNode root){
        if (root == null) return 0;

        int val1 = root.val;

        if (root.left != null)
            val1 += rob(root.left.left) + rob(root.left.right);

        if (root.right != null)
            val1 += rob(root.right.left) + rob(root.right.right);

        int val2 = rob(root.left) + rob(root.right);

        return Math.max(val1, val2);
    }
}
/*
The thief has found himself a new place for his thievery again.
There is only one entrance to this area, called the "root."
Besides the root, each house has one and only one parent house.
After a tour, the smart thief realized that "all houses in this place forms a binary tree".
It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

 */
