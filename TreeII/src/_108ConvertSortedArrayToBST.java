public class _108ConvertSortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums){
        return toBST(nums, 0, nums.length - 1);
    }

    private TreeNode toBST(int[] nums, int l, int r){
        if (l > r)
            return null;

        int mid = (l + r) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = toBST(nums, l, mid - 1);
        root.right = toBST(nums, mid + 1, r);

        return root;
    }
}
