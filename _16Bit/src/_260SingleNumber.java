public class _260SingleNumber {
        public  int[] singleNumberIII(int[] nums){
            int bitmask = 0;
            for (int n : nums){
                bitmask ^= n;
            }
            int diff = bitmask & (-bitmask);
            int x = 0;
            for (int n : nums){
                if ((n & diff) != 0)
                    x ^= n;
            }
            return new int[] {x, bitmask ^ x};
        }
}
/*
Given an array of numbers nums, in which exactly two elements appear only once
and all the other elements appear exactly twice. Find the two elements that appear only once.
Example:
Input:  [1,2,1,3,2,5]
Output: [3,5]
Note:
The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity.
Could you implement it using only constant space complexity?
 */
/*
两个不相等的元素在位级表示上必定会有一位存在不同。
将数组的所有元素异或得到的结果为不存在重复的两个元素异或的结果。
diff &= -diff 得到出 diff 最右侧不为 0 的位，
也就是不存在重复的两个元素在位级表示上最右侧不同的那一位，利用这一位就可以将两个元素区分开来
 */
