public class _268MissingNumber {
    public int missingNumber(int[] nums) {
        /*
        we know that nn definitely replaces the missing number in nums.
        Therefore, if we initialize an integer to nn and XOR it with every index and value,
        we will be left with the missing number.
         */
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            res = res ^ i ^ nums[i]; // ^ nums.length; doesn't work here
        }
        return res ^ nums.length;
    }
}
/*
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
find the one that is missing from the array.
 */
