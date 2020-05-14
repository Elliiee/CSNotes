public class _283MoveZeroes {
    public void moveZeroes(int[] nums){
        int idx = 0;
        for (int num : nums){
            if (num != 0){
                nums[idx++] = num;
            }
        }
        while (idx < nums.length){
            nums[idx++] = 0;
        }
    }
}
//把数组中的 0 移到末尾