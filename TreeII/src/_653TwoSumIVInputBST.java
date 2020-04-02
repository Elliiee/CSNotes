import java.util.ArrayList;
import java.util.List;

public class _653TwoSumIVInputBST {
    public boolean findTarget(TreeNode root, int k){
        List<Integer> nums = new ArrayList<>();
        inOrder(root,nums);
        int i = 0, j = nums.size() - 1;
        while (i < j){
            int sum = nums.get(i) + nums.get(j);
            if (sum == k)
                return true;
            if (sum < k)
                i++;
            else
                j--;
        }
        return false;
    }

    private void inOrder(TreeNode root, List<Integer> nums){
        if (root == null) return;
        inOrder(root.left, nums);
        nums.add(root.val);
        inOrder(root.right, nums);
    }
}
/*
Given a Binary Search Tree and a target number,
return true if there exist two elements in the BST such that their sum is equal to the given target.
 */
