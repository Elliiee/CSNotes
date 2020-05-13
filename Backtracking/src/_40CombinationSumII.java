import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

public class _40CombinationSumII {
    public List<List<Integer>> combinationSumII(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        Arrays.sort(candidates);
        boolean[] visited = new boolean[candidates.length];
        backtracking(new ArrayList<>(), combinations, visited, 0, target, candidates);
        return combinations;
    }

    private void backtracking(List<Integer> temp, List<List<Integer>> combinations,
                              boolean[] visited, int start, int target, int[] candidates){
        if (target == 0){
            combinations.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < candidates.length; i++){
            if (i != 0 && candidates[i] == candidates[i-1] && !visited[i - 1]){
                continue;
            }
            if (candidates[i] <= target){
                temp.add(candidates[i]);
                visited[i] = true;
                backtracking(temp, combinations, visited, i, target - candidates[i], candidates);
                visited[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }
}
// the difference between 39 and 40 is this might have duplicated candidates
