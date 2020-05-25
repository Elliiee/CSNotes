public class _413ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        int[] dp = new int[A.length];
        int sum = 0;
        for (int i = 2; i < A.length; i++){
            if (A[i] - A[i-1] == A[i-1] - A[i-2]){
                dp[i] = 1 + dp[i-1];
                sum += dp[i];
            }
        }
        return sum;
    }

    public int numberOfArithmeticSlicesII(int[] A) {
        int dp = 0;
        int sum = 0;
        for (int i = 2; i < A.length; i++){
            if (A[i] - A[i-1] == A[i-1] - A[i-2]){
                dp = 1 + dp;
                sum += dp;
            }
            else
                dp = 0;
        }
        return sum;
    }
    // constant space
}
