public class _724FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int sum = 0, leftSum = 0;

        for (int i : nums){
            sum += i;
        }

        for (int i = 0; i < nums.length; i++){
            if (leftSum == sum - nums[i] - leftSum){
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}
