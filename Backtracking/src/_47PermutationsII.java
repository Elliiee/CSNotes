import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _47PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        List<Integer> permutation = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        backtracking(permutation, permutations, visited, nums);
        return permutations;
    }

    private void backtracking(List<Integer> permutation, List<List<Integer>> permutations, boolean[] visited, int[] nums){
        if (permutation.size() == nums.length){
            permutations.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i < visited.length; i++){
            if (i != 0 && nums[i] == nums[i - 1] && !visited[i - 1]){
                continue;
            }
            if (visited[i])
                continue;
            visited[i] = true;
            permutation.add(nums[i]);
            backtracking(permutation, permutations, visited, nums);
            permutation.remove(permutation.size() - 1);
            visited[i] = false;
        }
    }
}
/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.
在实现上，和 Permutations 不同的是要先排序，然后在添加一个元素时，判断这个元素是否等于前一个元素，
如果等于，并且前一个元素还未访问，那么就跳过这个元素。
 */
