import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;

public class _646MaxLengthOfPairChain {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int N = pairs.length;
        int[] dp = new int[N];
        Arrays.fill(dp, 1);

        for (int j = 1; j < N; ++j) {
            for (int i = 0; i < j; ++i) {
                if (pairs[i][1] < pairs[j][0])
                    dp[j] = Math.max(dp[j], dp[i] + 1);
            }
        }

        int ans = 0;
        for (int x : dp){
            if (x > ans)
                ans = x;
        }
        return ans;
    }

    public int findLongestChainGreedy(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int cur = Integer.MIN_VALUE, ans = 0;

        for (int[] pair : pairs){
            if (cur < pair[0]){
                cur = pair[1];
                ans++;
            }
        }
        return ans;
    }
}
