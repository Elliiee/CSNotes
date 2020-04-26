public class _66PlusOne {
    public int[] plusOne(int[] digits) {
        int N = digits.length;
        for (int i = N - 1; i >= 0; i--){
            if (digits[i] == 9){
                digits[i] = 0;
            }
            else {
                digits[i]++;
                return digits;
            }
        }
        digits = new int[N+1];
        digits[0] = 1;
        return digits;
    }
}
