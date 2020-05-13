import java.util.ArrayList;
import java.util.List;

public class _46Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        List<Integer> permute = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtracking(permute, permutations,  visited, nums);
        return permutations;
    }

    private void backtracking(List<Integer> permute, List<List<Integer>> permutations, boolean[] visited, int[] nums){
        if (permute.size() == nums.length){
            permutations.add(new ArrayList<>(permute));
            return;
        }

        for (int i = 0; i < visited.length; i++){
            if (visited[i])
                continue;

            visited[i] = true;
            permute.add(nums[i]);
            backtracking(permute, permutations, visited, nums);
            permute.remove(permute.size() - 1);
            visited[i] = false;
        }
    }
}
