import java.util.ArrayList;
import java.util.List;

public class _216CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n){
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        backtracking(k, n, 1, combination, combinations);
        return combinations;
    }
    private void backtracking(int k, int n, int start, List<Integer> combination,List<List<Integer>> combinations){
        if (k == 0 && n == 0){
            combinations.add(new ArrayList<>(combination));
            return;
        }
        if (k == 0 || n == 0) return;

        for (int i = start; i <= 9; i++){
            combination.add(i);
            backtracking(k - 1, n - i, i + 1, combination, combinations);
            combination.remove(combination.size() - 1);
        }
    }
}
