public class _136SingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i : nums){
            result = result ^ i;
        }
        return result;
    }
}
