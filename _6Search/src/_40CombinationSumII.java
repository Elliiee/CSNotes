import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _40CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(new ArrayList<>(), combinations, new boolean[candidates.length], 0, target, candidates);
        return combinations;
    }

    private void backtracking(List<Integer> combination, List<List<Integer>> combinations,
                              boolean[] visited, int start, int target, int[] nums){
        if (target == 0){
            combinations.add(new ArrayList<>(combination));
            return;
        }

        for (int i = start; i < nums.length; i++){
            if (i != 0 && nums[i] == nums[i-1] && !visited[i-1]) continue;

            if (nums[i] <= target){
                combination.add(nums[i]);
                visited[i] = true;
                backtracking(combination, combinations, visited, i + 1, target - nums[i], nums);
                visited[i] = false;
                combination.remove(combination.size() - 1);
            }
        }
    }
}
