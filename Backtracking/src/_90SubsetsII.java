import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _90SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        for (int size = 0; size <= nums.length; size++){
            backtracking(0, subset, subsets, visited, size, nums);
        }
        return subsets;
    }

    private void backtracking(int start, List<Integer> subset, List<List<Integer>> subsets, boolean[] visited,
                              int size, int[] nums){
        if (subset.size() == size){
            subsets.add(new ArrayList<>(subset));
            return;
        }
        for (int i = start; i < nums.length; i++){
            if (i != 0 && nums[i] == nums[i-1] && !visited[i-1]){
                continue;
            }
            subset.add(nums[i]);
            visited[i] = true;
            backtracking(i + 1, subset, subsets, visited, size, nums);
            visited[i] = false;
            subset.remove(subset.size() - 1);
        }
    }
}
//含有相同元素求子集
