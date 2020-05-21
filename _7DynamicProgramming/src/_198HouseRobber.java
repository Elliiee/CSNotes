public class _198HouseRobber {
    public int rob(int[] nums) {
        int preMax = 0;
        int curMax = 0;
        for (int x : nums){
            int temp = curMax;
            curMax = Math.max((preMax + x), curMax);
            preMax = temp;
        }
        return curMax;
    }
}
