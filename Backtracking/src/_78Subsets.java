import java.util.ArrayList;
import java.util.List;

public class _78Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        for (int size = 0; size <= nums.length; size++){
            backtracking(0, subset, subsets, size, nums);
        }
        return subsets;
    }

    private void backtracking(int start, List<Integer> subset, List<List<Integer>> subsets, int size, int[] nums){
        if (subset.size() == size){
            subsets.add(new ArrayList<>(subset));
            return;
        }
        for (int i = start; i < nums.length; i++){
            subset.add(nums[i]);
            backtracking(i + 1, subset, subsets, size, nums);
            subset.remove(subset.size() - 1);
        }
    }
}
/*
Given a set of distinct integers, nums, return all possible subsets (the power set).
Note: The solution set must not contain duplicate subsets.
 */
