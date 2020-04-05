import java.util.ArrayList;
import java.util.List;

public class _77Combinations {
    public List<List<Integer>> combine(int n, int k){
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        backtracking(combination, combinations, 1, k, n);
        return combinations;
    }

    private void backtracking(List<Integer> combination, List<List<Integer>> combinations,
                              int start, int k, int n){
        if (k == 0){
            combinations.add(new ArrayList<>(combination));
            return;
        }
        for (int i = start; i < n - k +1; i++){
            combination.add(i);
            backtracking(combination, combinations, i + 1, k - 1, n);
            combination.remove(combination.size() - 1);
        }
    }
}
/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 */
