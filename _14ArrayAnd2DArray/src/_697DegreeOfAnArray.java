import java.util.HashMap;
import java.util.Map;

public class _697DegreeOfAnArray {
    public int findShortestSubArray(int[] nums){
        Map<Integer, Integer> numsCnt = new HashMap<>();
        Map<Integer, Integer> numsLastIndex = new HashMap<>();
        Map<Integer, Integer> numsFirstIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            numsCnt.put(num, numsCnt.getOrDefault(num, 0) + 1);
            numsLastIndex.put(num, i);
            if (!numsFirstIndex.containsKey(num)) {
                numsFirstIndex.put(num, i);
            }
        }
        int maxCnt = 0;
        for (int num : nums) {
            maxCnt = Math.max(maxCnt, numsCnt.get(num));
        }
        int ret = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int cnt = numsCnt.get(num);
            if (cnt != maxCnt) continue;
            ret = Math.min(ret, numsLastIndex.get(num) - numsFirstIndex.get(num) + 1);
        }
        return ret;
    }
}
/*
Given a non-empty array of non-negative integers nums,
the degree of this array is defined as the maximum frequency of any one of its elements.
Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
 */
/*
An array that has degree d, must have some element x occur d times.
If some subarray has the same degree, then some element x (that occured d times), still occurs d times.
The shortest such subarray would be from the first occurrence of x until the last occurrence.

For each element in the given array,
let's call left, the index of its first occurrence;
and right, the index of its last occurrence.
For example, with nums = [1,2,3,2,5] we have left[2] = 1 and right[2] = 3.

Then, for each element x that occurs the maximum number of times,
right[x] - left[x] + 1 will be our candidate answer,
and we'll take the minimum of those candidates.
 */
