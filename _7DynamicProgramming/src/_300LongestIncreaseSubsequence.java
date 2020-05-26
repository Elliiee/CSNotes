import java.util.Map;

public class _300LongestIncreaseSubsequence {
    public int lengthOfLIS(int[] nums) {
        return lengthOfLIS(nums, Integer.MIN_VALUE, 0);
    }

    private int lengthOfLIS(int[] nums, int prevNum, int curIndex) {
        if (curIndex == nums.length)
            return 0;

        int taken = 0;

        // take the current number if it's larger than the previous one.
        if (nums[curIndex] > prevNum)
            taken = 1 + lengthOfLIS(nums, nums[curIndex], curIndex + 1 );

        // don't take the current number if it's larger than the previous one.
        int nottaken = lengthOfLIS(nums, prevNum, curIndex + 1);

        return Math.max(taken, nottaken);
    }

    public int lengthOfLISDP(int[] nums) {
        if (nums.length == 0)
            return 0;

        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < dp.length; i++){
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                maxval = Math.max(maxval, dp[j]);
            }
            dp[i] = maxval + 1;
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }
}
