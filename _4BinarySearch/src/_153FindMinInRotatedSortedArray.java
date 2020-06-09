public class _153FindMinInRotatedSortedArray {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi-lo)/2;
            if (nums[mid] < nums[hi]) {
                // Case 1) Right side sorted, left side has pivot (minval), go left to find it
                // Case 2) Both sides sorted, go left to find the smallest value (minval)
                hi = mid;
            } else {
                // Case 1) Left side sorted, right side has pivot (minval), go right to find it
                lo = mid+1;
            }
        }
        // Loop exits when hi == lo == the smallest value in the array
        return nums[lo];
    }
}
