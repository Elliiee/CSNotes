public class _747LargestNumberLeastTwice {
    public int dominantIndex(int[] nums) {
        int maxIndex = 0;

        for (int i = 0; i < nums.length; i++){
            if (nums[i] > nums[maxIndex])
                maxIndex = i;
        }

        for (int j = 0; j < nums.length; j++){
            if (maxIndex != j && nums[maxIndex] < nums[j] * 2)
                return -1;
        }
        return maxIndex;
    }
}
