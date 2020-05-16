public class _136SingleNumber {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int n : nums){
            res = res ^ n;
        }
        return res;
    }
}
/*
Given a non-empty array of integers, every element appears twice except for one.
Find that single one.
Note:
Your algorithm should have a linear runtime complexity.
Could you implement it without using extra memory?
两个相同的数异或的结果为 0，对所有数进行异或操作，最后的结果就是单独出现的那个数。
 */
