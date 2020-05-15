public class _287FindDuplicateNumber {
    public int findDuplicateBinarySearch(int[] nums){
        int l = 1, h = nums.length - 1;
        while (l < h){
            int mid = l + (h - l) / 2;
            int cnt = 0;
            for (int i = 0; i < nums.length; i++){
                if (nums[i] <= mid)
                    cnt++;
            }
            if (cnt > mid)
                h = mid - 1;
            else
                l = mid + 1;
        }
        return l;
    }

    //双指针解法，类似于有环链表中找出环的入口
    public int findDuplicateTwoPointers(int[] nums){
        int slow = nums[0], fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
/*
找出数组中重复的数，数组值在 [1, n] 之间
要求不能修改数组，也不能使用额外的空间
 */
