import java.util.ArrayList;
import java.util.List;

public class _39CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        backtracking(new ArrayList<>(), combinations, 0, target, candidates);
        return combinations;
    }

    private void backtracking(List<Integer> temp, List<List<Integer>> combinations,
                              int start, int target, int[] candidates){
        if (target == 0){
            combinations.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < candidates.length; i++){
            if (candidates[i] <= target){
                temp.add(candidates[i]);
                backtracking(temp, combinations, i, target - candidates[i], candidates);
                temp.remove(temp.size() - 1);
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
