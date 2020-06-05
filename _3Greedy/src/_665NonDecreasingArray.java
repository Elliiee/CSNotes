public class _665NonDecreasingArray {
    public boolean checkPossibility(int[] nums) {
        int cnt = 0;
        for (int i = 1; i < nums.length && cnt < 2; i++){
            if (nums[i] >= nums[i-1]) // increasing, no need to change, go to next loop i
                continue;

            cnt++; // when this step happens, means decreased here

            // nums[i] > nums[i-1] AND nums[i - 2] > nums[i]
            if (i - 2 >= 0 && nums[i - 2] > nums[i])
                nums[i] = nums[i - 1]; // special case
            else
                nums[i-1] = nums[i]; // keep the small number is wiser for later comparasion

        }
        return cnt <= 1;
    }
}
