package _4BinarySearch.src;

public class BinarySearch {
    public int binarySearch(int[] nums, int target){
        int l = 0, h = nums.length - 1;
        while (l <= h){ // note there is "="
            int m = l + (h - l) / 2;
            if (nums[m] == target){
                return m;
            }
            else if (nums[m] > target){
                h = m - 1;
            }
            else
                l = m + 1;
        }
        return -1;
    }
}
