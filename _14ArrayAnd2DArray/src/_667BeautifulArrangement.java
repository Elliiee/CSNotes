public class _667BeautifulArrangement {
    public int[] constructArray(int n, int k) {
        int[] ret = new int[n];
        ret[0] = 1;
        for (int i = 1, interval = k; i <= k; i++, interval--){
            ret[i] = i % 2 == 1 ? ret[i - 1] + interval : ret[i - 1] - interval;
        }
        for (int i = k + 1; i < n; i++){
            ret[i] = i + 1;
        }
        return ret;
    }
}
/*
Given two integers n and k, you need to construct a list which contains n different positive integers
ranging from 1 to n and obeys the following requirement:
Suppose this list is [a1, a2, a3, ... , an],
then the list [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] has exactly k distinct integers.
If there are multiple answers, print any of them.
题目描述：数组元素为 1~n 的整数，要求构建数组，使得相邻元素的差值不相同的个数为 k。
让前 k+1 个元素构建出 k 个不相同的差值，序列为：1 k+1 2 k 3 k-1 ... k/2 k/2+1.
 */
