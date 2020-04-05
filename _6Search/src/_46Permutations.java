import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

public class _46Permutations {
    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> permutations = new ArrayList<>();
        List<Integer> permutation = new ArrayList<>();
        boolean[] hasVisited =  new boolean[nums.length];
        backtracking(permutation, permutations, hasVisited, nums);
        return permutations;
    }

    private void backtracking(List<Integer> permutation, List<List<Integer>> permutations,
                              boolean[] visited, final int[] nums){
        if (permutation.size() == nums.length){
            permutations.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i < nums.length; i++){
            if (visited[i]) continue;

            visited[i] = true;
            permutation.add(nums[i]);
            backtracking(permutation, permutations, visited, nums);
            permutation.remove(permutation.size() - 1);
            visited[i] = false;
        }
    }
}
/*
Given a collection of distinct integer, return all possible permutations.
 */
