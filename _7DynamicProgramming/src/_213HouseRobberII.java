public class _213HouseRobberII {
    public int rob(int[] nums){
        if (nums.length == 1){
            return nums[0];
        }

        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    private int rob(int[] num, int lo, int hi) {
        int include = 0, exclude = 0;
        for (int j = lo; j <= hi; j++) {
            int i = include, e = exclude;
            include = e + num[j];
            exclude = Math.max(e, i);
        }
        return Math.max(include, exclude);
    }
    /*
    We can divide this problem to two sub problems:
Let's take following example:
Sub problem 1: rob house 1 ~ 8
Sub problem 2: rob house 2 ~ 9
And find the bigger one of these two sub problems.
     */
}
