import java.util.ArrayList;
import java.util.List;

public class _39CombinationSum {
    public List<List<Integer>> combinationSum(int[] nums, int target){
        List<List<Integer>> combinations = new ArrayList<>();
        backtracking(new ArrayList<>(), combinations, 0, target, nums);
        return combinations;
    }
    private void backtracking(List<Integer> combination, List<List<Integer>> combinations,
                              int start, int target, int[] nums){
        if (target == 0){
            combinations.add(new ArrayList<>(combination));
            return;
        }
        for (int i = start; i < nums.length; i++){
            if (nums[i] <= target){
                combination.add(nums[i]);
                backtracking(combination, combinations, i, target - nums[i], nums);
                combination.remove(combination.size() - 1);
            }
        }
    }
}
/*
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
 */
