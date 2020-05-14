public class _485MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums){
        int max = 0, cur = 0;
        for (int n : nums){
            cur = n == 0 ? 0 : cur + 1;
            max = Math.max(max, cur);
        }
        return max;
    }
}
/*
Given a binary array, find the maximum number of consecutive 1s in this array.
 */
